package com.ccsia.demo.model;


    public enum Err {
        NULL_APPKEY_OR_SRCRET("10001", "appkey或secret不能为空"),
        NOT_MATCH_APPKEY_SECRET("10002", "没有找到appkey或secret"),
        EXPIRED_TOKEN("10003", "token过期"),
        ;
        private String errCode;

        private String errMsg;

        Err(String errCode, String errMsg) {
            this.errCode = errCode;
            this.errMsg = errMsg;
        }

        public String getErrCode() {
            return errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }
    }
