package Annotation.annotation3;

import java.lang.annotation.*;

/**
 * Created by joybar on 2017/6/13.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    public enum GenderType {

        Male("男"),
        Female("女"),
        Other("中性");

        private String genderStr;

        private GenderType(String arg0) {
            this.genderStr = arg0;
        }

        @Override
        public String toString() {
            return genderStr;
        }
    }

    GenderType gender() default GenderType.Male;
}
