package json.data;

/**
 * Created by joybar on 2017/7/27.
 */
public class ChatNewThreeAdConfig {
    /**
     * overAll : 1
     * surpriseTotalCount : 3
     * minTime : 3
     * defaultTime : 15
     * accessBottomConfig : {"overAll":1,"autoDismissTime":5}
     * accessRightDownConfig : {"overAll":1,"autoDismissTime":5,"chatSessionFreeTime":8}
     */

    private int overAll ;
    private int surpriseTotalCount;
    private int minTime;
    private int defaultTime;
    private AccessBottomConfigBean accessBottomConfig;
    private AccessRightDownConfigBean accessRightDownConfig;

    public int getOverAll() {
        return overAll;
    }

    public void setOverAll(int overAll) {
        this.overAll = overAll;
    }

    public int getSurpriseTotalCount() {
        return surpriseTotalCount;
    }

    public void setSurpriseTotalCount(int surpriseTotalCount) {
        this.surpriseTotalCount = surpriseTotalCount;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getDefaultTime() {
        return defaultTime;
    }

    public void setDefaultTime(int defaultTime) {
        this.defaultTime = defaultTime;
    }

    public AccessBottomConfigBean getAccessBottomConfig() {
        return accessBottomConfig;
    }

    public void setAccessBottomConfig(AccessBottomConfigBean accessBottomConfig) {
        this.accessBottomConfig = accessBottomConfig;
    }

    public AccessRightDownConfigBean getAccessRightDownConfig() {
        return accessRightDownConfig;
    }

    public void setAccessRightDownConfig(AccessRightDownConfigBean accessRightDownConfig) {
        this.accessRightDownConfig = accessRightDownConfig;
    }

    @Override
    public String toString() {
        return "ChatNewThreeAdConfig{" +
                "overAll=" + overAll +
                ", surpriseTotalCount=" + surpriseTotalCount +
                ", minTime=" + minTime +
                ", defaultTime=" + defaultTime +
                ", accessBottomConfig=" + accessBottomConfig.toString() +
                ", accessRightDownConfig=" + accessRightDownConfig.toString() +
                '}';
    }

    public static class AccessBottomConfigBean {
        /**
         * overAll : 1
         * autoDismissTime : 5
         */

        private int overAll;
        private int autoDismissTime;

        public int getOverAll() {
            return overAll;
        }

        public void setOverAll(int overAll) {
            this.overAll = overAll;
        }

        public int getAutoDismissTime() {
            return autoDismissTime;
        }

        public void setAutoDismissTime(int autoDismissTime) {
            this.autoDismissTime = autoDismissTime;
        }

        @Override
        public String toString() {
            return "AccessBottomConfigBean{" +
                    "overAll=" + overAll +
                    ", autoDismissTime=" + autoDismissTime +
                    '}';
        }
    }

    public static class AccessRightDownConfigBean {
        /**
         * overAll : 1
         * autoDismissTime : 5
         * chatSessionFreeTime : 8
         */

        private int overAll;
        private int autoDismissTime;
        private int chatSessionFreeTime;

        public int getOverAll() {
            return overAll;
        }

        public void setOverAll(int overAll) {
            this.overAll = overAll;
        }

        public int getAutoDismissTime() {
            return autoDismissTime;
        }

        public void setAutoDismissTime(int autoDismissTime) {
            this.autoDismissTime = autoDismissTime;
        }

        public int getChatSessionFreeTime() {
            return chatSessionFreeTime;
        }

        public void setChatSessionFreeTime(int chatSessionFreeTime) {
            this.chatSessionFreeTime = chatSessionFreeTime;
        }

        @Override
        public String toString() {
            return "AccessRightDownConfigBean{" +
                    "overAll=" + overAll +
                    ", autoDismissTime=" + autoDismissTime +
                    ", chatSessionFreeTime=" + chatSessionFreeTime +
                    '}';
        }
    }
}
