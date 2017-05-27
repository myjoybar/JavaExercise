package designpattern.factory.InjectFactory;

import designpattern.factory.InjectFactory.shape.Rectangle;
import designpattern.factory.InjectFactory.shape.Shape;

public class Main {

    public static void main(String[] args) throws Exception {

        InstanceGenerator instanceGenerator = new InstanceGenerator();
        Shape shape =  instanceGenerator.generateInstance(Rectangle.class);
        shape.draw();

    }
}
