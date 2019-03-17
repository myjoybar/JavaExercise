package producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by joybar on 14/01/19.
 */
public class ProducerTest2 {

    public static int FULL_SIZE = 1;
    public static int EMPTY_SIZE = 0;
    public static List<Integer> productList = new ArrayList<>(10);

    public static Lock lock = new ReentrantLock();
    Condition full_condition = lock.newCondition();
    Condition empty_condition = lock.newCondition();


    public static void main(String[] args) {

        ProducerTest2 producerTest = new ProducerTest2();
        Producer producer = producerTest.new Producer();
        Consumer consumer = producerTest.new Consumer();
        new Thread(consumer).start();
        new Thread(producer).start();


    }


    public class Producer implements Runnable {

        @Override
        public void run() {

            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class Consumer implements Runnable {


        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void produce() throws InterruptedException {
        Random random = new Random();
        lock.lock();
        try {
            while (true) {
                if (productList.size() == FULL_SIZE) {
                    System.out.println("produce is waiting");
                    full_condition.await();
                }
                int value = random.nextInt(10);
                productList.add(value);
                System.out.println("produce value = " + value);
                Thread.sleep(1 * 1000);
                empty_condition.signal();
            }


        } catch (Exception e) {
            lock.unlock();
        }

    }

    private synchronized void consume() throws InterruptedException {
        lock.lock();
        try {
            while (true) {


                if (productList.size() == EMPTY_SIZE) {
                    System.out.println("Consumer is waiting");
                    empty_condition.await();
                }

                int value = productList.get(0);
                productList.remove(0);
                System.out.println("consume value = " + value);
                Thread.sleep(1 * 1000);
                full_condition.signal();
            }
        } catch (
                Exception e
                )

        {
            lock.unlock();
        }

    }


}
