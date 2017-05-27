package designpattern.factory.AbstractFactoryPattern;

import designpattern.factory.AbstractFactoryPattern.color.Color;
import designpattern.factory.AbstractFactoryPattern.shape.Circle;
import designpattern.factory.AbstractFactoryPattern.shape.Rectangle;
import designpattern.factory.AbstractFactoryPattern.shape.Shape;
import designpattern.factory.AbstractFactoryPattern.shape.Square;

/**
 * Created by joybar on 2017/5/27.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
