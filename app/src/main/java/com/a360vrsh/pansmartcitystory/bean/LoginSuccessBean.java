package com.a360vrsh.pansmartcitystory.bean;

/**
 * @author: wxj
 * @date: 2020/9/21
 * @description:
 */
public class LoginSuccessBean {

    /**
     * data : {"ticket":"bBshi7IFuASs2ZYYG520Loc77lXmwcwW"}
     * errcode : 0
     * errmsg : success
     */

    private DataBean data;
    private int errcode;
    private String errmsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static class DataBean {
        /**
         * ticket : bBshi7IFuASs2ZYYG520Loc77lXmwcwW
         */

        private String ticket;

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }
    }
}
