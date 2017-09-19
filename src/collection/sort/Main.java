package collection.sort;

import data.User;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<User>  list = new ArrayList<>();
        list.add(new User("BBB",18));
        list.add(new User("CCC",19));
        list.add(new User("AAA",17));
        list.add(new User("DDDD",13));


        System.out.println("Hello World!"+ Arrays.toString(list.toArray()));

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                if (user1.getAge() > user2.getAge()) {
                    return -1;
                } else if (user1.getAge()<user2.getAge()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Hello World!"+ Arrays.toString(list.toArray()));

    }
}
