package Annotation.annotation4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        UserBean userBean = new UserBean("Tom",222);
        printAlias(userBean);
        doTest(userBean);


    }


    private static void printAlias(Object userBeanObject) {
        for (Field field : userBeanObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Alias.class)) {
                Alias alias = field.getAnnotation(Alias.class);
                System.out.println("alias.value()="+alias.value());
            }
        }
    }

    private static void doTest(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                try {
                    String methodName = test.value().length() == 0 ? method.getName() : test.value(); // if test.value() is empty, use `method.getName()`
                    System.out.printf("Testing. methodName: %s, id: %s\n", methodName, test.id());

                    if (Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null); // static method
                    } else if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);  // private method
                        method.invoke(object);
                    } else {
                        method.invoke(object);  // public method
                    }

                    System.out.printf("PASS: Method id: %s\n", test.id());
                } catch (Exception e) {
                    System.out.printf("FAIL: Method id: %s\n", test.id());
                    e.printStackTrace();
                }
            }
        }
    }
}
