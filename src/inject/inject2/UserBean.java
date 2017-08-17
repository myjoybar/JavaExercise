package inject.inject2;

/**
 * Created by joybar on 2017/6/9.
 */
public class UserBean {

    public String userName="Tom";
    public static int age =3;

    private long userId;


    public UserBean() {
    }

    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public UserBean(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }

    public long getId() {
        return userId;
    }

    @Invoke
    public static void staticMethod(String devName) {
        System.out.printf("Hi %s, I'm a static method", devName);
    }

    @Invoke
    public void publicMethod() {
        System.out.println("I'm a public method");
    }

    @Invoke
    private void privateMethod() {
        System.out.println("I'm a private method");
    }


    public void invokeMethod() {
        System.out.println("invokeMethod");
    }
    public void invokeMethod1(String s) {
        System.out.println(s+"——"+"invokeMethod");
    }

    public void invokeMethod2(String s,Integer i) {
        System.out.println(s+"——"+"invokeMethod"+i);
    }

    public static void invokeMethodStatic(String s,Integer i) {
        System.out.println(s+"——"+"invokeMethodStatic"+i);
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
