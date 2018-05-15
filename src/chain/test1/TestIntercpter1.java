package chain.test1;

import java.util.ArrayList;
import java.util.List;

public class TestIntercpter1 {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        //需要被过滤的语句
        String msg = "被就业了：），敏感信息，<script>";
        //搞一个过过滤链
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        //实例化处理类
        MsgProcessor mp = new MsgProcessor(msg,chain);
        String r = mp.process();
        System.out.println(r);
    }

    public static interface Filter {
        String doFilter(String str);
    }

    public static class FilterChain implements Filter {
        public List<Filter> filters= new ArrayList<Filter>();
        public FilterChain addFilter(Filter f){
            filters.add(f);
            return this;
        }
        public String doFilter(String msg) {//执行filters中的doFilter方法即可
            String r = msg;
            for(Filter f : filters){
                r = f.doFilter(r);
            }
            return r;
        }
    }
    public static class HtmlFilter implements Filter {
        public String doFilter(String msg) {
            String r = msg;
            //过滤msg中的HTML标记
            r = r.replace("<", "<").replace(">", ">");
            return r;
        }
    }

    public static class SensitiveFilter implements Filter {
        public String doFilter(String msg) {
            String r = msg;
            //过滤敏感词
            r = r.replace("敏感", "").replace("被就业", "就业");
            return r;
        }
    }
    public static class MsgProcessor {
        private String msg;
        private FilterChain chain = new FilterChain();
        public MsgProcessor(String msg,Filter Chain){
            this.msg = msg;
            this.chain = chain;
        }
        public String process(){
            return chain.doFilter(msg);
        }
    }
}
