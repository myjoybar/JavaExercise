package json;

import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;
import json.data.ChatNewThreeAdConfig;
import json.data.ClassBean;
import json.data.ClassBean.StudentsBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        test1();
//        test2();
        test3();





    }

    private static void test3(){
        ClassBean  classBean = new ClassBean();
        System.out.println(GsonUtil.parseBeanToStr(classBean));

    }

    private static void test1(){
        String jsonData = "{ \"overAll\": 1, \"surpriseTotalCount\": 3, \"minTime\": 3, \"defaultTime\": 15, \"accessBottomConfig\": { \"overAll\": 1, \"autoDismissTime\": 5 }, \"accessRightDownConfig\": { \"overAll\": 1, \"autoDismissTime\": 5, \"chatSessionFreeTime\": 8 } }";
        System.out.println("Hello World!");

        ChatNewThreeAdConfig chatNewThreeAdConfig = GsonUtil.parseJsonStrToBean(jsonData, ChatNewThreeAdConfig.class);
        System.out.println(chatNewThreeAdConfig.toString());

        System.out.println("Hello World!");
        String classStr = "{\"className\":\"9班\",\"amount\":30,\"students\":[{\"name\":\"rose\",\"age\":\"25\"},{\"name\":\"jack\",\"age\":\"26\"}]}";

        ClassBean classBean = GsonUtil.parseJsonStrToBean(classStr, ClassBean.class);
        System.out.println(classBean.toString());
        System.out.println("Hello World!");


        String listClassStr = "[{\"className\":\"9班\",\"amount\":30,\"students\":[{\"name\":\"rose\",\"age\":\"25\"},{\"name\":\"jack\",\"age\":\"26\"}]},{\"className\":\"10班\",\"amount\":30,\"students\":[{\"name\":\"AA\",\"age\":\"25\"},{\"name\":\"BB\",\"age\":\"26\"}]}]";

        List<ClassBean> list = GsonUtil.parseJsonArrayStrToList(listClassStr, ClassBean.class);

        System.out.println(Arrays.toString(list.toArray()));


        System.out.println("Hello World!");
        System.out.println(GsonUtil.parseBeanToStr(classBean));
        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseBeanToStr(list));

        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseBeanToGson(classBean));

        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseListBeanToGson(list, ClassBean.class));

        System.out.println("Hello World!");

        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.add("aa", GsonUtil.parseBeanToGson(classBean));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);


        Map<String, StudentsBean> map1 = new HashMap();
        StudentsBean studentsBean1 = new StudentsBean("Tom", "21");
        StudentsBean studentsBean2 = new StudentsBean("Jose", "22");
        map1.put("tom", studentsBean1);
        map1.put("jose", studentsBean2);



        System.out.println(GsonUtil.parseBeanToStr(map1));

        String mapStr = "{\"tom\":{\"name\":\"Tom\",\"age\":\"21\"},\"jose\":{\"name\":\"Jose\",\"age\":\"22\"}}";
    }

    private static void test2(){
        Map<String, String> HEADER_MAP = new HashMap<>();
        HEADER_MAP.put("Connection", "keep-alive");
        HEADER_MAP.put("Content-Type", "application/json");
        HEADER_MAP.put("X-IG-Connection-Type", "mobile(UMTS)");
        HEADER_MAP.put("X-IG-Capabilities", "3ToAAA==");
        HEADER_MAP.put("Accept-Language", "en-US");

        System.out.println("Map: "+ GsonUtil.parseBeanToStr(HEADER_MAP));

        String mapStr = "{\"X-IG-Capabilities\":\"3ToAAA\\u003d\\u003d\",\"Connection\":\"keep-alive\",\"Accept-Language\":\"en-US\",\"X-IG-Connection-Type\":\"mobile(UMTS)\",\"Content-Type\":\"application/json\"}";



        System.out.println("Map: "+ GsonUtil.parseBeanToStr(HEADER_MAP));


        Map<String, String> HEADER_MAP2 = GsonUtil.GsonToMaps(mapStr);

        for (String key : HEADER_MAP2.keySet()) {
            System.out.println("key= " + key + " and value= " + HEADER_MAP2.get(key).toString());
        }
    }


    private static void testMap(Map<String, StudentsBean> map) {
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key).toString());
        }

    }
    private static void testMap22( Map<String, Map<String, StudentsBean>> map) {
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " " );
            testMap(map.get(key));
        }

    }

}
