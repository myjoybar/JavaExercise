package chain.test6.interceptors;

import chain.test6.MyRequest;
import chain.test6.MyResponse;
import chain.test6.interfaces.Interceptors;

/**
 * Created by joybar on 20/05/18.
 */
public class Test1LogInterceptors implements Interceptors {

    private String tag = "111111111";
    @Override
    public MyResponse intercept(Chain chain) {

        MyRequest myRequest = chain.request();
        System.out.println("myRequest___"+tag+"   开始 "+myRequest.getRequestStr());

        String requestFilterStr = myRequest.getRequestStr()
                .replace("aa", "AA");
        myRequest.setRequestStr(requestFilterStr);

        MyResponse  myResponse = chain.proceed(myRequest);
        System.out.println("myResponse___"+tag+"   开始");
        myResponse.setResponseStr("myResponse___"+tag);
        System.out.println("TestLogInterceptors"+tag+":myResponse 开始"+myResponse.getResponseStr());

        return myResponse;
    }
}
