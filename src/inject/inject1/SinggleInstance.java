package inject.inject1;

/**
 * Created by joybar on 2017/6/2.
 */
public class SinggleInstance {


    private int age;


    private SinggleInstance() {
    }

    private static class SinggleInstanceHolder {

        private static final SinggleInstance INSTANCE = new SinggleInstance();
    }

    public static SinggleInstance newInstance() {
        return SinggleInstanceHolder.INSTANCE;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
