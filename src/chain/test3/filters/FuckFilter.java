package chain.test3.filters;


import chain.test3.interfaces.Filter;

/**
 * Created by joybar on 2018/5/15.
 */
public class FuckFilter implements Filter {
    @Override
    public String doFilter(String content) {
        return content.replace("尼玛", "xx")
                .replace("你妈", "xx");
    }


}

