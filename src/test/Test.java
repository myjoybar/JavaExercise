package test;

/**
 * Created by joybar on 2017/5/16.
 */
public class Test {
    private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK = 0x3 << MODE_SHIFT;

    public static final int UNSPECIFIED = 0 << MODE_SHIFT;
    public static final int EXACTLY = 1 << MODE_SHIFT;
    public static final int AT_MOST = 2 << MODE_SHIFT;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("UNSPECIFIED="+UNSPECIFIED);
        System.out.println("EXACTLY="+EXACTLY);
        System.out.println("AT_MOST="+AT_MOST);
    }

}
