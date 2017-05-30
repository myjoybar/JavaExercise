package designpattern.InterceptingFilter;

import designpattern.InterceptingFilter.interfaces.Filter;

/**
 * Created by joybar on 31/05/17.
 */
public class FilterManager {

    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }

}
