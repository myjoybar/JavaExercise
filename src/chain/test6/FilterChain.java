package chain.test6;

import chain.test6.interfaces.Interceptors;
import org.omg.PortableInterceptor.Interceptor;

import java.util.List;

/**
 * Created by joybar on 20/05/18.
 */
public class FilterChain implements Interceptors.Chain {

    MyRequest myRequest;
    private final int index;
    private List<Interceptors> interceptors;

    public FilterChain(MyRequest myRequest, int index, List<Interceptors>  interceptors) {
        this.myRequest = myRequest;
        this.index = index;
        this.interceptors = interceptors;
    }

    @Override
    public MyRequest request() {
        return myRequest;
    }

    @Override
    public MyResponse proceed(MyRequest request) {

        System.out.println("index= "+index+" ,interceptors.size()= "+interceptors.size());
        if (index >= interceptors.size()) {
           // throw new AssertionError();
            System.out.println(">=");
            return null;
        }


        // Call the next interceptor in the chain.
        FilterChain next = new FilterChain(
               request,index + 1,interceptors);
        Interceptors interceptor = interceptors.get(index);
        MyResponse response = interceptor.intercept(next);

        return response;
    }
}
