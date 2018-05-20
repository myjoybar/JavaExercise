package test;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by joybar on 02/01/18.
 */
public class MessageModel {

    private String msg;
    private Integer code;

    private Map<String, Object> result;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
