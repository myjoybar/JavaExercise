package thread.Executors;

import Annotation.annotation1.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by joybar on 2017/7/11.
 */
public class ThreadPoolDemo {
    //http://gityuan.com/2016/01/16/thread-pool/

    public static void main(String[] args) {

        newCachedThreadPool();
        //  fixedThreadPoolDemo();
        //  singleThreadExecutorDemo();
        // scheduledThreadPoolDemo();

    }


  static   public void newCachedThreadPool(){

      /**
       * 创建一个可缓存的无界线程池，该方法无参数。当线程池中的线程空闲时间超过60s则会自动回收该线程，
       * 当任务超过线程池的线程数则创建新线程。线程池的大小上限为Integer.MAX_VALUE，可看做是无限大。
       */
      ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


        for (int i = 0; i < 50; i++) {
            final int index = i;

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", index="+index);
                }
            });

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }


    static  public void fixedThreadPoolDemo(){
        /**
         * 创建一个固定大小的线程池，该方法可指定线程池的固定大小，对于超出的线程会在LinkedBlockingQueue队列中等待。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            final int index = i;

            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", index="+index);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static public void singleThreadExecutorDemo(){
        /**
         * 创建一个只有线程的线程池，该方法无参数，所有任务都保存队列LinkedBlockingQueue中，
         * 等待唯一的单线程来执行任务，并保证所有任务按照指定顺序(FIFO或优先级)执行。
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;

            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+", index="+index);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static  public void scheduledThreadPoolDemo(){
        /**
         * 创建一个可定时执行或周期执行任务的线程池，该方法可指定线程池的核心线程个数。
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        //定时执行一次的任务，延迟1s后执行
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+", delay 1s");
            }
        }, 1, TimeUnit.SECONDS);

        //周期性地执行任务，延迟2s后，每3s一次地周期性执行任务
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+", every 3s");
            }
        }, 2, 3, TimeUnit.SECONDS);
    }

}
