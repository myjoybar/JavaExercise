package chain.test4;


import chain.test4.interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2018/5/15.
 */
public class FilterChain implements Filter {
    public List<Filter> mFilters = new ArrayList<>();


    public FilterChain addFilter(Filter filter){
        mFilters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response) {
        for(Filter filter : mFilters){
            filter.doFilter(request, response);
        }
    }
}