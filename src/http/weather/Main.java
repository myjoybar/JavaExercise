package http.weather;

import http.HttpRequest;

import java.io.IOException;
import java.util.HashMap;

public class Main {


  // static String url = "https://api.heweather.com/s6/weather/now";
   static String url1 = "https://free-api.heweather.net/s6/weather";
   static String url2 = "https://free-api.heweather.net/s6/weather/now";



    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");
        getNowWeather();

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
}
