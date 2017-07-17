package Proxy.demo2;

import Proxy.demo2.interfaces.Subject;

/**
 * Created by joybar on 2017/7/17.
 */
public class RealSubject implements Subject
{
    public void doSomething()
    {
        System.out.println( "call doSomething()" );
    }
}