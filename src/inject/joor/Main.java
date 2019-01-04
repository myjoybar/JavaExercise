package inject.joor;

import inject.inject3.User3;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {



        User3 user3 = Reflect.on(User3.class).create().get();
        user3.setAge("3");

        System.out.println("user3.getAge() = "+user3.getAge());


    }
}
