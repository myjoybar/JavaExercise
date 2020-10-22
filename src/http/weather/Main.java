package http.weather;

import http.HttpRequest;
import http.http2.HttpRequestUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class Main {


  // static String url = "https://api.heweather.com/s6/weather/now";
   static String url1 = "https://free-api.heweather.net/s6/weather";
   static String url2 = "https://free-api.heweather.net/s6/weather/now";



    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");
//        getNowWeather();
//        getInsUserInfo();
        test();

    }


    private static void getNowWeather() throws IOException {
        //location=beijing&username=HE161025121212039&t=1477455132&sign=kNWMNt1fGAm2nIr54afBg
        HashMap<String,String> mapParam = new HashMap<>();
        mapParam.put("location","beijing");
        mapParam.put("username","HE1903171121401706");
        mapParam.put("t",System.currentTimeMillis()/1000+"");
        String sign = WeatherSignatureUtils.getSignature(mapParam,"36862f6823a041cfb670e3a523930c6b");
        mapParam.put("sign", sign);
        String response = HttpRequest.sendGet(url2,mapParam);
        System.out.println("response = "+response);

    }


    private static void  getInsUserInfo(){
       String url = "https://www.instagram.com/web/search/topsearch/?context=blended&query=joy.dingtone";
        //   String url = "https://www.instagram.com/web/search/topsearch/";
        HashMap<String,String> mapParam = new HashMap<>();
        mapParam.put("context","blended");
        mapParam.put("query","joy.dingtone");
        String response = HttpRequest.sendGet(url,null);
        System.out.println("response = "+response);
    }

    ;
    private static void  test(){
           String url = "https://www.instagram.com/web/search/topsearch/";
        HashMap<String,String> mapParam = new HashMap<>();
        mapParam.put("context","blended");
        mapParam.put("query","joy.dingtone");

        HashMap<String,String> mapHeaders = new HashMap<>();
        mapParam.put("host","www.instagram.com");
        mapParam.put("accept-encoding","gzip");
        mapParam.put("user-agent","okhttp/3.5.0");
        try {
            HttpURLConnection connGet = (HttpURLConnection) HttpRequestUtil.sendGetRequest(url,
                    mapParam,
                    mapHeaders);
            if (null == connGet)
            {
                System.out.println( "连接网络失败");
            }
            else {
                InputStream inStream = connGet.getInputStream();
                byte[] data = read(inStream);
                String json = new String(data);
                System.out.println( "json = "+json);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static byte[] read(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


}
