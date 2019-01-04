package inject.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by joybar on 2019/1/4.
 */
public interface HookListener {

    void beforeHookedMethod(Method method, Object[] args);

    Object hookedMethod(Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;

    boolean isIntercept();

    void afterHookedMethod(Method method, Object[] args);
}
