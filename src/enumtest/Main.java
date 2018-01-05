package enumtest;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        int size = ColorSelector.values().length;
        Random random = new Random();
        for (int i = 0; i < size; i++) {

//            System.out.println("is=" + ColorSelector.values()[i].ordinal());
//            System.out.println("random=" + random.nextInt(size));

              System.out.println("ColorSelector.getRandomColorID()="+ColorSelector.getRandomColorID());
        }



    }
}
