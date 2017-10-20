package thread.thread2;

public class Main {

    //http://www.jianshu.com/p/fa6667dfb4ca
    public static void main(String[] args) {

//        Object object=new Object();
//        new Producer(object).start();//开启生产
//        new Consumer(object).start();//开启消费

        A a = new A("守护线程执行：");
        B b = new B("用户线程执行：");
        a.setDaemon(true);//设置a线程为守护线程 必须在start()前设置 不然或有异常
        a.isDaemon();//判断a线程是否为守护线程
        a.start();
        b.start();

    }


    //=========================1========================

    /**
    static class Product{
        public volatile static  String value;
    }

    //生产者线程
    static  class Producer extends Thread{
        @Override
        public void run() {
            while (true){
                if (Product.value==null){
                    Product.value="No"+System.currentTimeMillis();
                    System.out.println("产品："+Product.value);
                }
            }
        }
    }
    //消费者线程
    static  class Consumer extends Thread{
        @Override
        public void run() {
            while (true){
                if (Product.value!=null){
                    Product.value=null;
                    System.out.println("产品已消费_");

                }
            }
        }
    }

     **/

    //=========================2========================
  /**  static class Product{
        public static String value;
    }
    //生产者线程
    static  class Producer extends Thread{
        Object object;
        public Producer(Object object) {
            this.object = object;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (Product.value == null) {
                        Product.value = "No" + System.currentTimeMillis();
                        System.out.println("产品：" + Product.value);
                    }
                }
            }
        }
    }

    //消费者线程
    static  class Consumer extends Thread{
        Object object;
        public Consumer(Object object) {
            this.object=object;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (Product.value != null) {
                        Product.value = null;
                        System.out.println("产品已消费");
                    }
                }
            }
        }
    }
**/
    //=========================3========================

  static class Product{
      public static String value;
  }
    //生产者线程
    static class Producer extends Thread {
        Object object;
        public Producer(Object object) {
            this.object = object;
        }
        @Override
        public void run() {
            while (true) {
                //对象锁
                synchronized (object) {
                    if (Product.value != null) {
                        try {
                            object.wait();//产品还未消费 进入等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Product.value = "No" + System.currentTimeMillis();
                    System.out.println("产品：" + Product.value);
                    object.notify();//产品已生产 唤醒消费者线程
                }
            }
        }
    }

    //消费者线程
    static class Consumer extends Thread {
        Object object;
        public Consumer(Object object) {
            this.object = object;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (Product.value == null) {
                        try {
                            object.wait();//产品为空 进入等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Product.value = null;
                    System.out.println("产品已消费");
                    object.notify();//产品已经消费 唤醒生产者线程生产
                }
            }
        }
    }
    //=========================4========================


    static class B extends Thread {
        String name;
        public B(String name) {
            this.name=name;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + i);
            }
        }
    }
    static class A extends Thread {
        String name;
        public A(String name) {
            this.name=name;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println(name + i);
            }
        }
    }
    //=========================5========================
    //=========================6========================
    //=========================7========================
}
