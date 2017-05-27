package designpattern.factory.AbstractFactoryPattern.color;

/**
 * Created by joybar on 2017/5/27.
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}