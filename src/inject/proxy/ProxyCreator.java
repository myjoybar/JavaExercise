package inject.proxy;

/**
 * Created by joybar on 2019/1/4.
 */
public class ProxyCreator<T> {

    private final Class<?> interfaceClass;
    private final Object target;
    private String[] callMethodNames;
    private String[] ignoreMethodNames;
    private ProxyHandler proxyHandler;

    public ProxyCreator(Class<?> interfaceClass, Object target) {
        this.interfaceClass = interfaceClass;
        this.target = target;
    }

    public static ProxyCreator on(Class<?> interfaceClass, Object onTarget) {
        return new ProxyCreator(interfaceClass, onTarget);
    }

    public ProxyCreator callAll() {
        return call(null);
    }
    public ProxyCreator call(String... callMethodNames) {
        this.callMethodNames = callMethodNames;
        return this;
    }


    public ProxyCreator but(String... ignoreMethodNames) {
        this.ignoreMethodNames = ignoreMethodNames;
        return this;
    }

    public Object create() {
        return create(null);
    }

    public Object create(HookListener hookListener) {
        proxyHandler = new ProxyHandler(target, hookListener,callMethodNames,ignoreMethodNames);
        Object object = java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, proxyHandler);
        return object;

    }




}
