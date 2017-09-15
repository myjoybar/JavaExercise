package test;

import java.text.NumberFormat;

/**
 * Created by joybar on 2017/9/8.
 */
public class Test2 {
    public static void main(String[] args) {

        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        long curTime = System.currentTimeMillis();
        System.out.println(curTime);
        System.out.println(n.format(Math.random()));
        System.out.println((double)Math.random());
    }
}
