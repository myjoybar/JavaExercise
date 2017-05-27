package designpattern.factory.InjectFactory;

import designpattern.factory.InjectFactory.shape.Shape;

/**
 * Created by joybar on 2017/5/27.
 */
public interface IGenerator {
    public abstract <T extends Shape>T generateInstance(Class<T> clazz) throws Exception;

}
