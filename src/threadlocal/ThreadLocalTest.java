package threadlocal;

/**
 * Created by joybar on 2018/12/17.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        test();
    }

    private static  void  test(){

         ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();
         mBooleanThreadLocal.set(true);

        System.out.println("Current Thread: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());

        new Thread("Thread#1"){
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                System.out.println( "Thread 1: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());

            }
        }.start();

        new Thread("Thread#2"){
            @Override
            public void run() {
                System.out.println("Thread 2: mBooleanThrealLocal is : " + mBooleanThreadLocal.get());

            }
        }.start();


    }

}
