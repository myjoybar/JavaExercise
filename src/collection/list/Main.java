package collection.list;

import data.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<User> list = new ArrayList<>();
        User user = new User("aa",1);
        list.add(user);
        list.add(new User("bb",2));

        System.out.println(list.contains(user));
        System.out.println(list.contains(new User("aa",1)));

    }
}
