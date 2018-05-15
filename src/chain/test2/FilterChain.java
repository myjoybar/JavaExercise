package chain.test2;


import chain.test2.interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2018/5/15.
 */
public class FilterChain {
    public List<Filter> mFilters = new ArrayList<>();


    public FilterChain addFilter(Filter filter){
        mFilters.add(filter);
        return this;
    }

    public String doChainFilter(String content) {
        for(Filter filter : mFilters){
            content = filter.doFilter(content);
        }
        return content;
    }


}
