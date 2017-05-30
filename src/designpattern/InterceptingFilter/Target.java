package designpattern.InterceptingFilter;

/**
 * Created by joybar on 30/05/17.
 */
public class Target {

    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}
