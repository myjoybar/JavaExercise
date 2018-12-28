//package jwt;
//
//import com.auth0.jwt.Algorithm;
//import com.auth0.jwt.JWTSigner;
//import com.auth0.jwt.JWTVerifier;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import json.GsonUtil;
//import sun.misc.BASE64Decoder;
//
//import java.security.KeyFactory;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JWTUtils {
//
//    //private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
//    static String privateKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAO3uAcg01EED9cSx" + "zVFjym+pJ4XObgx77+PUpfNj48PjuqDVwQrgHeW6YSlZss4fPE/omlzMz+OmKzpU" + "jGqDLg2RGbpC+5n4JNLeeofG3zRM7S6vpoDkLnIvLIBPRFFiRo0ubiDzWGVSLeJw"
//            + "s05vSeh0zLzVgAeh0+b42N9mmu1XAgMBAAECgYEAxWYy+kzCUNKdRDyT8NPPL4by" +
//            "8HPNH/RvmeFicaVNYcd9nlTZ3VEF3QQd+nWeAJ8vpciA0T9ntyK1OKbO/MurFyLl" + "gpfbeoLqV8CjRd9FKBOxFUwfnJSiuXmLcOLCyqPT2Z4lN+eEgbnVOISSCb7IPsBZ"
//            + "ZCdWMkQ2YjHOilj0zukCQQD391dgPDgCYxNOopw8TF+/R9lI3eUL3IShsG2qrAc0" +
//            "xNurQYSxvA+p5HR9JRDv7zxEkWbsECKzGKCT7ppUNhP1AkEA9aNsEKXOTb1xG+J0" + "ZbLanQ4Z13AHnDpDj6fRz1BnHI82m+vi4X2OSnsDypw+5YvPTeD2suZvWi3xFcfW"
//            + "fzp4mwJBAMTxuoBA0+txbWBDXvu1XUa7diSduNHW77DMRA4OXBrZT++RNidEStyR" +
//            "CsRqsC0hQijjo29S0XyVztQv6nuACBECQQDiRaH8S+AYuJOCzj3OmMzMs/qV+/rm" + "rL0jjcG1qSjyo/H3+3jJonD6pwq9DuTZasqRwNM/xQl6FqvoFme+V0xVAkEAzA4y"
//            + "B/XyzbeFAhQSnsAcqEbfgWW4T3ykbzMHgQ5OfWY8fTi/4rU01KZBIsGXfye0/YDf" + "wtUrfKkoh1EfczKhMw==";
//    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDt7gHINNRBA/XEsc1RY8pvqSeF\n" +
//            "zm4Me+/j1KXzY+PD47qg1cEK4B3lumEpWbLOHzxP6JpczM/jpis6VIxqgy4NkRm6\n" +
//            "QvuZ+CTS3nqHxt80TO0ur6aA5C5yLyyAT0RRYkaNLm4g81hlUi3icLNOb0nodMy8\n" + "1YAHodPm+NjfZprtVwIDAQAB";
//
//    private static final String EXP = "exp";
//    private static final String PAYLOAD = "payload";
//
//    //加密，传入一个对象和有效期
//    public static <T> String sign(T object, long maxAge) {
//        try {
//
//            final JWTSigner signer = new JWTSigner(getPrivateKey(privateKey));
//            JWTSigner.Options options = new JWTSigner.Options();
//            options.setAlgorithm(Algorithm.RS256);
//
//            final Map<String, Object> claims = new HashMap<String, Object>();
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonString = mapper.writeValueAsString(object);
//            claims.put(PAYLOAD, jsonString);
//            claims.put(EXP, System.currentTimeMillis() + maxAge);
//            //claims.put("sercret", jsonString);
//            return signer.sign(claims, options);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //解密，传入一个加密后的token字符串和解密后的类型
//    public static <T> T unsign(String jwt, Class<T> classT) {
//        try {
//            PublicKey SECRET = getPublicKey(publicKey);
//            final JWTVerifier verifier = new JWTVerifier(SECRET);
//            final Map<String, Object> claims = verifier.verify(jwt);
//            System.out.println(claims);
//            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
//                long exp = (Long) claims.get(EXP);
//                long currentTimeMillis = System.currentTimeMillis();
//                if (exp > currentTimeMillis) {
//                    String json = (String) claims.get(PAYLOAD);
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    return objectMapper.readValue(json, classT);
//                }
//            }
//            return null;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static PublicKey getPublicKey(String key) throws Exception {
//        byte[] keyBytes;
//        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(keySpec);
//        return publicKey;
//    }
//
//    public static PrivateKey getPrivateKey(String key) throws Exception {
//        byte[] keyBytes;
//        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//        return privateKey;
//    }
//
//
//    public static ClientToJsBaseData getClientToJsBaseData() {
//        ClientToJsBaseData clientToJsBaseData = new ClientToJsBaseData();
//        clientToJsBaseData.jwtToken = sign(clientToJsBaseData, 6000 * 60 * 1000);
//        return clientToJsBaseData;
//
//    }
//
//    public static ClientToJsBaseData getClientToJsBaseData(ClientToJsBaseData clientToJsBaseData ) {
//        clientToJsBaseData.jwtToken = sign(clientToJsBaseData, 6000 * 60 * 1000);
//        return clientToJsBaseData;
//
//    }
//
//    public static void main(String args[]) throws Exception {
//
//
//        String msg = GsonUtil.parseBeanToGson(getClientToJsBaseData()).toString();
//        System.out.println( " msg= "+msg);
//        ClientToJsBaseData clientToJsBaseData = GsonUtil.parseJsonStrToBean(msg,ClientToJsBaseData.class);
//        System.out.println( " clientToJsBaseData.jwtToken= "+clientToJsBaseData.jwtToken);
//
//
//       /* PublicKey publicKey1 = getPublicKey(publicKey);
//        String jwt ="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJwYXlsb2FkIjoiaXQgaXMgYSB0ZXN0IGRlbW8ifQ
//        .Chi_SQTUGHIzxSDy7XKMM4nLbDgoAfpoFYDhM6Gvjy0GWRkqcl099dDeSTmLEaIe01OyKMk_F-2ja8YbkRKyo9hQISOmglvXH1pQcM2Km6I5HvC81jInA25mmaMzwr
//        -6PIjomwTBuupx9uJG97OIVCasJeXiI4cvXKcnamZ3PkI";
//        JWTVerifier verifier = new JWTVerifier(publicKey1);
//        Map<String,Object> claims= verifier.verify(jwt);
//        System.out.println(claims);*/
//
//
////        PointInfo info = new PointInfo();
////        info.setGrade(1);
////        System.out.println(sign(info, 1000));
////        System.out.println( unsign(sign(info, 1000), PointInfo.class));
//
//    }
//}
