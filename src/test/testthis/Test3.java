package test.testthis;

import thread.thread1.Main;

/**
 * Created by joybar on 2017/11/2.
 */
public class Test3 {

    public static void main(String[] args) {

      new Thread(new MyRunnable()){
          @Override
          public void run() {
              System.out.println("Thread");
          }
      }.start();


    }

  static class MyRunnable implements  Runnable{
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }

}
