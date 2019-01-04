package inject.proxy;

/**
 * Created by joybar on 2019/1/4.
 */
public class ProxyCreator<T> {

    private final Class<?> interfaceClass;
    private final Object target;
    private ProxyHandler proxyHandler;

    public ProxyCreator(Class<?> interfaceClass, Object target) {
        this.interfaceClass = interfaceClass;
        this.target = target;
    }


    public static ProxyCreator on(Class<?> interfaceClass, Object onTarget) {
        return new ProxyCreator(interfaceClass, onTarget);
    }


    public Object hook() {
        return hook(null);
    }

    public Object hook(HookListener hookListener) {

        proxyHandler = new ProxyHandler(target, hookListener);
        Object object = java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, proxyHandler);
        return object;

    }


}
