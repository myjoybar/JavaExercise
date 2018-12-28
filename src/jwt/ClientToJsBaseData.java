package jwt;

/**
 * Created by joybar on 2018/11/13.
 */
public class ClientToJsBaseData {

    public String businessType = "1";
    public String osType = "Android";
    public String userId = "1234";
    public String deviceId = "android";
    public String token = "abcde";
    public String version = "1.0.0";
    public String isoCC = "cn";
    public String jwtToken = "";
    public boolean isDev = true;

    @Override
    public String toString() {
        return "ClientToJsBaseData{" +
                "businessType='" + businessType + '\'' +
                ", osType='" + osType + '\'' +
                ", userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", token='" + token + '\'' +
                ", version='" + version + '\'' +
                ", isoCC='" + isoCC + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", isDev=" + isDev +
                '}';
    }
}
