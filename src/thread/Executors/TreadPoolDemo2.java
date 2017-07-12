package thread.Executors;

import java.util.concurrent.*;

/**
 * Created by joybar on 2017/7/11.
 */
public class TreadPoolDemo2 {

    //http://www.jianshu.com/p/e98fe979d7bf
    //https://segmentfault.com/a/1190000000394999?utm_source=tuicool&utm_medium=referral
    public static void main(String[] args) {

        System.out.println("Hello World!");
       // threadPoolEcecutor();
        fixEcecutor();

    }

    static private void threadPoolEcecutor() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 15, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 15; i++) {
            final String name = "第" + i + "个线程";
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(name + "0s");
                    try {
                        Thread.sleep(1000);
                        System.out.println(name + "1s");
                        Thread.sleep(1000);
                        System.out.println(name + "2s");
                        Thread.sleep(1000);
                        System.out.println(name + "3s");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }


   static private void fixEcecutor(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0 ;i<15;i++){
            final String name = "第"+i+"个线程";
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(name+"0s");
                    try {
                        Thread.sleep(1000);
                        System.out.println(name+"1s");
                        Thread.sleep(1000);
                        System.out.println(name+"2s");
                        Thread.sleep(1000);
                        System.out.println(name+"3s");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
