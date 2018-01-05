package test;

public class Test3 {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        long time = System.currentTimeMillis();
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long current = System.currentTimeMillis();
        System.out.println("Hello World!"+current);
        long du = current-time;

        System.out.println("du="+du);


       String s1 =  "一次性购买满5张，送1张！";
        System.out.println(s1.indexOf("一"));
        System.out.println(s1.indexOf("张"));
        System.out.println(s1.indexOf("，"));


        System.out.println(s1.indexOf("送"));
        System.out.println(s1.indexOf("1"));

    }
}
