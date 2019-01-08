package inject.proxy;

import inject.proxy.classz.People;
import inject.proxy.classz.PeopleImp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        People people = (People) ProxyCreator.on(People.class, new PeopleImp())
                .callAll()
                .but("say")
//                .create();
                .create(new HookListener() {
                    @Override
                    public boolean isInterceptedBeforeHookedMethod(Method method, Object[] args) {
                        String methodName = method.getName();
                        System.out.println("before " + methodName);
                        return false;
                    }

                    @Override
                    public Object hookedMethod(Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                        return method.invoke(target, args);
                    }

                    @Override
                    public void afterHookedMethod(Method method, Object[] args) {
                        String methodName = method.getName();
                        System.out.println("after " + methodName);
                    }
                });


        System.gc();
        people.run();
        System.out.println("==============================");
        people.say();


    }
}
