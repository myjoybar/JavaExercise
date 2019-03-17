package sort;

import java.util.Arrays;

/**
 * Created by joybar on 21/01/19.
 */
public class Test {

    static String str = "88,d-YYYYsMM-sDD";

    static char ch1 = 'Y';
    static char ch2 = 'M';
    static char ch3 = 'D';

    public static void main(String[] args) {
        System.out.println("====");
        char[] chars = str.toCharArray();
//        System.out.println("chars[0]="+chars[5]);
//        System.out.println("ch1="+ch1);
        System.out.println(getStr(str));
    }


    public static String getStr(String str) {
        char[] chars = str.toCharArray();
        int countY = 0;
        StringBuilder sb = new StringBuilder();
        boolean hasDealY = false;
        boolean hasDealM = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ch1 && !hasDealY) {
                sb.append(chars[i]);
                countY = 0;
            } else if(!hasDealY){
                countY++;
            }
            if (countY == 4&&!hasDealY) {
                sb.append("2010");
                hasDealY = true;
                countY = 0;
                i++;
            }
            if (chars[i] != ch2 && hasDealY && !hasDealM) {
                sb.append(chars[i]);
                countY = 0;
            } else if( !hasDealM) {
                countY++;
            }
            if (countY == 2&&!hasDealM) {
                sb.append("01");
                hasDealM = true;
                i = i + 2;
                countY = 0;
            }
            if (hasDealM) {
                if (chars[i] != ch3) {
                    sb.append(chars[i]);
                    countY = 0;
                } else {
                    countY++;
                }
                if (countY == 2) {
                    sb.append("30");
                }
            }

        }

        System.out.println("====");
        return sb.toString();


    }


}
