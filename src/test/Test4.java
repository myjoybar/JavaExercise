package test;

public class Test4 {

    public static final int BIND_PHONE_NUMBER_ADVISE = 1 << 0; // 0001 是否提醒用户
    public static final int BIND_PHONE_NUMBER_FORCED = 1 << 1; // 0010 是否需要强制绑定
    public static final int BIND_PHONE_NUMBER_FRAUD = 1 << 2; // 0100  是否FRAUD号码

    public static final String TEST_URL = "http://talkyou.me/wallet/invitation/en/index.html#/";

    public static void main(String[] args) {

        System.out.println("Hello World!");
        String str1 = "abc";
        String str2 = "abc";

      // System.out.println(test(7));

        System.out.println(TEST_URL.length());
        System.out.println(lastIndexLetter(TEST_URL,'/',1));
        System.out.println(lastIndexLetter(TEST_URL,'/',2));
    }

    private static boolean test(int smsFlag){
//        return   smsFlag |= BIND_PHONE_NUMBER_ADVISE;
        return (smsFlag & BIND_PHONE_NUMBER_ADVISE) != 0;
    }



    public static int lastIndexLetter(String str, char ch, int lin) {
        char[] array = str.toCharArray();
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] == ch && --lin == 0) {
                return i;
            }
        }
        return -1;
    }


}
