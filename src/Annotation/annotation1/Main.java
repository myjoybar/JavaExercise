package Annotation.annotation1;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        try {
            Class cls = Class.forName("Annotation.annotation1.App");
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(
                        MethodInfo.class);
                if (methodInfo != null) {
                    System.out.println("method name:" + method.getName());
                    System.out.println("method author:" + methodInfo.author());
                    System.out.println("method version:" + methodInfo.version());
                    System.out.println("method date:" + methodInfo.date());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
