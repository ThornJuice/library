package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/18
 * @description:
 */
public class RefundDetailBean {

    /**
     * data : {"id":61,"order_type":2,"status":-2,"refund_status_title":"取消退款","refund_sn":"2020071418374334426","pay_money":"2200.00","money":"2200.00","pay_type":3,"refund_account":"原支付账户","user_name":"","user_phone":"","desc":"","refund_type":"","reason":"","images":[],"goods_num":10,"created_at":"2020-07-14 18:37:43","goods":[{"goods_id":21209,"goods_title":"郑州方特欢乐世界","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-06-12/eCbIrn1FiLf2GG3vuExr91LAbM6QuD1eBjBMUqnm.jpeg","is_spec":0,"ticket_type":1,"ticket_name":"成人票--方特","ticket_affect_date":"2020-07-14","price":"220.00","ticket_verification":0,"goods_num":10}],"info":[{"tourist_name":"陆游","tourist_idcard":"412827199007131517","tourist_phone":"19903966606"}],"store":{"store_id":14198,"store_name":"营销活动店铺","store_type":3,"store_is_pano":1,"template":4}}
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
         * id : 61
         * order_type : 2
         * status : -2
         * refund_status_title : 取消退款
         * refund_sn : 2020071418374334426
         * pay_money : 2200.00
         * money : 2200.00
         * pay_type : 3
         * refund_account : 原支付账户
         * user_name :
         * user_phone :
         * desc :
         * refund_type :
         * reason :
         * images : []
         * goods_num : 10
         * created_at : 2020-07-14 18:37:43
         * goods : [{"goods_id":21209,"goods_title":"郑州方特欢乐世界","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-06-12/eCbIrn1FiLf2GG3vuExr91LAbM6QuD1eBjBMUqnm.jpeg","is_spec":0,"ticket_type":1,"ticket_name":"成人票--方特","ticket_affect_date":"2020-07-14","price":"220.00","ticket_verification":0,"goods_num":10}]
         * info : [{"tourist_name":"陆游","tourist_idcard":"412827199007131517","tourist_phone":"19903966606"}]
         * store : {"store_id":14198,"store_name":"营销活动店铺","store_type":3,"store_is_pano":1,"template":4}
         */

        private String id;
        private String order_type;
        private String status;
        private String refund_status_title;
        private String refund_sn;
        private String pay_money;
        private String order_price;
        private String money;
        private String pay_type;
        private String refund_account;
        private String user_name;
        private String user_phone;
        private String desc;
        private String refund_type;
        private String reason;
        private String goods_num;
        private String created_at;
        private String updated_at;
        private StoreBean store;
        private List<String> images;
        private List<GoodsBean> goods;
        private List<InfoBean> info;

        public String getOrder_price() {
            return order_price;
        }

        public void setOrder_price(String order_price) {
            this.order_price = order_price;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getRefund_status_title() {
            return refund_status_title;
        }

        public void setRefund_status_title(String refund_status_title) {
            this.refund_status_title = refund_status_title;
        }

        public String getRefund_sn() {
            return refund_sn;
        }

        public void setRefund_sn(String refund_sn) {
            this.refund_sn = refund_sn;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getRefund_account() {
            return refund_account;
        }

        public void setRefund_account(String refund_account) {
            this.refund_account = refund_account;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getRefund_type() {
            return refund_type;
        }

        public void setRefund_type(String refund_type) {
            this.refund_type = refund_type;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class StoreBean implements Serializable {
            /**
             * store_id : 14198
             * store_name : 营销活动店铺
             * store_type : 3
             * store_is_pano : 1
             * template : 4
             */

            private String store_id;
            private String store_name;
            private String store_type;
            private String store_is_pano;
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

            public String getStore_type() {
                return store_type;
            }

            public void setStore_type(String store_type) {
                this.store_type = store_type;
            }

            public String getStore_is_pano() {
                return store_is_pano;
            }

            public void setStore_is_pano(String store_is_pano) {
                this.store_is_pano = store_is_pano;
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
             * goods_id : 21209
             * goods_title : 郑州方特欢乐世界
             * goods_cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-06-12/eCbIrn1FiLf2GG3vuExr91LAbM6QuD1eBjBMUqnm.jpeg
             * is_spec : 0
             * ticket_type : 1
             * ticket_name : 成人票--方特
             * ticket_affect_date : 2020-07-14
             * price : 220.00
             * ticket_verification : 0
             * goods_num : 10
             */

            private String goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String is_spec;
            private String ticket_type;
            private String ticket_name;
            private String ticket_affect_date;
            private String price;
            private String ticket_verification;
            private String goods_num;

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

            public String getTicket_type() {
                return ticket_type;
            }

            public void setTicket_type(String ticket_type) {
                this.ticket_type = ticket_type;
            }

            public String getTicket_name() {
                return ticket_name;
            }

            public void setTicket_name(String ticket_name) {
                this.ticket_name = ticket_name;
            }

            public String getTicket_affect_date() {
                return ticket_affect_date;
            }

            public void setTicket_affect_date(String ticket_affect_date) {
                this.ticket_affect_date = ticket_affect_date;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTicket_verification() {
                return ticket_verification;
            }

            public void setTicket_verification(String ticket_verification) {
                this.ticket_verification = ticket_verification;
            }

            public String getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(String goods_num) {
                this.goods_num = goods_num;
            }
        }

        public static class InfoBean implements Serializable {
            /**
             * tourist_name : 陆游
             * tourist_idcard : 412827199007131517
             * tourist_phone : 19903966606
             */

            private String tourist_name;
            private String tourist_idcard;
            private String tourist_phone;

            public String getTourist_name() {
                return tourist_name;
            }

            public void setTourist_name(String tourist_name) {
                this.tourist_name = tourist_name;
            }

            public String getTourist_idcard() {
                return tourist_idcard;
            }

            public void setTourist_idcard(String tourist_idcard) {
                this.tourist_idcard = tourist_idcard;
            }

            public String getTourist_phone() {
                return tourist_phone;
            }

            public void setTourist_phone(String tourist_phone) {
                this.tourist_phone = tourist_phone;
            }
        }

    }
}
