package enumtest;

import java.util.Random;

/**
 * Created by joybar on 2018/1/4.
 */
public enum ColorSelector {


    RED("blue", 1),
    GREEN("green", 2),
    BLANK("purple", 3),
    PURPLE("purple",4),
    YELLO("red",5);


    private String name;
    private int colorId;

    static int indexBg;
    static int indexTv;


    public static int getRandomColorID(){
        int size = ColorSelector.values().length;
        Random random = new Random();
        int index = random.nextInt(size);
        return ColorSelector.values()[index].getColorId();

    }


    public static int getRandomBgSortedColorID(){
        int size = ColorSelector.values().length;
        return ColorSelector.values()[indexBg++].getColorId();
    }

    public static int getRandomTvSortedColorID(){
        int size = ColorSelector.values().length;
        return ColorSelector.values()[indexTv++].getColorId();
    }



    ColorSelector(String name, int colorId) {
        this.name = name;
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
