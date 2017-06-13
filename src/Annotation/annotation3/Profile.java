package Annotation.annotation3;

import java.lang.annotation.*;

/**
 * Created by joybar on 2017/6/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
    /**
     * ID
     *
     * @return
     */
    public int id() default -1;

    /**
     * 身高
     *
     * @return
     */
    public int height() default 0;

    /**
     * 籍贯
     *
     * @return
     */
    public String nativePlace() default "";
}