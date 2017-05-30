package designpattern.Decorator;

import designpattern.Decorator.interfaces.Shape;
import designpattern.Decorator.interfaces.ShapeDecorator;

/**
 * Created by joybar on 30/05/17.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
