package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/19
 * @description:
 */
public class FoodOrderDetailBean {

    /**
     * data : {"id":758,"sn":"20200909164301101048","order_type":1,"status":9,"status_title":"待发货","refund_status":0,"refund_status_title":"正常","pay_type":3,"pay_sn":"20200909164303277572","payd_at":"2020-09-09 16:44:03","order_price":"40.10","pay_price":"40.10","commission":"1.00","fee":"0.00","actually_arrived":"39.10","goods_num":12,"remark":null,"order_code":"68604964","created_at":"2020-09-09 16:43:01","goods":[{"goods_id":2,"goods_title":"布丁奶茶","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/aKDFcZMgCj6TSpUBG1ypA1ZKRehvVOlDk3U0AQON.jpeg","is_spec":1,"spec_label":"少冰,正常","price":"10.00","num":1},{"goods_id":3,"goods_title":"测试商品--双拼巧克力奶茶附图规划局规划局规划兔兔兔兔一题题题","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/BN2E1zhehPcrLhYOE1awevRWbJIgkTvDAdz1prmE.jpeg","is_spec":1,"spec_label":"多冰","price":"0.01","num":10},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg","is_spec":1,"spec_label":"中份,微辣","price":"30.00","num":1}],"info":{"distribution_mode":1,"name":"你呢","phone":"13666999999","address_detail":"河南省郑州市管城回族区中兴南路你你你","lng":"113.78389537492397","lat":"34.75119157507919","packing_cost":"0.00","delivery_cost":"0.00"},"store":{"store_id":11591,"store_name":"蜜雪冰城","store_phone":"18811140979","store_type":1,"address":"河南省郑州市管城回族区商城路236号","lng":"113.6816043023","lat":"34.7598510399","template":3}}
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
         * id : 758
         * sn : 20200909164301101048
         * order_type : 1
         * status : 9
         * status_title : 待发货
         * refund_status : 0
         * refund_status_title : 正常
         * pay_type : 3
         * pay_sn : 20200909164303277572
         * payd_at : 2020-09-09 16:44:03
         * order_price : 40.10
         * pay_price : 40.10
         * commission : 1.00
         * fee : 0.00
         * actually_arrived : 39.10
         * goods_num : 12
         * remark : null
         * order_code : 68604964
         * created_at : 2020-09-09 16:43:01
         * goods : [{"goods_id":2,"goods_title":"布丁奶茶","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/aKDFcZMgCj6TSpUBG1ypA1ZKRehvVOlDk3U0AQON.jpeg","is_spec":1,"spec_label":"少冰,正常","price":"10.00","num":1},{"goods_id":3,"goods_title":"测试商品--双拼巧克力奶茶附图规划局规划局规划兔兔兔兔一题题题","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/BN2E1zhehPcrLhYOE1awevRWbJIgkTvDAdz1prmE.jpeg","is_spec":1,"spec_label":"多冰","price":"0.01","num":10},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg","is_spec":1,"spec_label":"中份,微辣","price":"30.00","num":1}]
         * info : {"distribution_mode":1,"name":"你呢","phone":"13666999999","address_detail":"河南省郑州市管城回族区中兴南路你你你","lng":"113.78389537492397","lat":"34.75119157507919","packing_cost":"0.00","delivery_cost":"0.00"}
         * store : {"store_id":11591,"store_name":"蜜雪冰城","store_phone":"18811140979","store_type":1,"address":"河南省郑州市管城回族区商城路236号","lng":"113.6816043023","lat":"34.7598510399","template":3}
         */

        private String id;
        private String sn;
        private String order_type;
        private String status;
        private String status_title;
        private String refund_status;
        private String refund_status_title;
        private String pay_type;
        private String pay_sn;
        private String payd_at;
        private String order_price;
        private String pay_price;
        private String commission;
        private String fee;
        private String actually_arrived;
        private String goods_num;
        private String remark;
        private String order_code;
        private String created_at;
        private InfoBean info;
        private StoreBean store;
        private List<GoodsBean> goods;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus_title() {
            return status_title;
        }

