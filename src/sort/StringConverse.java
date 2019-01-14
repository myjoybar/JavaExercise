package sort;

/**
 * Created by joybar on 2019/1/10.
 */
public class StringConverse {
    public static void main(String[] args) {

        String str = "hello, world";
        System.out.println(stringConverse(str));
    }


    public static String stringConverse(String str) {

        char[] values = str.toCharArray();
        char[] valuesTemp = new char[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            System.out.println(values[i]);
            valuesTemp[i] = values[i];
        }
        return valuesTemp.toString();
    }

}
