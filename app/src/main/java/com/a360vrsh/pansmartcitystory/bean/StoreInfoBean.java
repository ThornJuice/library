package com.a360vrsh.pansmartcitystory.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/4
 * @description: 店铺信息  status店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝
 */
public class StoreInfoBean {

    /**
     * data : {"id":14211,"type":"toruism","class":[{"id":189,"pid":0,"name":"游乐园"}],"name":"橘子游乐园","logo":{"key":"b8c73aee6f7eb214021b5dd7bbeaef12","name":"橘子游乐园","url":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png","path":"store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png"},"province_id":16,"city_id":240,"region_id":2664,"address":"河南省郑州市金水区花园路1号","lng":"113.6887817633","lat":"34.7927605595","contact":"19903966606","describe":"我是简介","content":"<p>橘子游乐园店铺详情描述<\/p>","certification":[],"status":2,"is_close":0,"created_at":"2020-07-17 10:35:26","views":1973,"industry":{"tag":["我是标签","标签2"],"per_capita":"666.00","open_time":"08:30","close_time":"11:00","is_open":0,"is_rest":0,"is_verify":3}}
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
        /**
         * id : 14211
         * type : toruism
         * class : [{"id":189,"pid":0,"name":"游乐园"}]
         * name : 橘子游乐园
         * logo : {"key":"b8c73aee6f7eb214021b5dd7bbeaef12","name":"橘子游乐园","url":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png","path":"store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png"}
         * province_id : 16
         * city_id : 240
         * region_id : 2664
         * address : 河南省郑州市金水区花园路1号
         * lng : 113.6887817633
         * lat : 34.7927605595
         * contact : 19903966606
         * describe : 我是简介
         * content : <p>橘子游乐园店铺详情描述</p>
         * certification : []
         * status : 2  //店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝
         * is_close : 0
         * created_at : 2020-07-17 10:35:26
         * views : 1973
         * industry : {"tag":["我是标签","标签2"],"per_capita":"666.00","open_time":"08:30","close_time":"11:00","is_open":0,"is_rest":0,"is_verify":3}
         */

        private String id;
        private String type;
        private String name;
        private LogoBean logo;
        private String province_id;
        private String city_id;
        private String region_id;
        private String address;
        private String lng;
        private String lat;
        private String contact;
        private String describe;
        private String content;
        private String status;
        private String is_close;
        private String created_at;
        private String views;
        private IndustryBean industry;
        @SerializedName("class")
        private List<ClassBean> classX;
        private List<?> certification;
        private String  evaluation_average;


        public String getEvaluation_average() {
            return evaluation_average;
        }

        public void setEvaluation_average(String evaluation_average) {
            this.evaluation_average = evaluation_average;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LogoBean getLogo() {
            return logo;
        }

        public void setLogo(LogoBean logo) {
            this.logo = logo;
        }


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_close() {
            return is_close;
        }

        public void setIs_close(String is_close) {
            this.is_close = is_close;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public IndustryBean getIndustry() {
            return industry;
        }

        public void setIndustry(IndustryBean industry) {
            this.industry = industry;
        }

        public List<ClassBean> getClassX() {
            return classX;
        }

        public void setClassX(List<ClassBean> classX) {
            this.classX = classX;
        }

        public List<?> getCertification() {
            return certification;
        }

        public void setCertification(List<?> certification) {
            this.certification = certification;
        }

        public static class LogoBean implements Serializable {
            /**
             * key : b8c73aee6f7eb214021b5dd7bbeaef12
             * name : 橘子游乐园
             * url : http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png
             * path : store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png
             */

            private String key;
            private String name;
            private String url;
            private String path;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }

        public static class IndustryBean implements Serializable {
            /**
             * tag : ["我是标签","标签2"]
             * per_capita : 666.00
             * open_time : 08:30
             * close_time : 11:00
             * is_open : 0
             * is_rest : 0
             * is_verify : 3
             */
            private String delivery_cost;
            private String per_capita;
            private String open_time;
            private String close_time;
            private String is_open;
            private String is_rest;
            private String is_verify;
            private String is_receipt;//自动接单
            private String is_self_get;//支持自取
            private String is_delivery;//支持配送
            private List<String> tag;

            public String getIs_delivery() {
                return is_delivery;
            }

            public void setIs_delivery(String is_delivery) {
                this.is_delivery = is_delivery;
            }

            public String getDelivery_cost() {
                return delivery_cost;
            }

            public void setDelivery_cost(String delivery_cost) {
                this.delivery_cost = delivery_cost;
            }

            public String getPer_capita() {
                return per_capita;
            }

            public void setPer_capita(String per_capita) {
                this.per_capita = per_capita;
            }

            public String getOpen_time() {
                return open_time;
            }

            public void setOpen_time(String open_time) {
                this.open_time = open_time;
            }

            public String getClose_time() {
                return close_time;
            }

            public void setClose_time(String close_time) {
                this.close_time = close_time;
            }

            public String getIs_open() {
                return is_open;
            }

            public void setIs_open(String is_open) {
                this.is_open = is_open;
            }

            public String getIs_rest() {
                return is_rest;
            }

            public void setIs_rest(String is_rest) {
                this.is_rest = is_rest;
            }

            public String getIs_verify() {
                return is_verify;
            }

            public void setIs_verify(String is_verify) {
                this.is_verify = is_verify;
            }

            public String getIs_receipt() {
                return is_receipt;
            }

            public void setIs_receipt(String is_receipt) {
                this.is_receipt = is_receipt;
            }

            public String getIs_self_get() {
                return is_self_get;
            }

            public void setIs_self_get(String is_self_get) {
                this.is_self_get = is_self_get;
            }

            public List<String> getTag() {
                return tag;
            }

            public void setTag(List<String> tag) {
                this.tag = tag;
            }
        }

        public static class ClassBean implements Serializable {
            /**
             * id : 189
             * pid : 0
             * name : 游乐园
             */

            private String id;
            private String pid;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
