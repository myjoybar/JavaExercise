package chain.test3.filters;


import chain.test3.interfaces.Filter;

/**
 * Created by joybar on 2018/5/15.
 */
public class flagFilter implements Filter {
    @Override
    public String doFilter(String content) {
        return content.replace("flag", "xx");
    }


}

