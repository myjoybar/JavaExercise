package test.test3;

import java.io.UnsupportedEncodingException;

public class TestCHar {

    public static void main(String[] args) throws UnsupportedEncodingException {





        System.out.println(hasMultiBytesCharacter("H,<s"));
        System.out.println(hasMultiBytesCharacter("H,，"));
        System.out.println(hasMultiBytesCharacter("H, "));
       System.out.println(hasMultiBytesCharacter("哈") + "");
       System.out.println(hasMultiBytesCharacter("Nasterea Domnului Hristos sa va umple sufletul de pacea, nadejdea si bucuria mantuirii aduse de El in lume! Craciun fericit! La multi ani  pentru onomastica, presbiterei Emanuela! Cu pretuire, familia Tăbleț") + "");

    }

    private static boolean hasMultiBytesCharacter(String utf8String) {
        int count = utf8String.length();
        for (int i = 0; i < count; i++) {
            String utf8 = Integer.toString(utf8String.charAt(i), 2);
            if(utf8.length()>=8){
                return true;
            }
        }
        return false;
    }




}
