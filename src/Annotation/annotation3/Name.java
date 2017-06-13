package Annotation.annotation3;

import java.lang.annotation.*;

/**
 * Created by joybar on 2017/6/13.
 * Name姓名注解：
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String value() default "";
}
