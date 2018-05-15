package chain.test4.filters;

import chain.test4.Request;
import chain.test4.Response;
import chain.test4.interfaces.Filter;

/**
 * Created by joybar on 2018/5/15.
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response) {
        String requestFilterStr = request.getRequestStr()
                .replace("法伦功", "flg")
                .replace("政府", "zf");
        request.setRequestStr(requestFilterStr);

        String responseFilterStr = response.getResponseStr()
                .replace("法伦功", "---")
                .replace("政府", "--");
        response.setResponseStr(responseFilterStr + "|SensitiveFilter");

    }
}


