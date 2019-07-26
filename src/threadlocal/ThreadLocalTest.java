package threadlocal;

/**
 * Created by joybar on 2018/12/17.
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World!");
        test();
    }

    private static void test() throws InterruptedException {

        ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();
        ThreadLocal<Integer> mIntThreadLocal = new ThreadLocal<>();
        mBooleanThreadLocal.set(true);
        mIntThreadLocal.set(1);

        System.out.println("Current Thread: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());
        System.out.println("Current Thread: mIntThreadLocal is : " + mIntThreadLocal.get());

        new Thread("Thread#1") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                System.out.println("Thread 1: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());

            }
        }.start();

        Thread.sleep(1 * 1000);
        new Thread("Thread#2") {
            @Override
            public void run() {
                System.out.println("Thread 2: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());
                System.out.println("Thread 2: mIntThreadLocal is : " + mIntThreadLocal.get());

            }
        }.start();


    }

}
