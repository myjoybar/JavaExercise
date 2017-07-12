package thread.Executors;

import java.util.concurrent.*;

/**
 * Created by joybar on 2017/7/11.
 */
public class ExecutorTest {
    static ExecutorService executor = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

        System.out.println("=====");
        try {
            test1();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=====");
    }


    static private void test1() throws ExecutionException, InterruptedException {
        Future<String> future = executor.submit(new Task());
        String result = future.get();//主线程的future.get()会阻塞线程直到任务执行完成。
        System.out.println(result);
    }



    static class Task implements Callable<String> {



        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return "A";
        }
    }



}
