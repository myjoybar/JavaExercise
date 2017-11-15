package test.test3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<String> list = new ArrayList<>();
        list.add("AAAA");
        list.add("BBBB");
        list.add("CCCC");

//        for (String str:     list ) {
//
//            if(str.contains("BBBB")){
//                str =  str+"ss" ;
//            }
//        }

        int count = list.size();
        for(int i = 0;i<count;i++){
            if(list.get(i).contains("BBBB")){
                list.set(i,list.get(i)+"sss");
            }
        }

        System.out.println(list.toString());


    }
}
