package inject.inject2;

import java.lang.reflect.*;

public class Main {

    //http://wingjay.com/2017/04/26/Java-%E6%8A%80%E6%9C%AF%E4%B9%8B%E5%8F%8D%E5%B0%84/
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        try {
            Class clazzUserBean = Class.forName("inject.inject2.UserBean");
            printClassFields(clazzUserBean);
            System.out.println("=============");
            printClassMethods(clazzUserBean);
            System.out.println("=============");
            printClassConstructors(clazzUserBean);
            System.out.println("=============");
            handleClassMethods(clazzUserBean);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void printClassFields(Class clazzUserBean) {

        Field[] fields = clazzUserBean.getFields();

        System.out.println(fields.length);

        //private 属性无法获取
        for(Field field : fields) {
            String fieldString = "";
            fieldString += Modifier.toString(field.getModifiers()) + " "; // `private`
            fieldString += field.getType().getSimpleName() + " "; // `String`
            fieldString += field.getName(); // `userName`
            fieldString += ";";
            System.out.println(fieldString);
        }

    }


    private static void printClassMethods(Class clazzUserBean) {

        Method[] methods = clazzUserBean.getDeclaredMethods();
        for (Method method : methods) {
            String methodString = Modifier.toString(method.getModifiers()) + " " ; // private static
            methodString += method.getReturnType().getSimpleName() + " "; // void
            methodString += method.getName() + "("; // staticMethod
            Class[] parameters = method.getParameterTypes();
            for (Class parameter : parameters) {
                methodString += parameter.getSimpleName() + " "; // String
            }
            methodString += ")";
            System.out.println(methodString);
        }
    }
    private static void printClassConstructors(Class clazzUserBean) {

        // constructors
        Constructor[] constructors = clazzUserBean.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String s = Modifier.toString(constructor.getModifiers()) + " ";
            s += constructor.getName() + "(";
            Class[] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters) {
                s += parameter.getSimpleName() + ", ";
            }
            s += ")";
            System.out.println(s);
        }
    }


    private static void handleClassMethods(Class clazzUserBean) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Method[] methods = clazzUserBean.getDeclaredMethods(); // 获取所有成员方法
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) { // 判断是否被 @Invoke 修饰
                if (Modifier.isStatic(method.getModifiers())) { // 如果是 static 方法
                    method.invoke(null, "wingjay"); // 直接调用，并传入需要的参数 devName
                } else {
                    Class[] params = {String.class, long.class};
                    Constructor constructor = clazzUserBean.getDeclaredConstructor(params); // 获取参数格式为 String,long 的构造函数
                    Object userBean = constructor.newInstance("wingjay", 11); // 利用构造函数进行实例化，得到 Object
                    if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true); // 如果是 private 的方法，需要获取其调用权限
                    }
                    method.invoke(userBean); // 调用 method，无须参数
                }
            }
        }
    }
}
