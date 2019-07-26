package json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2017/7/27.
 */
public class GsonUtil {

    //将Json数据解析成相应的映射对象
    public static <T> T parseJsonStrToBean(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

    //将Json数据解析成相应的映射对象
    public static <T> T parseJsonStrToBean(String jsonData,Type type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
    public static <T> List<T> parseJsonArrayStrToList(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }


    public static String parseBeanToStr(Object objBean) {
        Gson gson = new Gson();
        String obj = gson.toJson(objBean);
        return obj;
    }


    public static JsonObject parseBeanToGson(Object obj) {
        Gson gson = new Gson();
        String jsonstr = gson.toJson(obj);
        JsonObject returnData = new JsonParser().parse(jsonstr).getAsJsonObject();
        return returnData;
    }

    public static <T> JsonArray parseListBeanToGson(List<T> list, Class<T> type) {

        Gson gson = new Gson();
        String jsonstr = gson.toJson(list);
        JsonParser parser = new JsonParser();
        JsonArray Jarray = parser.parse(jsonstr).getAsJsonArray();
        for (JsonElement obj : Jarray) {
            T cse = gson.fromJson(obj, type);
            list.add(cse);
        }
        return Jarray;
    }

    public static <T> List<T> getObjectList(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
