package inject.test4;


/**
 * Created by joybar on 2019/1/4.
 */
public class Reflect {

    private final Class<?> type;
    private final Object object;

    public Reflect(Class<?> type) {
        this(type, type);
    }

    public Reflect(Class<?> type, Object object) {
        this.type = type;
        this.object = object;
    }

    
    
    public static Reflect on(Class<?> clazz) {
        return new Reflect(clazz);
    }


}
