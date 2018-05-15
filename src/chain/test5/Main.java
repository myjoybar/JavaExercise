package chain.test5;

import chain.test5.filters.FuckFilter;
import chain.test5.filters.SensitiveFilter;

public class Main {

    //https://www.jianshu.com/p/8a157cb73434
    public static void main(String[] args) {

        //要被过滤的内容
        String content = "<scrpit> 法伦功一定要灭掉，尼玛的，你妈的。中国政府真的太好了，呵呵，呵呵";
        Request request = new Request();
        request.setRequestStr(content);
        Response response = new Response();
        response.setResponseStr(content);
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new FuckFilter())
                .addFilter(new SensitiveFilter());

        //过滤后的内容
        filterChain.doFilter(request, response, filterChain);
        //输出内容
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());






    }


}
