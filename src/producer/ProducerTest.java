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
public class ProducerTest {

    public static int FULL_SIZE = 10;
    public static int EMPTY_SIZE = 0;
    public static List<Integer> productList = new ArrayList<>(10);

    public static Object object = new Object();
    public static Lock lock = new ReentrantLock();
    Condition full_condition = lock.newCondition();
    Condition empty_condition = lock.newCondition();


    public static void main(String[] args) {

        ProducerTest producerTest = new ProducerTest();
        Producer producer = producerTest.new Producer();
        Consumer consumer = producerTest.new Consumer();
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();


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
        while (true) {

            synchronized (object) {
                if (productList.size() == FULL_SIZE) {
                    try {
                        System.out.println("Producer is waiting  ");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = random.nextInt(10);
                productList.add(value);
                System.out.println("produce value = " + value);
                Thread.sleep(1 * 1000);
                object.notify();
            }


        }

    }

    private  void consume() throws InterruptedException {
        while (true) {

            synchronized (object) {
                if (productList.size() == EMPTY_SIZE) {
                    try {
                        System.out.println("Consumer is waiting");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int value = productList.get(0);
                productList.remove(0);
                System.out.println("consume value = " + value);
                Thread.sleep(1 * 1000);
                object.notify();

            }


        }

    }


}
