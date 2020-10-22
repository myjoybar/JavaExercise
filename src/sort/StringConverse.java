package sort;

/**
 * Created by joybar on 2019/1/10.
 */
public class StringConverse {
    public static void main(String[] args) {

        String str = "hello, world";
        System.out.println(str);
        System.out.print(stringConverse(str));
        System.out.println("======");
        System.out.print(stringConverse2(str));
    }


    public static String stringConverse(String str) {

        char[] values = str.toCharArray();
        char[] valuesTemp = new char[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
//            System.out.print(values[i]);
            valuesTemp[i] = values[i];
        }
        return valuesTemp.toString();
    }


    public static String stringConverse2(String str) {

        char[] values = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
//            System.out.print(values[i]);
            stringBuilder.append(values[i]) ;
        }
        return stringBuilder.toString();
    }
}
