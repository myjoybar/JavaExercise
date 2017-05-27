package designpattern.factory.FactoryPattern;

/**
 * Created by joybar on 2017/5/27.
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
