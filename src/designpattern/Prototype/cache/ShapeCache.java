package designpattern.Prototype.cache;

import designpattern.Prototype.Rectangle;
import designpattern.Prototype.Shape;
import designpattern.Prototype.Square;
import designpattern.factory.AbstractFactoryPattern.shape.Circle;

import java.util.Hashtable;

/**
 * Created by joybar on 29/05/17.
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {


        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
