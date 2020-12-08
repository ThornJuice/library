package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;

/**
 * @author: wxj
 * @date: 2020/11/4
 * @description:
 */
public class StorePanoBean {

    /**
     * data : {"id":11933,"sname":null,"currentAuthority":["admin","user"],"store_id":14211,"status":2,"store_type":3,"is_pano":1,"pano":{"outlink":false,"local":true}}
     * errcode : 0
     * errmsg : 成功
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

    public static class DataBean implements Serializable {


        private String type;
        private String pano_id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


        public String getPano_id() {
            return pano_id;
        }

        public void setPano_id(String pano_id) {
            this.pano_id = pano_id;
        }
    }
}
