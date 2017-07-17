package Proxy.demo1;

import Proxy.demo1.interfaces.IHello;
import java.lang.reflect.Proxy;
public class Main {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IHello iHello=(IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),//加载接口的类加载器
                new Class[]{IHello.class},
                new MyInvocationHandler(new HelloIml()));
        iHello.sayHello();


    }
}
