package chain.test5.filters;


import chain.test5.interfaces.Filter;
import chain.test5.Request;
import chain.test5.Response;

/**
 * Created by joybar on 2018/5/15.
 */
public class FuckFilter implements Filter {



    @Override
    public void doFilter(Request request, Response response, Filter chainFilter) {

        System.out.println("doFilter:FuckFilter");

        String requestFilterStr = request.getRequestStr()
                .replace("尼玛", "xx")
                .replace("你妈", "xx");
        request.setRequestStr(requestFilterStr);

        chainFilter.doFilter(request, response, chainFilter);


        System.out.println("doFilter:FuckFilter__response");

        String responseFilterStr = response.getResponseStr()
                .replace("尼玛", "++")
                .replace("你妈", "++");
        response.setResponseStr(responseFilterStr + "|FuckFilter");

    }
}

