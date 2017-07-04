package collection;

import data.ManagerData;
import data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by joybar on 15/05/17.
 */
public class BlockingQueueJava1 {


    ManagerData managerData = new ManagerData();


    List<User> listUser = new ArrayList<>();
    List<User> listUserCopy = new ArrayList<>();


    public static void main(String[] args) throws Throwable {
        System.out.println("Hello World!");
        BlockingQueueJava1 blockingQueueJava = new BlockingQueueJava1();
        blockingQueueJava.init();


//        BlockingQueue<User> blockingQueueGet2 = new LinkedBlockingDeque<>();
//        BlockingQueue<User> blockingQueueGet3 = new LinkedBlockingDeque<>();
//
//        blockingQueueGet2.addAll(blockingQueueGet);
//        blockingQueueGet3.addAll(blockingQueueGet);
//
//        System.out.println("blockingQueueGet2.size()="+blockingQueueGet2.size());
//        System.out.println("blockingQueueGet3.size()="+blockingQueueGet3.size());
//        blockingQueueGet2.poll();
//
//        System.out.println("blockingQueueGet2.size()="+blockingQueueGet2.size());
//        System.out.println("blockingQueueGet3.size()="+blockingQueueGet3.size());

    }


    private void init() throws Throwable {


        User user1 = new User("Tom", 11);
        User user2 = new User("Jim", 15);
        User user3 = new User("jj", 25);
        User user4 = new User("dfgf", 13);
        User user5 = new User("Jsdaim", 17);
        User user6 = new User("trtr", 31);


        listUser.add(user1);
        listUser.add(user2);


        // listUserCopy = listUser;
        listUserCopy.addAll(listUser);
//
//        System.out.println("-------1-----" );
//
//        for (User user : listUserCopy) {
//            user.setAge(12);
//            System.out.println(user.toString());
//        }
//        System.out.println("-------2-----" );
//
//        for (User user : listUser) {
//            System.out.println(user.toString());
//        }


//        System.out.println("-------3-----");
//        System.out.println("user1=" + user1.toString());
//        System.out.println("user2=" + user2.toString());
//        System.out.println("user3="+user3.toString());


        managerData.getBlockingQueue().offer(user1);
        managerData.getBlockingQueue().offer(user2);
        managerData.getBlockingQueue().offer(user3);
        managerData.getBlockingQueue().offer(user4);
        managerData.getBlockingQueue().offer(user5);
        managerData.getBlockingQueue().offer(user6);

        managerData.getBlockingQueueCopy().addAll(managerData.getBlockingQueue());

        System.out.println("-------4-----");

        //集合方式遍历，元素不会被移除
        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (User user : blockingQueueCopy) {
//                    try {
//                        blockingQueueCopy.poll();
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("11111===" + user.toString() + "_" + blockingQueueCopy.size());
//
//                }


                BlockingQueue<User> blockingQueueCopy2 = managerData.getBlockingQueueCopy();

                while (true) {
                    try {
                        long lastTime = System.currentTimeMillis();

                        Thread.sleep(1000);
                        long du = System.currentTimeMillis() - lastTime;

                        System.out.println("du="+du);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (null != blockingQueueCopy2) {
                        System.out.println("不为空" + blockingQueueCopy2.size());
                        User user = blockingQueueCopy2.poll();
                        if (null != user) {
                            System.out.println("11111===" + user.toString() + "_" + blockingQueueCopy2.size());
                        }
                    } else {
                        System.out.println("为空");
                    }

                }

            }


        }).start();


        Thread.sleep(3000);

        System.out.println("-------51-----");

        // managerData.getBlockingQueueCopy().clear();
        managerData.resetData();
        //  managerData.getBlockingQueueCopy().addAll(managerData.getBlockingQueue());


        System.out.println("-------52-----");

        //集合方式遍历，元素不会被移除
        for (User user : managerData.getBlockingQueueCopy()) {
            System.out.println("22222===" + user.toString());

        }
        System.out.println("-------6-----");


    }


}
