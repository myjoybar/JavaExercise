package inject.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by joybar on 2019/1/4.
 */
public class ProxyHandler<T> implements InvocationHandler {

    private T target;
    private HookListener hookListener;

    public ProxyHandler(T target, HookListener hookListener) {
        this.target = target;
        this.hookListener = hookListener;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        // obj = method.invoke(target, args);
        if (hookListener == null) {
            obj = method.invoke(target, args);
        } else if (!hookListener.isIntercept()) {
            hookListener.beforeHookedMethod(method, args);
            obj = hookListener.hookedMethod(target, method, args);
            hookListener.afterHookedMethod(method, args);
        }

        return obj;
    }


}
