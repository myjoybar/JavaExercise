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


        String s = "\n" +
                "DTCouponType{couponId=1011077, type=303, priority=10, lifeTime=7199.0, schema='coupon_basic', content='{\"creditsBonus\":[{\"productId\":\"DTIP001\",\"bonus\":100},{\"productId\":\"DTIP002\",\"bonus\":200},{\"productId\":\"DTIP003\",\"bonus\":0},{\"productId\":\"TSIP001\",\"bonus\":100},{\"productId\":\"TSIP002\",\"bonus\":200},{\"productId\":\"TSIP003\",\"bonus\":0},{\"productId\":\"TKIP001\",\"bonus\":100},{\"productId\":\"TKIP002\",\"bonus\":200},{\"productId\":\"TKIP003\",\"bonus\":0}]}', getTimeLong=1505972916531, useNum=0, resetNum=0, discount=17}";


      String s1 =   s.replaceAll("IP","AP");

        System.out.println("s="+s);
        System.out.println("s="+s1);
    }
}
