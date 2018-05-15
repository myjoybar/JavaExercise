package chain.test5.interfaces;

import chain.test5.Request;
import chain.test5.Response;

/**
 * Created by joybar on 2018/5/15.
 */
public interface Filter {
    void doFilter(Request request, Response response, Filter chainFilter);
}
