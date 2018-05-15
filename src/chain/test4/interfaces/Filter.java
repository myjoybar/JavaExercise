package chain.test4.interfaces;

import chain.test4.Request;
import chain.test4.Response;

/**
 * Created by joybar on 2018/5/15.
 */
public interface Filter {
    void doFilter(Request request, Response response);
}
