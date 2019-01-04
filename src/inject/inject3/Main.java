package inject.inject3;

import inject.utils.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("Hello World!");


        User3 user3 = ReflectionUtils.getInstanceByPrivateConstructor(User3.class);
        user3.setAge("3");

        System.out.println("user3.getAge() = "+user3.getAge());


        User4 user4 = ReflectionUtils.getInstanceByPublicConstructor(User4.class);
        user4.setAge("3");

        System.out.println("User4.getAge() = "+user4.getAge());

    }
}
