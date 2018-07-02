package thread.customThreadPool;

import thread.customThreadPool.interfaces.ExecutorService;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Created by joybar on 01/07/18.
 */
public class CustomThreadPool implements ExecutorService {

    private final BlockingQueue<Runnable> workQueue;
    private final HashSet<Worker> workers = new HashSet<>();
    private final ThreadFactory threadFactory;
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        // 当前线程数 < corePoolSize
        if (workers.size() < corePoolSize) {
            System.out.println("当前线程数 < corePoolSize");
            addWorker(command, false);
            return;
        }
        //活动线程数 >= corePoolSize
        if (workers.size() + workQueue.size() < maximumPoolSize) {
            System.out.println("活动线程数 >= corePoolSize");
            workQueue.offer(command);

        } else {
            System.out.println("reject");
            //reject
        }


    }


    public CustomThreadPool(BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, int corePoolSize, int maximumPoolSize) {
        this.workQueue = workQueue;
        this.threadFactory = threadFactory;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
    }

    public class Worker implements Runnable {

        final Thread thread;

        Runnable firstTask;

        Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = threadFactory.newThread(this);
        }

        @Override
        public void run() {
            runWorker(this);

        }
    }


    private void addWorker(Runnable firstTask, boolean core) {
        Worker w = new Worker(firstTask);
        final Thread t = w.thread;
        t.start();
        workers.add(w);
    }


    final void runWorker(Worker w) {
        Runnable task = w.firstTask;
        w.firstTask = null;
        while (task != null || (task = getTask()) != null) {
            System.out.println("runWorker............");
            try {
                task.run();
            } catch (Exception e) {

            } finally {
                task = null;
                workers.remove(w);
            }
        }
    }

    private Runnable getTask() {
        for (; ; ) {
            System.out.println("getTask............");
            try {
                Runnable r = workQueue.take();
                if (r != null)
                    return r;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
