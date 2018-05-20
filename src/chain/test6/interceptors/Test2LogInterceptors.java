package chain.test6.interceptors;

import chain.test6.MyRequest;
import chain.test6.MyResponse;
import chain.test6.interfaces.Interceptors;

/**
 * Created by joybar on 20/05/18.
 */
public class Test2LogInterceptors implements Interceptors {

    private String tag = "2222222";
    @Override
    public MyResponse intercept(Chain chain) {

        MyRequest myRequest = chain.request();
        System.out.println("myRequest___" + tag + "   开始 " + myRequest.getRequestStr());

        String requestFilterStr = myRequest.getRequestStr()
                .replace("bb", "BB");
        myRequest.setRequestStr(requestFilterStr);


       MyResponse  myResponse = chain.proceed(myRequest);
        //  MyResponse  myResponse = new MyResponse();

        System.out.println("myResponse___"+tag+"   开始");
        myResponse.setResponseStr("myResponse___"+tag);
        System.out.println("TestLogInterceptors"+tag+":myResponse 开始"+myResponse.getResponseStr());

        return myResponse;
    }
}
