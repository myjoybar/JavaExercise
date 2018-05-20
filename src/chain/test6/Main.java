package chain.test6;

import chain.test5.Request;
import chain.test6.interceptors.Test1LogInterceptors;
import chain.test6.interceptors.Test2LogInterceptors;
import chain.test6.interceptors.Test3LogInterceptors;
import chain.test6.interfaces.Interceptors;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");


        String content = "AA_aa_BB_bb_CC_cc";

        System.out.println("原始content="+content);

        MyRequest request = new MyRequest();
        request.setRequestStr(content);

        List<Interceptors> interceptors = new ArrayList<>();
        interceptors.add(new Test1LogInterceptors());
        interceptors.add(new Test2LogInterceptors());
       interceptors.add(new Test3LogInterceptors());

        FilterChain filterChain = new FilterChain(request,0,interceptors);

        filterChain.proceed(request);

    }
}
