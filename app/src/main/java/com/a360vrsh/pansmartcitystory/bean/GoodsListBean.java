package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/9
 * @description:
 */
public class GoodsListBean {

    /**
     * data : [{"id":21255,"title":"海洋馆1号","class_name":"海洋馆","cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-24/krL5NNZ8ni0Zzh1NazTZ08LpilIuXaS3ZE7FGsbb.jpeg","price":"99.00","price_max":"99.00","sales_total":2,"status_audit":4,"status_shelf":1,"is_three_dimension":0,"created_at":"2020-07-17 19:42:01","updated_at":"2020-09-27 18:26:07","is_lvmama":0},{"id":21254,"title":"游乐园1号","class_name":"游乐园","cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png","price":"66.00","price_max":"333.00","sales_total":4,"status_audit":2,"status_shelf":1,"is_three_dimension":0,"created_at":"2020-07-17 10:57:16","updated_at":"2020-09-16 11:00:04","is_lvmama":0}]
     * links : {"first":"http://goods.inner.test.360vrsh.com/api/manage/goods?page=1","last":"http://goods.inner.test.360vrsh.com/api/manage/goods?page=1","prev":null,"next":null}
     * meta : {"current_page":1,"from":1,"last_page":1,"path":"http://goods.inner.test.360vrsh.com/api/manage/goods","per_page":10,"to":2,"total":2}
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
         * id : 21255
         * title : 海洋馆1号
         * class_name : 海洋馆
         * cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-07-24/krL5NNZ8ni0Zzh1NazTZ08LpilIuXaS3ZE7FGsbb.jpeg
         * price : 99.00
         * price_max : 99.00
         * sales_total : 2
         * status_audit : 4
         * status_shelf : 1
         * is_three_dimension : 0
         * created_at : 2020-07-17 19:42:01
         * updated_at : 2020-09-27 18:26:07
         * is_lvmama : 0
         */

        private String id;
        private String title;
        private String class_name;
        private String cover_image;
        private String price;
        private String price_max;
        private String sales_total;
        private String status_audit;
        private String status_shelf;
        private String is_three_dimension;
        private String created_at;
        private String updated_at;
        private String is_lvmama;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice_max() {
            return price_max;
        }

        public void setPrice_max(String price_max) {
            this.price_max = price_max;
        }

        public String getSales_total() {
            return sales_total;
        }

        public void setSales_total(String sales_total) {
            this.sales_total = sales_total;
        }

        public String getStatus_audit() {
            return status_audit;
        }

        public void setStatus_audit(String status_audit) {
            this.status_audit = status_audit;
        }

        public String getStatus_shelf() {
            return status_shelf;
        }

        public void setStatus_shelf(String status_shelf) {
            this.status_shelf = status_shelf;
        }

        public String getIs_three_dimension() {
            return is_three_dimension;
        }

        public void setIs_three_dimension(String is_three_dimension) {
            this.is_three_dimension = is_three_dimension;
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

        public String getIs_lvmama() {
            return is_lvmama;
        }

        public void setIs_lvmama(String is_lvmama) {
            this.is_lvmama = is_lvmama;
        }
    }
}
