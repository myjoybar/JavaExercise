package producer;

import java.util.Random;

/**
 * Created by joybar on 2019/1/15.
 */
    public class Producertest2 {

        /*定义一个商品缓存位置*/
        private volatile Goods goods;

        /*定义一个对象作为锁,不使用goods作为锁是因为生产者每次会产生一个新的对象*/
        private Object obj = new Object();


        /*isFull == true 生产者线程休息,消费者线程消费
         *isFull == false 消费者线程休息，生产者线程生产*/
        private volatile boolean isFull = false;

        /*商品的id编号,生产者制造的每个商品的id都不一样,每生产一个id自增1*/
        private int id = 1;

        /*随机产生一个sleep时间*/
        private Random rnd = new Random();

        /*=================定义消费者线程==================*/
        public class ComsumeThread implements Runnable{
            @Override
            public void run(){

                try{
                    while(true){

                    /*获取obj对象的锁, id 和 isFull 的操作都在同步代码块中*/
                        synchronized(obj){

                            if(!isFull){
                            /*wait方法使当前线程阻塞，并释放锁*/
                                obj.wait();
                            }

                        /*随机延时一段时间*/
                            Thread.sleep(rnd.nextInt(250));

                        /*模拟消费商品*/
                            System.out.println("消费："+ goods);

                        /*随机延时一段时间*/
                            Thread.sleep(rnd.nextInt(250));

                            isFull = false;

                        /*唤醒阻塞obj上的生产者线程*/
                            obj.notify();

                        }

                    /*随机延时一段时间*/
                        Thread.sleep(rnd.nextInt(250));

                    }
                }catch (InterruptedException e){
                /*什么都不做*/
                }
            }
        }

        /*=================定义生产者线程==================*/
        public class ProductThread implements Runnable{
            @Override
            public void run(){

                try {
                    while(true){

                        synchronized(obj){

                            if(isFull){
                                obj.wait();
                            }

                            Thread.sleep(rnd.nextInt(500));

                        /*如果id为偶数,生产价格为2的产品A
                         *如果id为奇数,生产价格为1的产品B*/
                            if(id % 2 == 0){
                                goods = new Goods("A", 2, id);
                            }else{
                                goods = new Goods("B", 1, id);
                            }

                            System.out.println("生产："+ goods);

                            Thread.sleep(rnd.nextInt(250));

                            id++;
                            isFull = true;

                        /*唤醒阻塞的消费者线程*/
                            obj.notify();
                        }
                    }
                } catch (InterruptedException e) {
                /*什么都不做*/
                }

            }
        }

        public static void main(String[] args) throws InterruptedException{

            Producertest2 pcd = new Producertest2();

            Runnable c = pcd.new ComsumeThread();
            Runnable p = pcd.new ProductThread();

            new Thread(p).start();
            new Thread(c).start();
        }
    }