package sort.test.fortest;

/**
 * Created by joybar on 2019/1/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LRUTest<String> lruTest = new LRUTest(4);

        Node<String> node7 = new Node("Hello_" + 7);
        Node<String> node6 = new Node("Hello_" + 6);
        Node<String> node5 = new Node("Hello_" + 5);
        Node<String> node4 = new Node("Hello_" + 4);
        Node<String> node3 = new Node("Hello_" + 3);
        Node<String> node2 = new Node("Hello_" + 2);
        Node<String> node1 = new Node("Hello_" + 1);

        lruTest.add(node1);
        lruTest.add(node2);
        lruTest.add(node3);
        lruTest.add(node4);

        System.out.println("step 1" );
        lruTest.loop();
        lruTest.add(node5);

        System.out.println("visit node2" );
        lruTest.get(node2);
        lruTest.add(node6);
        System.out.println("step 2" );
        lruTest.loop();

    }
}


