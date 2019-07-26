package html.jsoup.haha.util.Demo.demo2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


//   static String htmlStr = "\n" +
//            "<!DOCTYPE html><html><head><meta charset=utf-8><meta http-equiv=X-UA-Compatible content=\"IE=edge,chrome=1\"><meta name=viewport content=\"width=device-width,initial-scale=1\"><meta name=viewport content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"><meta http-equiv=X-UA-Compatible content=\"IE=9\"><title>Invitation Task</title><link href=./static/css/app.0.3c6b6e431d1bf6e7532e.css rel=stylesheet></head><body><div id=app></div><script type=text/javascript src=./static/js/app.manifest.881aa9a2ac57309401a1.js></script><script type=text/javascript src=./static/js/app.0.3c6b6e431d1bf6e7532e.js></script></body></html>";


    //static String htmlStr = "<!DOCTYPE html><html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\" /><title>TalkU - Free Phone Calls, Texts & Walkie Talkie, PTT</title><meta name=\"description\" content=\"TalkU is a mobile app for iPhone and Android, that lets you make free phone calls and send free text messages, share photos, videos and location with your friends in anywhere, anytime. TalkU can even turn your phone into a live Walkie Talkie, simply push to talk! TalkU has seamlessly integration with Facebook. With TalkU, you can talk to your Facebook friends on the phone never worring about your cell calling minutes.\"    /><meta name=\"keywords\" content=\"free phone calls, free video calls, free calls, free SMS, free text, free text message, free voip calls, cheap VoIP calls, VoIP phone call, softphone, free international calls, cheap international calls, free long distance calls, calling cards, mobile messenger, messaging, message, mobile chat, call Facebook friend, chat Facebook friend, Walkie Talkie, push to talk, PTT, direct connect, directconnect, Sprint, app, Smartphone, TalkU\"    /><link rel=\"shortcut icon\" HREF=\"http://resource.talkyou.me/men/images/favicon.ico\" /><link rel=\"stylesheet\" href=\"css/index.min.css\" /><script type=\"text/javascript\" src=\"http://resource.talkyou.me/js/jquery.min.js\"></script><script type=\"text/javascript\" src=\"http://resource.talkyou.me/res/v5/js/gautils.js\"></script><script type=\"text/javascript\">        initGA();        GASendPage();        $(document).ready(function() {            initClick();        })        function initClick() {            $(\"#google_link\").click(function() {                GASendEvent(getPathName(), 'google_link_click', \"\");            });        }</script></head><body><div class=\"header_bg\"></div><div class=\"header talku_header\"><div class=\"header_text header_text_big\">Come and join us! Surprises are waiting for you!</div><div class=\"header_text header_text_small\">(Once you join us, you’ll get at least 3 free credits!)</div></div><div class=\"container\"><div class=\"clue1 clue\"><div class=\"title\">Open the<a id=\"google_link\" href=\"https://www.google.com/search?q=Instagram+followers\" target=\"_blank\">Google Link</a>, and find out<br>the Gainfollowers website.</div><div class=\"text\"><span class=\"finger\"></span>Hey, I’m the website! Scroll down and click ‘More results' to find me!</div><img style=\"margin-top: 10px\" src=\"img/screenshot5.png\"></div><div class=\"clue2 clue \"><div class=\"title\">Enter the Gainfollowers website, and<br>find the redeem code.</div><div class=\"text\"><span class=\"finger\"></span>Tips: Count to 20，Comes the redeem code! Redeem code is like this</div><img style=\"margin-top: 10px\" src=\"img/code.png\"></div><div class=\"step\"><div class=\"got_code\"></div><div class=\"text\">Wow, congratulations! Copy it and go redeem your gifts!</div><div class=\"hr\"></div><div class=\"step_hr\"></div><div class=\"goto\">Open<span class=\"talk_app app\"></span></div><span class=\"arrow\"></span><div class=\"find_bot\">More</a></div><span class=\"arrow\"></span><div class=\"make_sure\">Purchase Credits</div><span class=\"arrow\"></span><div class=\"make_sure\">Redeem</div><span class=\"arrow\"></span><div class=\"gift\"></div></div></div><div class=\"footer\"><div class=\"footer\"><div class=\"text\">                launched by<span class=\"app_icon talku\"></span>TalkU and Gainfollowers!<br>Welcome to Scavenger Hunt TalkU Scavenger Hunt</div></div></div></body></html>";
    static String htmlStr = "\n" +
            "<!DOCTYPE html><html><head><meta charset=utf-8><meta http-equiv=X-UA-Compatible content=\"IE=edge,chrome=1\"><meta name=viewport content=\"width=device-width,initial-scale=1\"><meta name=viewport content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no\"><meta http-equiv=X-UA-Compatible content=\"IE=9\"><title>Invitation Task</title><link href=./static/css/app.0.3c6b6e431d1bf6e7532e.css rel=stylesheet></head><body><div id=app></div><script type=text/javascript src=./static/js/app.manifest.881aa9a2ac57309401a1.js></script><script type=text/javascript src=./static/js/app.0.3c6b6e431d1bf6e7532e.js></script></body></html>";

    public static void main(String[] args) {
        getCssStr();
        getImgStr();
        test();
        List<String> listImg = findAllImgLinks(htmlStr);

        System.out.println("listImg = " + Arrays.toString(listImg.toArray()));


        List<String> listJs = findAllJSLinks(htmlStr);

        System.out.println("listJs = " + Arrays.toString(listJs.toArray()));


        List<String> listCss = findAllCssLinks(htmlStr);

        System.out.println("listCss = " + Arrays.toString(listCss.toArray()));
    }

    public static void getImgStr() {

        System.out.println("Hello World!");

        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();

            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        pics.forEach(System.out::println);

    }


    public static void getCssStr() {

        System.out.println("Hello World!");

        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
//        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            System.out.println("img = " + img);
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        pics.forEach(System.out::println);

    }


    private static void test() {
        // 查找的字符串

        //正则表达式
        String pattern = "<img(.*?)(png)"; //Java正则表达式以括号分组，第一个括号表示以"（乙方）:"开头，第三个括号表示以" "(空格)结尾，中间括号为目标值，
        // String pattern = "<img.*src(.*?)(png)"; //Java正则表达式以括号分组，第一个括号表示以"（乙方）:"开头，第三个括号表示以" "(空格)结尾，中间括号为目标值，
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 创建 matcher 对象
        Matcher m = r.matcher(htmlStr);
        while (m.find()) {
            /*
             自动遍历打印所有结果   group方法打印捕获的组内容，以正则的括号角标从1开始计算，我们这里要第2个括号里的
             值， 所以取 m.group(2)， m.group(0)取整个表达式的值，如果越界取m.group(4),则抛出异常
           */


            String str = m.group(0);
            System.out.println("Found value 0: " + str);
            String patternSrc = "src=(.*?)(png)";

            Pattern pSrc = Pattern.compile(patternSrc);
            Matcher mSrc = pSrc.matcher(str);
            while (mSrc.find()) {
                System.out.println("Found value src: " + mSrc.group(1));
            }
            System.out.println("Found value: " + m.group(1));
        }
    }


    public static List<String> findAllImgLinks(String src) {
        List<String> list = new ArrayList<>();
        String start = "<img";
        String end = "\\.png|\\.jpg";
        String pattern = "(" + start + ")" + "(.*?)" + "(" + end + ")";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);
        while (m.find()) {
            String str = m.group(0);
            String start2 = "src=";
            String patternSrc = "(" + start2 + ")" + "(.*?)" + "(" + end + ")";
            Pattern pSrc = Pattern.compile(patternSrc);
            Matcher mSrc = pSrc.matcher(str);
            while (mSrc.find()) {
                list.add(mSrc.group(2) + mSrc.group(3));
            }

        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            String link = list.get(i);
            if (!link.startsWith("http")) {
                list.set(i, "__" + link);
            }
        }

        return list;
    }


    public static List<String> findAllJSLinks(String src) {
        List<String> list = new ArrayList<>();
        String start = "<script";
        String end = "\\.js";
        String pattern = "(" + start + ")" + "(.*?)" + "(" + end + ")";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);
        while (m.find()) {
            String str = m.group(0);
            String start2 = "src=";
            String patternSrc = "(" + start2 + ")" + "(.*?)" + "(" + end + ")";
            Pattern pSrc = Pattern.compile(patternSrc);
            Matcher mSrc = pSrc.matcher(str);
            while (mSrc.find()) {
                list.add(mSrc.group(2) + mSrc.group(3));
            }
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            String link = list.get(i);
            if (!link.startsWith("http")) {
                list.set(i, "__" + link);
            }
        }

        return list;
    }


    public static List<String> findAllCssLinks(String src) {
        List<String> list = new ArrayList<>();
        String start = "<link";
        String end = "\\.css";
        String pattern = "(" + start + ")" + "(.*?)" + "(" + end + ")";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(src);
        while (m.find()) {
            String str = m.group(0);
            String start2 = "href=";
            String patternSrc = "(" + start2 + ")" + "(.*?)" + "(" + end + ")";
            Pattern pSrc = Pattern.compile(patternSrc);
            Matcher mSrc = pSrc.matcher(str);
            while (mSrc.find()) {
                list.add(mSrc.group(2) + mSrc.group(3));
            }
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            String link = list.get(i);
            if (!link.startsWith("http")) {
                list.set(i, "__" + link);
            }
        }

        return list;
    }




    public static int lastIndexLetter(String str, char ch, int lin) {
        char[] array = str.toCharArray();
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] == ch && --lin == 0) {
                return i;
            }
        }
        return -1;
    }


}
