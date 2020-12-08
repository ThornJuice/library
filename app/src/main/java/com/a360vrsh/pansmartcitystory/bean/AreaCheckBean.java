package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;

/**
 * @author: wxj
 * @date: 2020/11/6
 * @description:
 */
public class AreaCheckBean {


    /**
     * traces : {"file":"/data/AxBuild/build/nqjCmmCenter/nqjCmmCenter_45_v1.0.7/app/Http/Controllers/AreaController.php","line":86,"function":"tne","args":["SUCCESS",{"address":"河南省 - 郑州市 - 金水区"}]}
     * errcode : 0
     * errmsg : 成功
     * data : {"address":"河南省 - 郑州市 - 金水区"}
     */

    private int errcode;
    private String errmsg;
    private DataBean data;


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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean implements Serializable {
        /**
         * address : 河南省 - 郑州市 - 金水区
         */

        private String address;
        private String province_id;
        private String city_id;
        private String region_id;

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getRegion_id() {
            return region_id;
        }

        public void setRegion_id(String region_id) {
            this.region_id = region_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