        public void setStatus_title(String status_title) {
            this.status_title = status_title;
        }

        public String getRefund_status() {
            return refund_status;
        }

        public void setRefund_status(String refund_status) {
            this.refund_status = refund_status;
        }

        public String getRefund_status_title() {
            return refund_status_title;
        }

        public void setRefund_status_title(String refund_status_title) {
            this.refund_status_title = refund_status_title;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

        public String getPayd_at() {
            return payd_at;
        }

        public void setPayd_at(String payd_at) {
            this.payd_at = payd_at;
        }

        public String getOrder_price() {
            return order_price;
        }

        public void setOrder_price(String order_price) {
            this.order_price = order_price;
        }

        public String getPay_price() {
            return pay_price;
        }

        public void setPay_price(String pay_price) {
            this.pay_price = pay_price;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getActually_arrived() {
            return actually_arrived;
        }

        public void setActually_arrived(String actually_arrived) {
            this.actually_arrived = actually_arrived;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getOrder_code() {
            return order_code;
        }

        public void setOrder_code(String order_code) {
            this.order_code = order_code;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class InfoBean implements Serializable {
            /**
             * distribution_mode : 1
             * name : 你呢
             * phone : 13666999999
             * address_detail : 河南省郑州市管城回族区中兴南路你你你
             * lng : 113.78389537492397
             * lat : 34.75119157507919
             * packing_cost : 0.00
             * delivery_cost : 0.00
             */

            private String distribution_mode;
            private String name;
            private String phone;
            private String address_detail;
            private String lng;
            private String lat;
            private String packing_cost;
            private String delivery_cost;

            public String getDistribution_mode() {
                return distribution_mode;
            }

            public void setDistribution_mode(String distribution_mode) {
                this.distribution_mode = distribution_mode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress_detail() {
                return address_detail;
            }

            public void setAddress_detail(String address_detail) {
                this.address_detail = address_detail;
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

            public String getPacking_cost() {
                return packing_cost;
            }

            public void setPacking_cost(String packing_cost) {
                this.packing_cost = packing_cost;
            }

            public String getDelivery_cost() {
                return delivery_cost;
            }

            public void setDelivery_cost(String delivery_cost) {
                this.delivery_cost = delivery_cost;
            }
        }

        public static class StoreBean implements Serializable {
            /**
             * store_id : 11591
             * store_name : 蜜雪冰城
             * store_phone : 18811140979
             * store_type : 1
             * address : 河南省郑州市管城回族区商城路236号
             * lng : 113.6816043023
             * lat : 34.7598510399
             * template : 3
             */

            private String store_id;
            private String store_name;
            private String store_phone;
            private String store_type;
            private String address;
            private String lng;
            private String lat;
            private String template;

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getStore_phone() {
                return store_phone;
            }

            public void setStore_phone(String store_phone) {
                this.store_phone = store_phone;
            }

            public String getStore_type() {
                return store_type;
            }

            public void setStore_type(String store_type) {
                this.store_type = store_type;
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

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }
        }

        public static class GoodsBean implements Serializable {
            /**
             * goods_id : 2
             * goods_title : 布丁奶茶
             * goods_cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/aKDFcZMgCj6TSpUBG1ypA1ZKRehvVOlDk3U0AQON.jpeg
             * is_spec : 1
             * spec_label : 少冰,正常
             * price : 10.00
             * num : 1
             */

            private String goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String is_spec;
            private String spec_label;
            private String price;
            private String num;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_title() {
                return goods_title;
            }

            public void setGoods_title(String goods_title) {
                this.goods_title = goods_title;
            }

            public String getGoods_cover_image() {
                return goods_cover_image;
            }

            public void setGoods_cover_image(String goods_cover_image) {
                this.goods_cover_image = goods_cover_image;
            }

            public String getIs_spec() {
                return is_spec;
            }

            public void setIs_spec(String is_spec) {
                this.is_spec = is_spec;
            }

            public String getSpec_label() {
                return spec_label;
            }

            public void setSpec_label(String spec_label) {
                this.spec_label = spec_label;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }
        }
    }
}
