package Proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by joybar on 2017/7/17.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;//目标对象
    public MyInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object rs=method.invoke(target,args);

        Type returnType = method.getGenericReturnType();
        System.out.println("after"+returnType.getTypeName());
        return  rs;

    }
}
