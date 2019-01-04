package inject.proxy;

import inject.proxy.classz.People;
import inject.proxy.classz.PeopleImp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        People people= (People) ProxyCreator.on(People.class,new PeopleImp()).hook(new HookListener() {
            @Override
            public void beforeHookedMethod(Method method, Object[] args) {
                String methodName = method.getName();
                if(methodName.equals("run")){
                    System.out.println("before "+methodName);
                }
            }

            @Override
            public Object hookedMethod(Object target,Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                return method.invoke(target, args);
            }

            @Override
            public boolean isIntercept() {
                return false;
            }

            @Override
            public void afterHookedMethod(Method method, Object[] args) {
                String methodName = method.getName();
                if(methodName.equals("run")){
                    System.out.println("after "+methodName);
                }
            }
        });



        people.run();
        System.out.println("==============================");
        people.say();



    }
}
