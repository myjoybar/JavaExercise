package chain.test5;


import chain.test5.interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2018/5/15.
 */
public class FilterChain implements Filter {
    public List<Filter> mFilters = new ArrayList<>();
    public int index = 0;

    public FilterChain addFilter(Filter filter){
        mFilters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, Filter chainFilter) {
//        for(Filter filter : mFilters){
//            filter.doFilter(request, response);
//        }

        if(index == mFilters.size()) return;
        Filter filter = mFilters.get(index);
        index ++;
        System.out.println("doFilter:doFilter");
        System.out.println("index="+index);
        filter.doFilter(request, response, this);


    }
}