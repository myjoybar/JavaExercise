package test;

import java.util.Locale;

public class Test5 {


    public static void main(String[] args) {

        System.out.println("Hello World!");
        String str1 = "US$0.99";
        String str2 = "P1M";
        String str3 = "$0.99/month";

        String str4 = "P2W3D";
        String str5 = "P1W";


        int start = str3.indexOf("$");
        int end = str3.indexOf("/");

        System.out.println(str1.substring(str1.indexOf("$"), str1.length()));
        System.out.println(str2.substring(str2.length() - 1));
        System.out.println("start=" + start);
        System.out.println("end=" + end);


        System.out.println("------" + getNumberStrBeforeChar(str4, "W"));
        System.out.println("------" + getNumberStrBeforeChar(str4, "D"));
        System.out.println("------" + getNumberStrBeforeChar(str5, "W"));


        Locale l = new Locale("", "cn");
        System.out.println(l.getDisplayCountry());

        try {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    test();
                }
            }.start();
        } catch (Exception e) {

        }

        findFirstNumberIndexInStr("US$4.99");
       // findFirstNumberIndexInStr("PEN 16.99");


    }


    public static String getNumberStrBeforeChar(String str, String ch) {
        int index = str.indexOf(ch);
        return str.substring(index - 1, index);

    }

    public static void test() {
        int i = 10 / 0;
    }


    public static int findFirstNumberIndexInStr(String str) {
        str = str.replaceAll(" ","");
        System.out.println("str=" + str);
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            System.out.println("c=" + c);
            int number = chars[i] - '0';
            System.out.println("c=" + c);
            System.out.println("number=" + number);
            if (number >= 0 && number <= 9) {
                System.out.println("i=" + i);
                return i;
            }


        }
        return 0;
    }


}
