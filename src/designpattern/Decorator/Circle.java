package designpattern.Decorator;

import designpattern.Decorator.interfaces.Shape;

/**
 * Created by joybar on 30/05/17.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
