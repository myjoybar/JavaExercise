package chain.test4.filters;


import chain.test4.Request;
import chain.test4.Response;
import chain.test4.interfaces.Filter;

/**
 * Created by joybar on 2018/5/15.
 */
public class FuckFilter implements Filter {



    @Override
    public void doFilter(Request request, Response response) {
        String requestFilterStr = request.getRequestStr()
                .replace("尼玛", "xx")
                .replace("你妈", "xx");
        request.setRequestStr(requestFilterStr);

        String responseFilterStr = response.getResponseStr()
                .replace("尼玛", "++")
                .replace("你妈", "++");
        response.setResponseStr(responseFilterStr + "|FuckFilter");

    }
}

