package inject.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by joybar on 2019/1/4.
 */
public class ReflectionUtils {

    public static <T> T getInstanceByPrivateConstructor(Class<T> clazz) {

        try {
            Class<?> cls = Class.forName(clazz.getName());
            Constructor<T> constructor = (Constructor<T>) cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = (T) constructor.newInstance();
            return instance;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static <T> T getInstanceByPublicConstructor(Class<T> clazz) {

        Class<?> cls = null;
        try {
            cls = Class.forName(clazz.getName());
            cls.getDeclaredConstructor().setAccessible(true);
            T instance = (T) cls.newInstance();
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }
}
