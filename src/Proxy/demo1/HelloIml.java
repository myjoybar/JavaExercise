package Proxy.demo1;

import Proxy.demo1.interfaces.IHello;
import data.User;

/**
 * Created by joybar on 2017/7/17.
 */
public class HelloIml implements IHello {
    @Override
    public User sayHello() {
        System.out.println("Hello World");
        return null;
    }
}
