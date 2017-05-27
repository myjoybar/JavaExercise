package collection;

import data.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by joybar on 2017/5/24.
 */
public class MapTest {


    Map<User, User> map = new HashMap<>();

    public static void main(String[] args) {


        System.out.println("Hello World!");
        MapTest test = new MapTest();
        test.initMap();



    }


    private void initMap() {

        long time1 = System.currentTimeMillis();

        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user1 = new User("Tom", 11);
        User user2 = new User("Jim", 11);
        map.put(user1, user1);
        map.put(user2, user2);

        User user3 = new User("Jim", 11);

      //  System.out.println(map.get(user3).toString());

        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);
    }

}
