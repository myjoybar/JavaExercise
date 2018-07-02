package thread.customThreadPool;

import thread.customThreadPool.ThreadFactory.CustomThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(100);
        ThreadFactory threadFactory = CustomThreadFactory.sThreadFactory;
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        CustomThreadPool customThreadPool = new CustomThreadPool(workQueue,threadFactory, corePoolSize, maximumPoolSize);

        for(int i =0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println( getTreadName()+"Runnable is running");
                    try {
                        Thread.sleep(2*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            customThreadPool.execute(runnable);

        }


    }


    private static String getTreadName() {
        return "[Thread: " + Thread.currentThread().getName() + "]_";
    }
}
