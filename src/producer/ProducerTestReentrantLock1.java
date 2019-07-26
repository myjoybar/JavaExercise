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
public class ProducerTestReentrantLock1 {

    private Lock lock = new ReentrantLock();
    private Condition not_full_condition = lock.newCondition();
    private Condition not_empty_condition = lock.newCondition();
    private int FULL_SIZE = 3;
    private int EMPTY_SIZE = 0;
    private List<Integer> productList = new ArrayList<>(FULL_SIZE);
    public static void main(String[] args){
       ProducerTestReentrantLock1 test3 = new ProducerTestReentrantLock1();
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
            lock.lock();
            try {
                while (true){
                    if(productList.size()==FULL_SIZE){
                        System.out.println(Thread.currentThread().getName()+"  生产已满");
                        not_full_condition.await();
                    }
                    int value = random.nextInt(10);
                    System.out.println(Thread.currentThread().getName()+"  生产："+ value);
                    Thread.sleep(1000);
                    productList.add(value);
                    not_empty_condition.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public class consumer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (true){
                    if(productList.size()==EMPTY_SIZE){
                        System.out.println(Thread.currentThread().getName()+"  已空");
                        not_empty_condition.await();
                    }
                    int value = productList.get(0);
                    System.out.println(Thread.currentThread().getName()+"  消费："+ value);
                    Thread.sleep(1000);
                    productList.remove(0);
                    not_full_condition.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
