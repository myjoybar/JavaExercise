package chain.test2;

import chain.test2.filters.FuckFilter;
import chain.test2.filters.SensitiveFilter;

public class Main {

    public static void main(String[] args) {

        //要被过滤的内容
        String content = "<scrpit> 法伦功一定要灭掉，尼玛的，你妈的。中国政府真的太好了，呵呵，呵呵";
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new FuckFilter())
                .addFilter(new SensitiveFilter());
        //过滤后的内容
        String filterContent = filterChain.doChainFilter(content);
        //输出内容
        System.out.print(filterContent);



    }


}
