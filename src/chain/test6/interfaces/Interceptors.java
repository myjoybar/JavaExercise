package chain.test6.interfaces;

import chain.test6.MyRequest;
import chain.test6.MyResponse;

/**
 * Created by joybar on 20/05/18.
 */
public interface Interceptors {



    MyResponse intercept(Chain chain) ;

    interface Chain {
        MyRequest request();

        MyResponse proceed(MyRequest request) ;

    }
}
