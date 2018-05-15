package chain.test1;

import java.util.ArrayList;
import java.util.List;

public class TestIntercpter2 {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        // 需要被过滤的语句
        String msg = "被就业了：），敏感信息，<script>";
        //创建Request、Response对象
        Request req = new Request();
        Response resp = new Response();
        req.reqStr = msg;
        resp.respStr = "response";
        //搞一个过滤链，链上有两个过滤器
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter())
                .addFilter(new SensitiveFilter());
        //开始过滤
        chain.doFilter(req, resp);
        System.out.println(req.reqStr);
        System.out.println(resp.respStr);
    }

    public static class Request {
        //在Request中只保持了一个reqStr字段记录对Request的操作
        //为了方便模拟，没有将reqStr设置为private
        String reqStr;
    }

    public static class Response {
        //在Response中只保持了一个respStr字段记录对Response的操作
        //为了方便模拟，没有将respStr设置为private
        String respStr;
    }

    public static interface Filter {
        void doFilter(Request req, Response resp, FilterChain chain);
    }

    public static class HtmlFilter implements Filter {
        public void doFilter(Request req, Response resp, FilterChain chain) {
            //过滤req.reqStr中的HTML标记
            req.reqStr = req.reqStr.replace("<", "<").replace(">", ">");
            req.reqStr += "---HtmlFilter()---";
            chain.doFilter(req, resp);
            resp.respStr += "---HtmlFilter()---";
        }
    }

    public static class SensitiveFilter implements Filter {
        public void doFilter(Request req, Response resp, FilterChain chain) {
            // 过滤req.reqStr中的敏感词
            req.reqStr = req.reqStr.replace("敏感", "").replace("被就业", "就业");
            req.reqStr += "===SensitiveFilter";
            chain.doFilter(req, resp);
            resp.respStr += "===SensitiveFilter";
        }
    }

    public static class FilterChain {
        private List<Filter> filters = new ArrayList<Filter>();
        //调用链上的过滤器时，记录过滤器的位置用
        private int index = 0;

        public FilterChain addFilter(Filter f) {
            filters.add(f);
            return this;
        }

        public void doFilter(Request req, Response resp) {
            if (index == filters.size()) return;
            //得到当前过滤器
            Filter f = filters.get(index);
            index++;
            f.doFilter(req, resp, this);
        }
    }


}
