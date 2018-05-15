package chain.test3;

import chain.test3.filters.FuckFilter;
import chain.test3.filters.SensitiveFilter;
import chain.test3.filters.flagFilter;

public class Main {

    //https://www.jianshu.com/p/8a157cb73434
    public static void main(String[] args) {

        //要被过滤的内容
        String content = "<scrpit> flag法伦功一定要灭掉，尼玛的，你妈的。中国政府真的太好了，呵呵，呵呵";
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new FuckFilter())
                .addFilter(new SensitiveFilter());

        //过滤后的内容
        String filterContent = filterChain.doFilter(content);
        //输出内容
        System.out.println("filterChain="+filterContent);


        //在一个过滤链中加上一个过滤链
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(new flagFilter())
                .addFilter(filterChain);
        //过滤后的内容
        String filterContent2 = filterChain1.doFilter(content);
        //输出内容
        System.out.println("filterChain1="+filterContent2);




    }


}
