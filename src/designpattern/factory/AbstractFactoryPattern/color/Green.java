package designpattern.factory.AbstractFactoryPattern.color;

/**
 * Created by joybar on 2017/5/27.
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
