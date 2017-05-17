package collection;

import data.User;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by joybar on 15/05/17.
 */
public class BlockingQueueJava {


    BlockingQueue<User> blockingQueue = new LinkedBlockingDeque<>();
    BlockingQueue<User> blockingQueueCopy = new LinkedBlockingDeque<>();


    List<User> listUser = new ArrayList<>();
    List<User> listUserCopy = new ArrayList<>();


    public BlockingQueue<User> getBlockingQueue() {
        return blockingQueue;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BlockingQueueJava blockingQueueJava = new BlockingQueueJava();
        blockingQueueJava.init();

        BlockingQueue<User> blockingQueueGet =blockingQueueJava.getBlockingQueue();

        BlockingQueue<User> blockingQueueGet2 = new LinkedBlockingDeque<>();
        BlockingQueue<User> blockingQueueGet3 = new LinkedBlockingDeque<>();

        blockingQueueGet2.addAll(blockingQueueGet);
        blockingQueueGet3.addAll(blockingQueueGet);

        System.out.println("blockingQueueGet2.size()="+blockingQueueGet2.size());
        System.out.println("blockingQueueGet3.size()="+blockingQueueGet3.size());
        blockingQueueGet2.poll();

        System.out.println("blockingQueueGet2.size()="+blockingQueueGet2.size());
        System.out.println("blockingQueueGet3.size()="+blockingQueueGet3.size());

    }


    private void init(){


        User user1 =new User("Tom",11);
        User user2 =new User("Jim",11);



        listUser.add(user1);
        listUser.add(user2);


       // listUserCopy = listUser;
        listUserCopy.addAll(listUser);

        System.out.println("-------1-----" );

        for (User user : listUserCopy) {
            user.setAge(12);
            System.out.println(user.toString());
        }
        System.out.println("-------2-----" );

        for (User user : listUser) {
            System.out.println(user.toString());
        }



        User user3 = user2;

        user3.setAge(17);


        System.out.println("-------3-----");
        System.out.println("user2=" + user2.toString());
        System.out.println("user3="+user3.toString());


        blockingQueue.offer(user1);
        blockingQueue.offer(user2);

        blockingQueueCopy.addAll(blockingQueue);

        System.out.println("-------4-----");

        //集合方式遍历，元素不会被移除
        for (User user : blockingQueueCopy) {
            user.setAge(13);
            System.out.println(user.toString());
        }

        System.out.println("-------5-----" );

        //集合方式遍历，元素不会被移除
        for (User user : blockingQueue) {
            System.out.println(user.toString());
        }
        System.out.println("-------6-----" );

        //队列方式遍历，元素逐个被移除
//        while (blockingQueue.peek() != null ) {
//            System.out.println(blockingQueue.poll());
//        }



    }


}
