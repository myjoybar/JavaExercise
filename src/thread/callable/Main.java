package thread.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

    //http://blog.csdn.net/javazejian/article/details/50896505
    public static void main(String[] args) {
       // test1();
        test2();
    }

    //3.1 使用Callable+Future获取执行结果
    private static void  test1(){


        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        //创建Callable对象任务
        CallableDemo calTask=new CallableDemo();

        //提交任务并获取执行结果
        Future<Integer> future =es.submit(calTask);

        //关闭线程池
        es.shutdown();


        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");

            if(future.get()!=null){
                //输出获取到的结果
                System.out.println("future.get()-->"+future.get());
            }else{
                //输出获取到的结果
                System.out.println("future.get()未获取到结果");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");
    }

    //使用Callable+FutureTask获取执行结果
    private static void  test2(){
        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        //创建Callable对象任务
        CallableDemo calTask=new CallableDemo();
        //创建FutureTask
        FutureTask<Integer> futureTask=new FutureTask<>(calTask);
        //执行任务
        es.submit(futureTask);
        //关闭线程池
        es.shutdown();
        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");

            if(futureTask.get()!=null){
                //输出获取到的结果
                System.out.println("futureTask.get()-->"+futureTask.get());
            }else{
                //输出获取到的结果
                System.out.println("futureTask.get()未获取到结果");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");
    }


}
