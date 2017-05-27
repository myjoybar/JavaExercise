package designpattern.factory.InjectFactory;

import designpattern.factory.InjectFactory.shape.Shape;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by joybar on 2017/5/27.
 */
public class InstanceGenerator implements IGenerator {

    private Map<Integer, Shape> adLoadInstanceLinkedMap = new LinkedHashMap<>();
    @Override
    public <T extends Shape> T generateInstance(Class<T> clazz) throws Exception {
        Shape instance = null;
        Class classAdLoad = Class.forName(clazz.getName());
        classAdLoad.getDeclaredConstructor().setAccessible(true);
        instance = (Shape) classAdLoad.newInstance();

        return (T) instance;

    }


}
