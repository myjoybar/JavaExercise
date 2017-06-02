package inject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("Hello World!");

        SinggleInstance singgleInstance1 = SinggleInstance.newInstance();

        singgleInstance1.setAge(5);

        System.out.println("singgleInstance1.getAge()="+singgleInstance1.getAge());
        SinggleInstance singgleInstance2 = SinggleInstance.newInstance();

        System.out.println("singgleInstance2.getAge()="+singgleInstance2.getAge());

        System.out.println(singgleInstance1==singgleInstance2);


        Class clazz = Class.forName("inject.SinggleInstance");

        Method method = clazz.getMethod("newInstance");

        SinggleInstance singgleInstance3 = (SinggleInstance) method.invoke(null);
        System.out.println("singgleInstance3.getAge()="+singgleInstance3.getAge());

        System.out.println(singgleInstance1==singgleInstance3);

    }
}
