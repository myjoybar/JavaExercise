package designpattern.InterceptingFilter;

import designpattern.InterceptingFilter.interfaces.Filter;

/**
 * Created by joybar on 30/05/17.
 */
public class AuthenticationFilter implements Filter {
    public void execute(String request){
        System.out.println("Authenticating Request: " + request);
    }
}