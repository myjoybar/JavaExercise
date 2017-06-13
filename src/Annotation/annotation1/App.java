package Annotation.annotation1;

/**
 * Created by joybar on 2017/6/13.
 */
public class App {
    @MethodInfo(
            author = "trinea.cn+android@gmail.com",
            date = "2014/02/14",
            version = 2)
    public String getAppName() {
        return "trinea";
    }
}
