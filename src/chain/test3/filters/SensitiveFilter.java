package chain.test3.filters;

import chain.test3.interfaces.Filter;

/**
 * Created by joybar on 2018/5/15.
 */
public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String content) {
        return content
                .replace("法伦功", "flg")
                .replace("政府", "zf");
    }
}


