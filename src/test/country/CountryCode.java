package test.country;

import java.util.List;

/**
 * Created by joybar on 2018/8/9.
 */
public class CountryCode {


    private int isPub;
    private int isOn;
    private List<CcListBean> ccList;

    public int getIsPub() {
        return isPub;
    }

    public void setIsPub(int isPub) {
        this.isPub = isPub;
    }

    public int getIsOn() {
        return isOn;
    }

    public void setIsOn(int isOn) {
        this.isOn = isOn;
    }

    public List<CcListBean> getCcList() {
        return ccList;
    }

    public void setCcList(List<CcListBean> ccList) {
        this.ccList = ccList;
    }

    public static class CcListBean {
        /**
         * iso : CN
         * showRatio : 0
         */

        private String iso;
        private int showRatio;

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public int getShowRatio() {
            return showRatio;
        }

        public void setShowRatio(int showRatio) {
            this.showRatio = showRatio;
        }
    }
}
