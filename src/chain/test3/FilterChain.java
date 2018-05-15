package chain.test3;


import chain.test3.interfaces.Filter;

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
    public String doFilter(String content) {
        for(Filter filter : mFilters){
            content = filter.doFilter(content);
        }
        return content;
    }
}
