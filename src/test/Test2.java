package test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by joybar on 2017/9/8.
 */
public class Test2 {
    public static void main(String[] args) throws ParseException {

        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        long curTime = System.currentTimeMillis();
        System.out.println(curTime);
        System.out.println(n.format(Math.random()));
        System.out.println((double) Math.random());


        String s = "\n" +
                "DTCouponType{couponId=1011077, type=303, priority=10, lifeTime=7199.0, schema='coupon_basic', content='{\"creditsBonus\":[{\"productId\":\"DTIP001\",\"bonus\":100},{\"productId\":\"DTIP002\",\"bonus\":200},{\"productId\":\"DTIP003\",\"bonus\":0},{\"productId\":\"TSIP001\",\"bonus\":100},{\"productId\":\"TSIP002\",\"bonus\":200},{\"productId\":\"TSIP003\",\"bonus\":0},{\"productId\":\"TKIP001\",\"bonus\":100},{\"productId\":\"TKIP002\",\"bonus\":200},{\"productId\":\"TKIP003\",\"bonus\":0}]}', getTimeLong=1505972916531, useNum=0, resetNum=0, discount=17}";

        System.out.println(month(1516884078000L));

        System.out.println(mont11(1516884078000L,System.currentTimeMillis()));

    }


    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    //    Long s = (System.currentTimeMillis() - hqtime) / (1000 * 60);
//
//
    public static int month(long time) {

        long duration = time - System.currentTimeMillis();
        System.out.println("time=="+time);
        System.out.println("time2=="+System.currentTimeMillis());
        System.out.println("duration=="+duration);


        System.out.println("duration2=="+stampToDate(time+""));
        System.out.println("duration3=="+stampToDate(System.currentTimeMillis()+""));
        if (duration <= 0) {
            return 0;
        }

        return (int) (duration / (1000*60* 60 * 24));
    }

    public static int mont11(long timeCurrent,long time) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str1 = stampToDate(time+"");
        String str2 = stampToDate(timeCurrent+"");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(str1));
        aft.setTime(sdf.parse(str2));
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        System.out.println(Math.abs(month + result));

        return Math.abs(month + result);
    }


}
