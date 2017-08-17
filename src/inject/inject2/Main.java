package inject.inject2;

import java.lang.reflect.*;

public class Main {

    //http://wingjay.com/2017/04/26/Java-%E6%8A%80%E6%9C%AF%E4%B9%8B%E5%8F%8D%E5%B0%84/
   // http://blog.csdn.net/mr_tim/article/details/51594717
    public static void main(String[] args) throws Exception {

        try {
            Class clazzUserBean = Class.forName("inject.inject2.UserBean");
            printClassFields(clazzUserBean);
            System.out.println("=============");
            printClassMethods(clazzUserBean);
            System.out.println("=============");
            printClassConstructors(clazzUserBean);
            System.out.println("=============");
            handleClassMethods(clazzUserBean);

            System.out.println("=============getProperty");

            getProperty(clazzUserBean,"userName");

            System.out.println("=============getStaticProperty");
            getStaticProperty(clazzUserBean,"age");

            System.out.println("=============invokeMethod,无参数");

            invokeMethod(clazzUserBean,"invokeMethod");
            System.out.println("=============invokeMethod,有一个参数");
            Object[]  args1 = {"sss"};
            invokeMethod1(clazzUserBean,"invokeMethod1",args1);
            System.out.println("=============invokeMethod,有两个参数");
            Object[]  args2 = {"sss",new Integer(22)};
            invokeMethod1(clazzUserBean,"invokeMethod2",args2);
            Object[]  args3 = {"sss",new Integer(22)};
            System.out.println("=============invokeMethodStatic,有两个参数");
            invokeStaticMethod(clazzUserBean,"invokeMethodStatic",args3);

            System.out.println("=============新建实例");
            Object[]  args4 = {"Jim"};
            newInstance("inject.inject2.UserBean",args4);

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

    /**
     * 1. 得到某个对象的属性
     */
    public static Object getProperty(Class clazzUserBean, String fieldName) throws Exception {

        Object obj = clazzUserBean.newInstance();
        if(obj instanceof UserBean){
            System.out.println("is UserBean");
        }
        Field field = clazzUserBean.getField(fieldName);
        Object property = field.get(obj);
        System.out.println(fieldName+"="+property.toString());
        return property;
    }

    /**
     * 2. 得到某个类的静态属性
     */

    public  static Object getStaticProperty(Class clazzUserBean, String fieldName)
            throws Exception {

        Field field = clazzUserBean.getField(fieldName);
        Object property = field.get(clazzUserBean);
        System.out.println(fieldName+"="+property.toString());
        return property;
    }
    /**
     * 3. 执行某对象的方法 无参数
     */
    public static Object invokeMethod(Class clazzUserBean, String methodName) throws Exception {

        Object obj = clazzUserBean.newInstance();
        if(obj instanceof UserBean){
            System.out.println("is UserBean");
        }

        Method method = clazzUserBean.getMethod(methodName);
        return method.invoke(obj);
    }

    /**
     * 3. 执行某对象的方法 参数
     */
    public static Object invokeMethod1(Class clazzUserBean, String methodName, Object[]  args) throws Exception {

        Object obj = clazzUserBean.newInstance();
        if(obj instanceof UserBean){
            System.out.println("is UserBean");
        }

        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

         Method method = clazzUserBean.getMethod(methodName,argsClass);
       // Method method = clazzUserBean.getMethod(methodName,new Class[]{String.class});

        return method.invoke(obj,args);
    }


    /**
     * 4. 执行某个类的静态方法

     */
    public  static Object invokeStaticMethod(Class clazzUserBean, String methodName,
                                     Object[] args) throws Exception {

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = clazzUserBean.getMethod(methodName,argsClass);

        return method.invoke(null, args);
    }

    /**
     *    5. 新建实例
     */

    public  static Object newInstance(String className, Object[] args) throws Exception {
        Class newoneClass = Class.forName(className);

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Constructor cons = newoneClass.getConstructor(argsClass);
        UserBean userBean = (UserBean) cons.newInstance(args);
        System.out.println("userBean="+userBean.toString());
        return cons.newInstance(args);

    }
}
