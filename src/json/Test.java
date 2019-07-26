package json;

/**
 * Created by joybar on 2019/5/28.
 */
public class Test {

    public static void main(String[] args) {

        int colors[] = { 0xff255779 , 0xff3e7492, 0xffa6c0cd };

        String str = "0xff255779";
        //String str1 = "ff255779";
        String str1 = "ffffffff";

        //System.out.println(Long.parseLong(str,16));
        //System.out.println(Integer.parseInt(str,16));
       // System.out.println(strTo16(str));
       // int out = Integer.parseInt(str1.substring(2, str1.length()), 16);
        int out = Integer.parseInt(str1.substring(0, str1.length()), 16);
        System.out.println(out);


        String strHex = Integer.toHexString(out);
        System.out.println(out + " [十进制]---->[十六进制] " + strHex);
        //将十六进制格式化输出
        String strHex2 = String.format("%08x",out);
        System.out.println(out + " [十进制]---->[十六进制] " + strHex2);

    }


    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

}






