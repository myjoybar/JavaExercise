package Proxy.demo1;

import Proxy.demo1.interfaces.IHello;

/**
 * Created by joybar on 2017/7/17.
 */
public class HelloIml implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
