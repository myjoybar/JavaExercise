package json;

import com.google.gson.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;
import json.data.ChatNewThreeAdConfig;
import json.data.ClassBean;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String jsonData ="{ \"overAll\": 1, \"surpriseTotalCount\": 3, \"minTime\": 3, \"defaultTime\": 15, \"accessBottomConfig\": { \"overAll\": 1, \"autoDismissTime\": 5 }, \"accessRightDownConfig\": { \"overAll\": 1, \"autoDismissTime\": 5, \"chatSessionFreeTime\": 8 } }";
        System.out.println("Hello World!");

        ChatNewThreeAdConfig chatNewThreeAdConfig = GsonUtil.parseJsonStrToBean(jsonData, ChatNewThreeAdConfig.class);
                System.out.println(chatNewThreeAdConfig.toString());

        System.out.println("Hello World!");
            String classStr = "{\"className\":\"9班\",\"amount\":30,\"students\":[{\"name\":\"rose\",\"age\":\"25\"},{\"name\":\"jack\",\"age\":\"26\"}]}";

        ClassBean classBean = GsonUtil.parseJsonStrToBean(classStr,ClassBean.class);
        System.out.println(classBean.toString());
        System.out.println("Hello World!");



        String listClassStr = "[{\"className\":\"9班\",\"amount\":30,\"students\":[{\"name\":\"rose\",\"age\":\"25\"},{\"name\":\"jack\",\"age\":\"26\"}]},{\"className\":\"10班\",\"amount\":30,\"students\":[{\"name\":\"AA\",\"age\":\"25\"},{\"name\":\"BB\",\"age\":\"26\"}]}]";

        List<ClassBean> list = GsonUtil.parseJsonArrayStrToList(listClassStr,ClassBean.class);

        System.out.println(Arrays.toString(list.toArray()));


        System.out.println("Hello World!");
        System.out.println(GsonUtil.parseBeanToStr(classBean));
        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseBeanToStr(list));

        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseBeanToGson(classBean));

        System.out.println("Hello World!");

        System.out.println(GsonUtil.parseListBeanToGson(list,ClassBean.class));

        System.out.println("Hello World!");

        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.add("aa",GsonUtil.parseBeanToGson(classBean));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);



    }
}
