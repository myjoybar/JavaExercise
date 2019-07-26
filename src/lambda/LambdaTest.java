package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joybar on 2019/6/24.
 */
public class LambdaTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        test1();
        test2();
        test3();
        test4();
        test5();
        getEncryptedString("joy.deng@dingtone.me");
    }


    /**
     * 1.替代匿名内部类
     * ()->
     */

    private static void test1() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();


        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }

    /**
     * 使用lambda表达式对集合进行迭代
     */
    private static void test2() {
        List<String> languages = Arrays.asList("java", "scala", "python");
        //before java8
        for (String each : languages) {
            System.out.println(each);
        }
        System.out.println("=====");
        languages.forEach(x -> System.out.println(x));

    }

    /**
     * map的作用是将一个对象变换为另外一个
     */
    private static void test3() {
        System.out.println("=====");
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));

    }

    /**
     *   map的作用是将一个对象变为另外一个，
     *   而reduce实现的则是将所有值合并为一个
     */
    private static void test4() {
        System.out.println("=====");
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
    }

    /**
     * filter也是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
     */
    private static void test5() {
        System.out.println("=====");
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

    }

    public static String getEncryptedString(String string) {
        System.out.println("=====");
        String s = string.chars().mapToObj(i -> Integer.toHexString(i ^ 5)).collect(Collectors.joining());
        System.out.println("s = "+s);
        return s;
    }


}
