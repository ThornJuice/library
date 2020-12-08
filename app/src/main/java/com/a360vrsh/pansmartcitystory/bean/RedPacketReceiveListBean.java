package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/24
 * @description:
 */
public class RedPacketReceiveListBean {

    /**
     * data : [{"id":1122,"avatar":"https://ores.360vrsh.com/mob/avatar.png","name":"YJ_3efadb44","money":"0.98","received_at":"2020-06-24 15:58:36"}]
     * links : {"first":"http://redpack.inner.test.360vrsh.com/api/redpack/26/receive?page=1","last":"http://redpack.inner.test.360vrsh.com/api/redpack/26/receive?page=1","prev":null,"next":null}
     * meta : {"current_page":1,"from":1,"last_page":1,"path":"http://redpack.inner.test.360vrsh.com/api/redpack/26/receive","per_page":15,"to":1,"total":1}
     * errcode : 0
     * errmsg : 成功
     */

    private int errcode;
    private String errmsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }



    public static class DataBean implements Serializable {
        /**
         * id : 1122
         * avatar : https://ores.360vrsh.com/mob/avatar.png
         * name : YJ_3efadb44
         * money : 0.98
         * received_at : 2020-06-24 15:58:36
         */

        private String id;
        private String avatar;
        private String name;
        private String money;
        private String received_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getReceived_at() {
            return received_at;
        }

        public void setReceived_at(String received_at) {
            this.received_at = received_at;
        }
    }
}
