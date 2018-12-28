package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import json.GsonUtil;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
    static String privateKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAO3uAcg01EED9cSx" + "zVFjym+pJ4XObgx77+PUpfNj48PjuqDVwQrgHeW6YSlZss4fPE/omlzMz+OmKzpU" + "jGqDLg2RGbpC+5n4JNLeeofG3zRM7S6vpoDkLnIvLIBPRFFiRo0ubiDzWGVSLeJw"
            + "s05vSeh0zLzVgAeh0+b42N9mmu1XAgMBAAECgYEAxWYy+kzCUNKdRDyT8NPPL4by" +
            "8HPNH/RvmeFicaVNYcd9nlTZ3VEF3QQd+nWeAJ8vpciA0T9ntyK1OKbO/MurFyLl" + "gpfbeoLqV8CjRd9FKBOxFUwfnJSiuXmLcOLCyqPT2Z4lN+eEgbnVOISSCb7IPsBZ"
            + "ZCdWMkQ2YjHOilj0zukCQQD391dgPDgCYxNOopw8TF+/R9lI3eUL3IShsG2qrAc0" +
            "xNurQYSxvA+p5HR9JRDv7zxEkWbsECKzGKCT7ppUNhP1AkEA9aNsEKXOTb1xG+J0" + "ZbLanQ4Z13AHnDpDj6fRz1BnHI82m+vi4X2OSnsDypw+5YvPTeD2suZvWi3xFcfW"
            + "fzp4mwJBAMTxuoBA0+txbWBDXvu1XUa7diSduNHW77DMRA4OXBrZT++RNidEStyR" +
            "CsRqsC0hQijjo29S0XyVztQv6nuACBECQQDiRaH8S+AYuJOCzj3OmMzMs/qV+/rm" + "rL0jjcG1qSjyo/H3+3jJonD6pwq9DuTZasqRwNM/xQl6FqvoFme+V0xVAkEAzA4y"
            + "B/XyzbeFAhQSnsAcqEbfgWW4T3ykbzMHgQ5OfWY8fTi/4rU01KZBIsGXfye0/YDf" + "wtUrfKkoh1EfczKhMw==";
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDt7gHINNRBA/XEsc1RY8pvqSeF\n" +
            "zm4Me+/j1KXzY+PD47qg1cEK4B3lumEpWbLOHzxP6JpczM/jpis6VIxqgy4NkRm6\n" +
            "QvuZ+CTS3nqHxt80TO0ur6aA5C5yLyyAT0RRYkaNLm4g81hlUi3icLNOb0nodMy8\n" + "1YAHodPm+NjfZprtVwIDAQAB";

    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";

    private static final int MINUTE = 60 * 1000;


    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!111");

        String msg = GsonUtil.parseBeanToGson(getClientToJsBaseData()).toString();
        System.out.println( " msg= "+msg);
        ClientToJsBaseData clientToJsBaseData = GsonUtil.parseJsonStrToBean(msg,ClientToJsBaseData.class);
        System.out.println( " clientToJsBaseData.jwtToken= "+clientToJsBaseData.jwtToken);
       unsign(clientToJsBaseData.jwtToken);
    }




    private static String test22(Object object, long maxAge) throws Exception {
        String info= GsonUtil.parseBeanToStr(object);
        String token = "";
        RSAPublicKey rsaPublicKey = (RSAPublicKey) getPublicKey(publicKey);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) getPrivateKey(privateKey);
        Date exp = new Date(System.currentTimeMillis() + 60* 60 * 1000);//过期时间
        Long time = System.currentTimeMillis() + maxAge;
        System.out.println("time = "+time);
        //1542078024
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
           token = JWT.create()
                    .withClaim(EXP,exp)
                    .withClaim(PAYLOAD, info)
                    .sign(algorithm);

            System.out.println("token = "+token);


        } catch (JWTCreationException exception){
            System.out.println("exception = "+exception.getMessage());
        }

        return token;

    }

    public static  void unsign( String token) throws Exception {
        RSAPublicKey rsaPublicKey = (RSAPublicKey) getPublicKey(publicKey);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) getPrivateKey(privateKey);
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);

            System.out.println("valid signature");
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            System.out.println("Invalid signature/claims ");
        }
    }

    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    public static ClientToJsBaseData getClientToJsBaseData() throws Exception {
        ClientToJsBaseData clientToJsBaseData = new ClientToJsBaseData();
        clientToJsBaseData.jwtToken = test22(clientToJsBaseData, 6 * MINUTE);
        return clientToJsBaseData;

    }

    public static ClientToJsBaseData getClientToJsBaseData(ClientToJsBaseData clientToJsBaseData ) {
        clientToJsBaseData.jwtToken = sign22(clientToJsBaseData, 6 * MINUTE);
        return clientToJsBaseData;

    }


    public  static  String sign22(Object object, long maxAge){
        //RSA


        try {

            RSAPublicKey rsaPublicKey = (RSAPublicKey) getPublicKey(publicKey);
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) getPrivateKey(privateKey);

            Map<String, Object> headerClaims = new HashMap();
            headerClaims.put("alg", "RS256");
            headerClaims.put("typ", "JWT");


            Algorithm algorithmRS = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            String token = JWT.create()
                    .withHeader(headerClaims)
                    .withClaim(EXP,System.currentTimeMillis() + maxAge)
                    .withClaim(PAYLOAD, "rsassssss")
                    .sign(algorithmRS);
            return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
