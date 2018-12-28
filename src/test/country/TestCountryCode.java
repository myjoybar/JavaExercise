package test.country;

import json.GsonUtil;
import test.country.CountryCode.CcListBean;

import java.util.List;

/**
 * Created by joybar on 2018/8/9.
 */
public class TestCountryCode {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        CountryCode countryCode = GsonUtil.parseJsonStrToBean(jsonStr, CountryCode.class);

        List<CcListBean> ccList = countryCode.getCcList();

        int length = CountryCode_ISO.length;
        int length2 = ccList.size();
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            String iso = CountryCode_ISO[i];
            for (int k = 0; k < length2; k++) {

                if (iso.equals(ccList.get(k).getIso()) && ccList.get(k).getShowRatio() > 0) {
                    flag = true;
                }
            }

            if(flag){
                System.out.print(""+iso+",");
            }
        }

    }

    static String jsonStr = "{\"isPub\":1,\"isOn\":1,\"ccList\":[{\"iso\":\"CN\",\"showRatio\":0},{\"iso\":\"BD\",\"showRatio\":100},{\"iso\":\"SA\",\"showRatio\":100},{\"iso\":\"AE\",\"showRatio\":100},{\"iso\":\"PH\",\"showRatio\":100},{\"iso\":\"PK\",\"showRatio\":100},{\"iso\":\"KW\",\"showRatio\":100},{\"iso\":\"QA\",\"showRatio\":100},{\"iso\":\"IN\",\"showRatio\":100},{\"iso\":\"KZ\",\"showRatio\":100},{\"iso\":\"EG\",\"showRatio\":100},{\"iso\":\"ZA\",\"showRatio\":100},{\"iso\":\"HU\",\"showRatio\":100},{\"iso\":\"RO\",\"showRatio\":100},{\"iso\":\"DK\",\"showRatio\":100},{\"iso\":\"NO\",\"showRatio\":100},{\"iso\":\"MX\",\"showRatio\":100},{\"iso\":\"CU\",\"showRatio\":100},{\"iso\":\"AR\",\"showRatio\":100},{\"iso\":\"BR\",\"showRatio\":100},{\"iso\":\"CL\",\"showRatio\":100},{\"iso\":\"CO\",\"showRatio\":100},{\"iso\":\"VE\",\"showRatio\":100},{\"iso\":\"PH\",\"showRatio\":100},{\"iso\":\"TH\",\"showRatio\":100},{\"iso\":\"VN\",\"showRatio\":100},{\"iso\":\"CN\",\"showRatio\":100},{\"iso\":\"IN\",\"showRatio\":100},{\"iso\":\"PK\",\"showRatio\":100},{\"iso\":\"AF\",\"showRatio\":100},{\"iso\":\"LK\",\"showRatio\":100},{\"iso\":\"MM\",\"showRatio\":100},{\"iso\":\"IR\",\"showRatio\":100},{\"iso\":\"MA\",\"showRatio\":100},{\"iso\":\"DZ\",\"showRatio\":100},{\"iso\":\"TN\",\"showRatio\":100},{\"iso\":\"LY\",\"showRatio\":100},{\"iso\":\"GM\",\"showRatio\":100},{\"iso\":\"SN\",\"showRatio\":100},{\"iso\":\"MR\",\"showRatio\":100},{\"iso\":\"ML\",\"showRatio\":100},{\"iso\":\"GN\",\"showRatio\":100},{\"iso\":\"CI\",\"showRatio\":100},{\"iso\":\"BF\",\"showRatio\":100},{\"iso\":\"NE\",\"showRatio\":100},{\"iso\":\"TG\",\"showRatio\":100},{\"iso\":\"BJ\",\"showRatio\":100},{\"iso\":\"MU\",\"showRatio\":100},{\"iso\":\"LR\",\"showRatio\":100},{\"iso\":\"SL\",\"showRatio\":100},{\"iso\":\"GH\",\"showRatio\":100},{\"iso\":\"NG\",\"showRatio\":100},{\"iso\":\"TD\",\"showRatio\":100},{\"iso\":\"CF\",\"showRatio\":100},{\"iso\":\"CM\",\"showRatio\":100},{\"iso\":\"CV\",\"showRatio\":100},{\"iso\":\"ST\",\"showRatio\":100},{\"iso\":\"GQ\",\"showRatio\":100},{\"iso\":\"GA\",\"showRatio\":100},{\"iso\":\"CG\",\"showRatio\":100},{\"iso\":\"CD\",\"showRatio\":100},{\"iso\":\"AO\",\"showRatio\":100},{\"iso\":\"GW\",\"showRatio\":100},{\"iso\":\"SC\",\"showRatio\":100},{\"iso\":\"SD\",\"showRatio\":100},{\"iso\":\"RW\",\"showRatio\":100},{\"iso\":\"ET\",\"showRatio\":100},{\"iso\":\"SO\",\"showRatio\":100},{\"iso\":\"DJ\",\"showRatio\":100},{\"iso\":\"KE\",\"showRatio\":100},{\"iso\":\"TZ\",\"showRatio\":100},{\"iso\":\"UG\",\"showRatio\":100},{\"iso\":\"BI\",\"showRatio\":100},{\"iso\":\"MZ\",\"showRatio\":100},{\"iso\":\"ZM\",\"showRatio\":100},{\"iso\":\"MG\",\"showRatio\":100},{\"iso\":\"YT\",\"showRatio\":100},{\"iso\":\"ZW\",\"showRatio\":100},{\"iso\":\"NA\",\"showRatio\":100},{\"iso\":\"MW\",\"showRatio\":100},{\"iso\":\"LS\",\"showRatio\":100},{\"iso\":\"BW\",\"showRatio\":100},{\"iso\":\"SZ\",\"showRatio\":100},{\"iso\":\"ER\",\"showRatio\":100},{\"iso\":\"AW\",\"showRatio\":100},{\"iso\":\"GI\",\"showRatio\":100},{\"iso\":\"LU\",\"showRatio\":100},{\"iso\":\"IE\",\"showRatio\":100},{\"iso\":\"IS\",\"showRatio\":100},{\"iso\":\"AL\",\"showRatio\":100},{\"iso\":\"MT\",\"showRatio\":100},{\"iso\":\"CY\",\"showRatio\":100},{\"iso\":\"BG\",\"showRatio\":100},{\"iso\":\"LT\",\"showRatio\":100},{\"iso\":\"MD\",\"showRatio\":100},{\"iso\":\"AM\",\"showRatio\":100},{\"iso\":\"BY\",\"showRatio\":100},{\"iso\":\"AD\",\"showRatio\":100},{\"iso\":\"MC\",\"showRatio\":100},{\"iso\":\"UA\",\"showRatio\":100},{\"iso\":\"RS\",\"showRatio\":100},{\"iso\":\"SI\",\"showRatio\":100},{\"iso\":\"BA\",\"showRatio\":100},{\"iso\":\"BZ\",\"showRatio\":100},{\"iso\":\"GT\",\"showRatio\":100},{\"iso\":\"SV\",\"showRatio\":100},{\"iso\":\"HN\",\"showRatio\":100},{\"iso\":\"NI\",\"showRatio\":100},{\"iso\":\"CR\",\"showRatio\":100},{\"iso\":\"PA\",\"showRatio\":100},{\"iso\":\"HT\",\"showRatio\":100},{\"iso\":\"BL\",\"showRatio\":100},{\"iso\":\"BO\",\"showRatio\":100},{\"iso\":\"GY\",\"showRatio\":100},{\"iso\":\"EC\",\"showRatio\":100},{\"iso\":\"GF\",\"showRatio\":100},{\"iso\":\"PY\",\"showRatio\":100},{\"iso\":\"SR\",\"showRatio\":100},{\"iso\":\"UY\",\"showRatio\":100},{\"iso\":\"AN\",\"showRatio\":100},{\"iso\":\"TL\",\"showRatio\":100},{\"iso\":\"BN\",\"showRatio\":100},{\"iso\":\"PG\",\"showRatio\":100},{\"iso\":\"PW\",\"showRatio\":100},{\"iso\":\"KI\",\"showRatio\":100},{\"iso\":\"MH\",\"showRatio\":100},{\"iso\":\"MO\",\"showRatio\":100},{\"iso\":\"KH\",\"showRatio\":100},{\"iso\":\"LA\",\"showRatio\":100},{\"iso\":\"BD\",\"showRatio\":100},{\"iso\":\"MV\",\"showRatio\":100},{\"iso\":\"LB\",\"showRatio\":100},{\"iso\":\"JO\",\"showRatio\":100},{\"iso\":\"SY\",\"showRatio\":100},{\"iso\":\"IQ\",\"showRatio\":100},{\"iso\":\"KW\",\"showRatio\":100},{\"iso\":\"SA\",\"showRatio\":100},{\"iso\":\"YE\",\"showRatio\":100},{\"iso\":\"OM\",\"showRatio\":100},{\"iso\":\"PS\",\"showRatio\":100},{\"iso\":\"AE\",\"showRatio\":100},{\"iso\":\"IL\",\"showRatio\":100},{\"iso\":\"BH\",\"showRatio\":100},{\"iso\":\"QA\",\"showRatio\":100},{\"iso\":\"BT\",\"showRatio\":100},{\"iso\":\"MN\",\"showRatio\":100},{\"iso\":\"NP\",\"showRatio\":100},{\"iso\":\"TJ\",\"showRatio\":100},{\"iso\":\"TM\",\"showRatio\":100},{\"iso\":\"AZ\",\"showRatio\":100},{\"iso\":\"GE\",\"showRatio\":100},{\"iso\":\"KG\",\"showRatio\":100},{\"iso\":\"UZ\",\"showRatio\":100},{\"iso\":\"BS\",\"showRatio\":100},{\"iso\":\"BB\",\"showRatio\":100},{\"iso\":\"AI\",\"showRatio\":100},{\"iso\":\"AG\",\"showRatio\":100},{\"iso\":\"VI\",\"showRatio\":100},{\"iso\":\"KY\",\"showRatio\":100},{\"iso\":\"BM\",\"showRatio\":100},{\"iso\":\"GD\",\"showRatio\":100},{\"iso\":\"TC\",\"showRatio\":100},{\"iso\":\"MP\",\"showRatio\":100},{\"iso\":\"GU\",\"showRatio\":100},{\"iso\":\"AS\",\"showRatio\":100},{\"iso\":\"LC\",\"showRatio\":100},{\"iso\":\"DM\",\"showRatio\":100},{\"iso\":\"VC\",\"showRatio\":100},{\"iso\":\"PR\",\"showRatio\":100},{\"iso\":\"DO\",\"showRatio\":100},{\"iso\":\"DO\",\"showRatio\":100},{\"iso\":\"TT\",\"showRatio\":100},{\"iso\":\"KN\",\"showRatio\":100},{\"iso\":\"JM\",\"showRatio\":100}]}";
    public static String[] CountryCode_ISO = {
            // 1
            "AO", "AN", "WS", "CI", "NC", "CN", "AS", "MP", "YT", "CD",
            // 2
            "KY", "BL", "SH", "PM", "RS", "TL", "TK", "TC", "KN", "PN",
            // 3
            "MF", "ME", "RW", "NU", "NF", "PW", "DM", "GB", "AU", "KI",
            // 4
            "MK", "MH", "GL", "MR", "FM", "KM", "GW", "CX", "VA", "FK",
            // 5
            "ER", "GQ", "FO", "AQ", "AW", "BT", "BA", "AF", "VG", "AL",
            // 6
            "CV", "DZ", "HR", "AD", "AI", "AG", "AR", "AM", "CC", "AT",
            // 7
            "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BM",
            // 8
            "BO", "BW", "BR", "BN", "BG", "BF", "MM", "BI", "CM", "US",
            // 9
            "CF", "TD", "CL", "CO", "CG", "CK", "CR", "CU", "CY", "CZ",
            // 10
            "DK", "DJ", "DO", "EC", "EG", "SV", "EE", "ET", "FJ", "FI",
            // 11
            "FR", "GF", "GA", "GM", "GE", "DE", "GH", "GI", "GR", "GD",
            // 12
            "GU", "GT", "GN", "GY", "HT", "HN", "HK", "HU", "IS", "IN",
            // 13
            "ID", "IR", "IQ", "IE", "IL", "IT", "JM", "JP", "JO", "KH",
            // 14
            "RU", "KE", "KR", "KW", "KG", "LA", "LV", "LB", "LS", "LR",
            // 15
            "LY", "LI", "LT", "LU", "MO", "MG", "MW", "MY", "MV", "ML",
            // 16
            "MT", "MU", "MX", "MD", "MC", "MN", "MS", "MA", "MZ", "NA",
            // 17
            "NR", "NP", "NL", "NZ", "NI", "NE", "NG", "KP", "NO", "OM",
            // 18
            "PK", "PA", "PG", "PY", "PE", "PH", "PL", "PF", "PT", "CA",
            // 19
            "QA", "RO", "KZ", "LC", "VC", "SM", "ST", "SA", "SN", "SC",
            // 20
            "SL", "SG", "SK", "SI", "SB", "SO", "ZA", "ES", "LK", "SD",
            // 21
            "SR", "SZ", "SE", "WF", "CH", "SY", "TW", "TJ", "TZ", "TH",
            // 22
            "TG", "TO", "TT", "TV", "VI", "VU", "TN", "TR", "TM", "UG",
            // 23
            "UA", "AE", "IM", "PS", "UY", "UZ", "VE", "VN", "YE", "YU",
            // 24
            "ZW", "ZR", "ZM", "SS", "PR", "PR", "DO", "DO", "XO"};
}
