package chain.test5.filters;

import chain.test5.Request;
import chain.test5.interfaces.Filter;
import chain.test5.Response;

/**
 * Created by joybar on 2018/5/15.
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, Filter chainFilter) {
        System.out.println("doFilter:SensitiveFilter");

        String requestFilterStr = request.getRequestStr()
                .replace("法伦功", "flg")
                .replace("政府", "zf");
        request.setRequestStr(requestFilterStr);

        chainFilter.doFilter(request, response, chainFilter);

        System.out.println("doFilter:SensitiveFilter__response");

        String responseFilterStr = response.getResponseStr()
                .replace("法伦功", "---")
                .replace("政府", "--");
        response.setResponseStr(responseFilterStr + "|SensitiveFilter");

    }
}


