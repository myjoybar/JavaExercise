package json;

import json.data.ChatNewThreeAdConfig;

public class Main {

    public static void main(String[] args) {

        String jsonData ="{ \"overAll\": 1, \"surpriseTotalCount\": 3, \"minTime\": 3, \"defaultTime\": 15, \"accessBottomConfig\": { \"overAll\": 1, \"autoDismissTime\": 5 }, \"accessRightDownConfig\": { \"overAll\": 1, \"autoDismissTime\": 5, \"chatSessionFreeTime\": 8 } }";
        System.out.println("Hello World!");

        ChatNewThreeAdConfig chatNewThreeAdConfig = GsonUtil.parseJsonWithGson(jsonData, ChatNewThreeAdConfig.class);
                System.out.println(chatNewThreeAdConfig.getAccessBottomConfig().getAutoDismissTime());

    }
}
