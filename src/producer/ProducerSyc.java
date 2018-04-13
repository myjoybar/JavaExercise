package producer;

import java.util.Random;

/**
 * Created by joybar on 2018/4/9.
 */
public class ProducerSyc {

    public static void main(String[] args){
        SelfQueue selfqueue = new SelfQueue();

        //创建生产者线程和消费者线程
        Thread prodThread = new Thread(new Producer(selfqueue));
        Thread consThread = new Thread(new Consumer(selfqueue));

        //启动生产者线程和消费者线程
        prodThread.start();
        consThread.start();
    }

    static class SelfQueue {
        int index = 0;
        int[] ProdLine = new int[6];

        public synchronized void produce(int ProdRandom) {
            while (index == ProdLine.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
            ProdLine[index] = ProdRandom;
            index++;
        }

        public synchronized int consume() {
            while (index == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
            index--;
            return ProdLine[index];
        }
    }

    //生产者
    static class Producer implements Runnable {
        private final SelfQueue selfqueue;

        public Producer(SelfQueue selfqueue) {
            this.selfqueue = selfqueue;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int ProdRandom = random.nextInt(10);
                System.out.println("Produced: " + ProdRandom);
                selfqueue.produce(ProdRandom);
            }
        }
    }

    //消费者
    static class Consumer implements Runnable {
        private final SelfQueue selfqueue;

        public Consumer(SelfQueue selfqueue) {
            this.selfqueue = selfqueue;
        }

        public void run() {
            while (true) {
                System.out.println("Consumed: " + selfqueue.consume());
            }
        }
    }
}
