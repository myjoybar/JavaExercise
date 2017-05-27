package designpattern.factory.AbstractFactoryPattern;

import designpattern.factory.AbstractFactoryPattern.color.Blue;
import designpattern.factory.AbstractFactoryPattern.color.Color;
import designpattern.factory.AbstractFactoryPattern.color.Green;
import designpattern.factory.AbstractFactoryPattern.color.Red;
import designpattern.factory.AbstractFactoryPattern.shape.Shape;

/**
 * Created by joybar on 2017/5/27.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
