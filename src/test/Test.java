package test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joybar on 2017/5/16.
 */
public class Test {
    private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK = 0x3 << MODE_SHIFT;

    public static final int UNSPECIFIED = 0 << MODE_SHIFT;
    public static final int EXACTLY = 1 << MODE_SHIFT;
    public static final int AT_MOST = 2 << MODE_SHIFT;

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println("UNSPECIFIED="+UNSPECIFIED);
//        System.out.println("EXACTLY="+EXACTLY);
//        System.out.println("AT_MOST="+AT_MOST);
//
//        paly(new doListener() {
//            @Override
//            public void doAction() {
//                try {
//                    System.out.println("---doAction--");
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("---doAction");
//            }
//        });
//
//        System.out.println("------");
        testList();
        testTime();
        testXiaoshu(11);
        testXiaoshu(2);
        testXiaoshu(1.0);
        testXiaoshu(0.5);
        testXiaoshu(0.3);
        testXiaoshu(0.7);
        testXiaoshu(0.03);
        testXiaoshu(0.005);
        testXiaoshu(0.007);

    }


   static private void paly(doListener doListener){
        doListener.doAction();
    }



    interface  doListener{
        void doAction();
    }

    static  private  void testList(){
      String adListStr =   "9,17,98,999,103";
        String []adList = adListStr.split(",");
        List<String> list= Arrays.asList(adList);
        System.out.println("------"+ Arrays.toString(list.toArray()));
    }

    static  private  void testTime(){
        long ct =System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long ct2 =System.currentTimeMillis();
        System.out.println("ct2="+ct2);
        System.out.println("------"+(ct2-ct));
    }


    static private void testXiaoshu(double tj_Sow){

        int tapjoyWeight = 1;
        int offerWallWeight = 5;
        if(tj_Sow>=1.0){
            tapjoyWeight = (int) tj_Sow;
            offerWallWeight = 1;
        }else if(tj_Sow>=0.1){
            tapjoyWeight =  (int) (tj_Sow*10);
            offerWallWeight = 10;
            offerWallWeight = offerWallWeight/tapjoyWeight;
            tapjoyWeight = 1;

        }else if(tj_Sow>=0.01){
            tapjoyWeight =  (int) (tj_Sow*100);
            offerWallWeight = 100;
            offerWallWeight = offerWallWeight/tapjoyWeight;
            tapjoyWeight = 1;
        }else if(tj_Sow>=0.001){
            tapjoyWeight =  (int) (tj_Sow*1000);
            offerWallWeight = 1000;
            offerWallWeight = offerWallWeight/tapjoyWeight;
            tapjoyWeight = 1;
        }

        System.out.println("=============="+tj_Sow);
        System.out.println("tapjoyWeight="+tapjoyWeight);
        System.out.println("offerWallWeight="+offerWallWeight);

    }


}
