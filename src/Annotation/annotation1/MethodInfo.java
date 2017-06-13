package Annotation.annotation1;

import java.lang.annotation.*;

/**
 * Created by joybar on 2017/6/13.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface MethodInfo {

    String author() default "trinea@gmail.com";

    String date();

    int version() default 1;
}