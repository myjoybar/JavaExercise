package http.http2;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by joybar on 2019/8/22.
 */
public class HttpRequestUtil {

    /**
     * 发送GET请求
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */

    private static final int TIMEOUT_IN_MILLIONS = 10*1000;

    public static URLConnection sendGetRequest(String url,
                                               Map<String, String> params, Map<String, String> headers)
            throws Exception
    {
        StringBuilder buf = new StringBuilder(url);
        Set<Entry<String, String>> entrys = null;
        // 如果是GET请求，则请求参数在URL中
        if (params != null && !params.isEmpty())
        {
            buf.append("?");
            entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                buf.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                        .append("&");
            }
            buf.deleteCharAt(buf.length() - 1);
        }
        URL url1 = new URL(buf.toString());
        HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
        // 设置请求头
        if (headers != null && !headers.isEmpty())
        {
            entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        if (conn.getResponseCode() == 200)
        {
            return conn;
        }
        else
        {

            return null;
        }
    }

    /**
     * 发送POST请求
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static URLConnection sendPostRequest(String url,
                                                Map<String, String> params, Map<String, String> headers)
            throws Exception
    {
        StringBuilder buf = new StringBuilder();
        Set<Entry<String, String>> entrys = null;
        // 如果存在参数，则放在HTTP请求体，形如name=aaa&age=10
        if (params != null && !params.isEmpty())
        {
            entrys = params.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                buf.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                        .append("&");
            }
            buf.deleteCharAt(buf.length() - 1);
        }
        URL url1 = new URL(url);
        byte[] entitydata =  buf.toString().getBytes();//得到实体的二进制数据
        HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (headers != null && !headers.isEmpty())
        {
            entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys)
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        OutputStream out = conn.getOutputStream();
        out.write(buf.toString().getBytes("UTF-8"));
        out.flush();
        out.close();
        if (conn.getResponseCode() == 200)
        {
            return conn;
        }
        else
        {
            return null;
        }
    }



}
