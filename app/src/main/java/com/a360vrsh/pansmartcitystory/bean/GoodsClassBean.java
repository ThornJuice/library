package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/9
 * @description:
 */
public class GoodsClassBean {


    /**
     * data : [{"id":4206,"name":"海洋馆","weight":3,"created_at":"2020-07-17 10:54:33","updated_at":"2020-07-17 10:55:16"},{"id":4207,"name":"游乐园","weight":2,"created_at":"2020-07-17 10:54:56","updated_at":"2020-07-17 10:54:56"},{"id":4205,"name":"景区","weight":1,"created_at":"2020-07-17 10:54:26","updated_at":"2020-07-17 10:55:02"}]
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
         * id : 4206
         * name : 海洋馆
         * weight : 3
         * created_at : 2020-07-17 10:54:33
         * updated_at : 2020-07-17 10:55:16
         */

        private String id;
        private String name;
        private String weight;
        private String created_at;
        private String updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
