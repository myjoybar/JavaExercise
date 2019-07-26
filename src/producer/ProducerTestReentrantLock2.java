package producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by joybar on 2019/1/15.
 */
public class ProducerTestReentrantLock2 {

    private Lock producelock = new ReentrantLock();
    private Lock consumerlock = new ReentrantLock();
    private Condition not_full_condition = producelock.newCondition();
    private Condition not_empty_condition = consumerlock.newCondition();

    private int FULL_SIZE = 3;
    private int EMPTY_SIZE = 0;
    private List<Integer> productList = new ArrayList<>(1);

    public static void main(String[] args){
       ProducerTestReentrantLock2 test3 = new ProducerTestReentrantLock2();


       Thread thread1  =  new Thread(test3.new producer());
       Thread thread2  =  new Thread(test3.new consumer());
       Thread thread3  =  new Thread(test3.new producer());
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread1.start();
        thread2.start();
        thread3.start();


    }

    public class producer implements Runnable {

        Random random = new Random();
        @Override
        public void run() {


            producelock.lock();
            int newBufSize = 0;
            try {
                while (true){
                    if(productList.size()==FULL_SIZE){
                        System.out.println(Thread.currentThread().getName()+" 队列已满");
                        not_full_condition.await();
                    }
                    int value = random.nextInt(10);
                    System.out.println(Thread.currentThread().getName()+"  生产："+ value);
                    Thread.sleep(1000);
                    productList.add(value);

                    newBufSize = productList.size();
                    // 如果此时又有空间了，那么notFull唤醒
                    if(newBufSize<FULL_SIZE){
                        not_full_condition.signal();
                    }

                    //not_empty_condition.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                producelock.unlock();
            }

            if(newBufSize==0){
                consumerlock.lock();        //加锁
                try {
                    not_empty_condition.signal();    //用于signal，notEmpty
                } finally {
                    consumerlock.unlock();
                }

            }



        }
    }


    public class consumer implements Runnable {

        @Override
        public void run() {


            consumerlock.lock();
            int newBufSize = 0;

            try {
                while (true){
                    if(productList.size()==EMPTY_SIZE){
                        System.out.println(Thread.currentThread().getName()+" 队列 已空");
                        not_empty_condition.await();
                    }
                    int value = productList.get(0);
                    System.out.println(Thread.currentThread().getName()+"  消费："+ value);
                    productList.remove(0);
                    Thread.sleep(1000);

                    newBufSize = productList.size();
                    if(newBufSize>0){
                        not_empty_condition.signal();
                    }

                   // not_full_condition.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                consumerlock.unlock();
            }

            if(newBufSize==FULL_SIZE){
                producelock.lock();        //加锁
                try {
                    not_full_condition.signal();    //用于signal，notEmpty
                } finally {
                    producelock.unlock();
                }

            }



        }
    }

}
