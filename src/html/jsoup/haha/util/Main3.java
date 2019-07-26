package html.jsoup.haha.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {

    static String src = "\":{\"__typename\":\"GraphImage\",\"id\":\"2058910868390045694\",\"shortcode\":\"BySuIa2lGf-\",\"dimensions\":{\"height\":1080,\"width\":1080},\"gating_info\":null,\"media_preview\":null,\"display_url\":\"https://scontent-sjc3-1.cdninstagram.com/vp/916a8b8e829010dd9870f7f0c6035c2a/5D877130/t51.2885-15/e35/60915580_3252223618136389_8806631729492373635_n.jpg?_nc_ht=scontent-sjc3-1.cdninstagram.com\",\"display_resources\":[{\"src\":\"https://scontent-sjc3-1.cdninstagram.com/vp/a88dce03b76671c7746a0a08fa2c496b/5D8CB68A/t51.2885-15/sh0.08/e35/s640x640/60915580_3252223618136389_8806631729492373635_n.jpg?_nc_ht=scontent-sjc3-1.cdninstagram.com\",\"config_width\":640,\"config_height\":640},{\"src\":\"https://scontent-sjc3-1.cdninstagram.com/vp/938b71e03da6ac7d106db0a8afb8f823/5D8F534E/t51.2885-15/sh0.08/e35/s750x750/60915580_3252223618136389_8806631729492373635_n.jpg?_nc_ht=scontent-sjc3-1.cdninstagram.com\",\"config_width\":750,\"config_height\":750},{\"src\":\"https://scontent-sjc3-1.cdninstagram.com/vp/916a8b8e829010dd9870f7f0c6035c2a/5D877130/t51.2885-15/e35/60915580_3252223618136389_8806631729492373635_n.jpg?_nc_ht=scontent-sjc3-1.cdninstagram.com\",\"config_width\":1080,\"config_height\":1080}],\"accessibility_caption\":\"No photo description available.\",\"is_video\":false,\"should_log_client_event\":false,\"tracking_token\":\"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjp0cnVlLCJ1dWlkIjoiNzI2NDhjOGEyMWU5NDlhMzgwNWI1MDA4NWM1ZjI1ZWUyMDU4OTEwODY4MzkwMDQ1Njk0Iiwic2VydmVyX3Rva2VuIjoiMTU1OTc5NjI0NzAwNXwyMDU4OTEwODY4MzkwMDQ1Njk0fDEzNzU2NDQ4OTEzfGM0MmMxYjczY2NkOWU0Nzg1MGQzZWYxNzJlNGJjMGE3ZDhhMzZiMWM4MWM2MzQyNGMzMzZhYmY1MjE1ZjJlOTQifSwic2lnbmF0dXJlIjoiIn0=\",\"";
    public static void main(String[] args) {
        List<String> list = findAllDisplayUrl(src);
        System.out.println("src = " + src);
        System.out.println("==========");
        System.out.println("list.size = " + list.size()+" and value = "+Arrays.toString(list.toArray()));

    }

    public static List<String> findAllDisplayUrl(String src) {
        List<String> list = new ArrayList<>();
        String start = "display_url\":\"";
        String end = "\",";
        String pattern = "(" + start + ")" + "(.*?)" + "(" + end + ")";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);
        while (m.find()) {
            String str = m.group(2);
            list.add(str);
        }

        return list;
    }
}
