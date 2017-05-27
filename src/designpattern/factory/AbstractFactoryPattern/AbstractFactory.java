package designpattern.factory.AbstractFactoryPattern;

import designpattern.factory.AbstractFactoryPattern.color.Color;
import designpattern.factory.AbstractFactoryPattern.shape.Shape;

/**
 * Created by joybar on 2017/5/27.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
