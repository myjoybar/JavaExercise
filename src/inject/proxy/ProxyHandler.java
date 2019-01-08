package inject.proxy;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by joybar on 2019/1/4.
 */
public class ProxyHandler<T> implements InvocationHandler {

    private HookListener hookListener;
    private SoftReference softReferenceTarget;
    // private WeakReference weakReferenceTarget;
    private String[] callMethodNames;
    private String[] ignoreMethodNames;

    public ProxyHandler(T target, HookListener hookListener, String[] callMethodNames, String[] ignoreMethodNames) {
        this.hookListener = hookListener;
        this.softReferenceTarget = new SoftReference(target);
        // this.weakReferenceTarget = new WeakReference(target);
        this.callMethodNames = callMethodNames;
        this.ignoreMethodNames = ignoreMethodNames;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (null == softReferenceTarget || null == softReferenceTarget.get()) {
            return null;
        }
        String methodName = method.getName();
        Object obj = null;
        if (isHookMethod(methodName) && hookListener != null && !hookListener.isInterceptedBeforeHookedMethod(method, args)) {
            obj = hookListener.hookedMethod(softReferenceTarget.get(), method, args);
            hookListener.afterHookedMethod(method, args);
        } else {
            obj = method.invoke(softReferenceTarget.get(), args);
        }
        return obj;
    }

    boolean isHookMethod(String methodName) {
        if (null == callMethodNames && ignoreMethodNames == null) {
            return true;
        }
        if (null != callMethodNames) {
            int lengthCallMethodNames = callMethodNames.length;
            for (int i = 0; i < lengthCallMethodNames; i++) {
                if (methodName.equals(callMethodNames[i])) {
                    return true;
                }
            }
        }
        if (null != ignoreMethodNames) {
            int lengthIgnoreMethodNames = ignoreMethodNames.length;
            for (int i = 0; i < lengthIgnoreMethodNames; i++) {
                if (methodName.equals(ignoreMethodNames[i])) {
                    return false;
                }
            }
        }

        if (callMethodNames != null && ignoreMethodNames == null) {
            return false;
        }
        if (callMethodNames == null && ignoreMethodNames != null) {
            return true;
        }

        return true;

    }

}
