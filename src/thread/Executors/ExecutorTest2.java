package thread.Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by joybar on 2017/7/11.
 */
public class ExecutorTest2 {

    private static Executor executor = Executors.newFixedThreadPool(5);
    // private static Executor executor =  Executors.newScheduledThreadPool(5);//也可以

    public static void main(String[] args) throws Exception {
        /**
         * 模拟100个工人去申请使用工作台作业
         */
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    work();
                }
            });
        }
    }

    /*
     * 工作台的作业情景,每次只能有5个工人在上面作业
     */
    public static void work() {
        try {
            System.out.println(Thread.currentThread().getName() + "正在工作!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "工作完毕!——————————");
    }
}
