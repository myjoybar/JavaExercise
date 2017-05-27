package designpattern.factory.InjectFactory.shape;

/**
 * Created by joybar on 2017/5/27.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
