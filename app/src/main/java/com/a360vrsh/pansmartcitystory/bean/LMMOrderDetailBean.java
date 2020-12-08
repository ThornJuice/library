package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/17
 * @description:
 */
public class LMMOrderDetailBean {

    /**
     * data : {"id":685,"sn":"20200821101037276965","order_type":3,"status":2,"status_title":"待确认","refund_status":0,"refund_status_title":"正常","pay_type":3,"pay_sn":"20200821101042803512","payd_at":"2020-08-21 10:13:02","order_price":"5.00","pay_price":"5.00","commission":"0.00","fee":"0.00","actually_arrived":"5.00","goods_num":1,"remark":"","order_code":"87999152","created_at":"2020-08-21 10:10:37","goods":[{"lvmama_product_id":182141,"lvmama_goods_id":1743219,"goods_title":"杭州余杭农夫乐园","goods_cover_image":"http://pic.lvmama.com//uploads/pc/place2/2015-04-15/f2700ebf-ac33-4fbf-a63e-05574002fc26.jpg","ticket_type":5,"ticket_type_name":"成人票","ticket_name":"成人票","ticket_affect_date":"2020-08-21","price":"5.00","notice_way":"凭收到的【聚赢智业】的取票单号取票入园","notice_visit_address":"","notice_get_ticket_time":"9:00～15:00","notice_get_ticket_place":"农夫乐园景区售票处","notice_enter_limit_flag":1,"notice_enter_limit_time":"00:00:00","importent_point":"成人票的重要提示:本商品支持30天内可退。预订付款后未使用，可在\u201c我的订单\u201d中申请退款，且不收取任何手续费。\n通关时间限制：下单后 01小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"本商品支持30天内可退。预订付款后未使用，可在\u201c我的订单\u201d中申请退款，且不收取任何手续费。"}],"info":{"tourist_id":159,"tourist_name":"KKK","tourist_idcard":"41132319910706053X","tourist_phone":"13666666666","discount":"0.00","deduction":"0.00","refund":"5.00"},"store":{"store_id":14097,"store_name":"郑州方特欢乐世界","store_phone":"400-611-1360","store_type":3,"address":"新兴家园","lng":"113.0296321292","lat":"34.7559067165","template":0}}
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
         * id : 685
         * sn : 20200821101037276965
         * order_type : 3
         * status : 2
         * status_title : 待确认
         * refund_status : 0
         * refund_status_title : 正常
         * pay_type : 3
         * pay_sn : 20200821101042803512
         * payd_at : 2020-08-21 10:13:02
         * order_price : 5.00
         * pay_price : 5.00
         * commission : 0.00
         * fee : 0.00
         * actually_arrived : 5.00
         * goods_num : 1
         * remark :
         * order_code : 87999152
         * created_at : 2020-08-21 10:10:37
         * goods : [{"lvmama_product_id":182141,"lvmama_goods_id":1743219,"goods_title":"杭州余杭农夫乐园","goods_cover_image":"http://pic.lvmama.com//uploads/pc/place2/2015-04-15/f2700ebf-ac33-4fbf-a63e-05574002fc26.jpg","ticket_type":5,"ticket_type_name":"成人票","ticket_name":"成人票","ticket_affect_date":"2020-08-21","price":"5.00","notice_way":"凭收到的【聚赢智业】的取票单号取票入园","notice_visit_address":"","notice_get_ticket_time":"9:00～15:00","notice_get_ticket_place":"农夫乐园景区售票处","notice_enter_limit_flag":1,"notice_enter_limit_time":"00:00:00","importent_point":"成人票的重要提示:本商品支持30天内可退。预订付款后未使用，可在\u201c我的订单\u201d中申请退款，且不收取任何手续费。\n通关时间限制：下单后 01小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"本商品支持30天内可退。预订付款后未使用，可在\u201c我的订单\u201d中申请退款，且不收取任何手续费。"}]
         * info : {"tourist_id":159,"tourist_name":"KKK","tourist_idcard":"41132319910706053X","tourist_phone":"13666666666","discount":"0.00","deduction":"0.00","refund":"5.00"}
         * store : {"store_id":14097,"store_name":"郑州方特欢乐世界","store_phone":"400-611-1360","store_type":3,"address":"新兴家园","lng":"113.0296321292","lat":"34.7559067165","template":0}
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
             * tourist_id : 159
             * tourist_name : KKK
             * tourist_idcard : 41132319910706053X
             * tourist_phone : 13666666666
             * discount : 0.00
             * deduction : 0.00
             * refund : 5.00
             */

            private String tourist_id;
            private String tourist_name;
            private String tourist_idcard;
            private String tourist_phone;
            private String discount;
            private String deduction;
            private String refund;

            public String getTourist_id() {
                return tourist_id;
            }

            public void setTourist_id(String tourist_id) {
                this.tourist_id = tourist_id;
            }

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

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getDeduction() {
                return deduction;
            }

            public void setDeduction(String deduction) {
                this.deduction = deduction;
            }

            public String getRefund() {
                return refund;
            }

            public void setRefund(String refund) {
                this.refund = refund;
            }
        }

        public static class StoreBean implements Serializable {
            /**
             * store_id : 14097
             * store_name : 郑州方特欢乐世界
             * store_phone : 400-611-1360
             * store_type : 3
             * address : 新兴家园
             * lng : 113.0296321292
             * lat : 34.7559067165
             * template : 0
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
             * lvmama_product_id : 182141
             * lvmama_goods_id : 1743219
             * goods_title : 杭州余杭农夫乐园
             * goods_cover_image : http://pic.lvmama.com//uploads/pc/place2/2015-04-15/f2700ebf-ac33-4fbf-a63e-05574002fc26.jpg
             * ticket_type : 5
             * ticket_type_name : 成人票
             * ticket_name : 成人票
             * ticket_affect_date : 2020-08-21
             * price : 5.00
             * notice_way : 凭收到的【聚赢智业】的取票单号取票入园
             * notice_visit_address :
             * notice_get_ticket_time : 9:00～15:00
             * notice_get_ticket_place : 农夫乐园景区售票处
             * notice_enter_limit_flag : 1
             * notice_enter_limit_time : 00:00:00
             * importent_point : 成人票的重要提示:本商品支持30天内可退。预订付款后未使用，可在“我的订单”中申请退款，且不收取任何手续费。
             * 通关时间限制：下单后 01小时00分钟00秒 后可通关。
             * importent_notice :
             * refund_rule_notice : 本商品支持30天内可退。预订付款后未使用，可在“我的订单”中申请退款，且不收取任何手续费。
             */

            private String lvmama_product_id;
            private String lvmama_goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String ticket_type;
            private String ticket_type_name;
            private String ticket_name;
            private String ticket_affect_date;
            private String price;
            private String notice_way;
            private String notice_visit_address;
            private String notice_get_ticket_time;
            private String notice_get_ticket_place;
            private String notice_enter_limit_flag;
            private String notice_enter_limit_time;
            private String importent_point;
            private String importent_notice;
            private String refund_rule_notice;

            public String getLvmama_product_id() {
                return lvmama_product_id;
            }

            public void setLvmama_product_id(String lvmama_product_id) {
                this.lvmama_product_id = lvmama_product_id;
            }

            public String getLvmama_goods_id() {
                return lvmama_goods_id;
            }

            public void setLvmama_goods_id(String lvmama_goods_id) {
                this.lvmama_goods_id = lvmama_goods_id;
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

            public String getTicket_type() {
                return ticket_type;
            }

            public void setTicket_type(String ticket_type) {
                this.ticket_type = ticket_type;
            }

            public String getTicket_type_name() {
                return ticket_type_name;
            }

            public void setTicket_type_name(String ticket_type_name) {
                this.ticket_type_name = ticket_type_name;
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

            public String getNotice_way() {
                return notice_way;
            }

            public void setNotice_way(String notice_way) {
                this.notice_way = notice_way;
            }

            public String getNotice_visit_address() {
                return notice_visit_address;
            }

            public void setNotice_visit_address(String notice_visit_address) {
                this.notice_visit_address = notice_visit_address;
            }

            public String getNotice_get_ticket_time() {
                return notice_get_ticket_time;
            }

            public void setNotice_get_ticket_time(String notice_get_ticket_time) {
                this.notice_get_ticket_time = notice_get_ticket_time;
            }

            public String getNotice_get_ticket_place() {
                return notice_get_ticket_place;
            }

            public void setNotice_get_ticket_place(String notice_get_ticket_place) {
                this.notice_get_ticket_place = notice_get_ticket_place;
            }

            public String getNotice_enter_limit_flag() {
                return notice_enter_limit_flag;
            }

            public void setNotice_enter_limit_flag(String notice_enter_limit_flag) {
                this.notice_enter_limit_flag = notice_enter_limit_flag;
            }

            public String getNotice_enter_limit_time() {
                return notice_enter_limit_time;
            }

            public void setNotice_enter_limit_time(String notice_enter_limit_time) {
                this.notice_enter_limit_time = notice_enter_limit_time;
            }

            public String getImportent_point() {
                return importent_point;
            }

            public void setImportent_point(String importent_point) {
                this.importent_point = importent_point;
            }

            public String getImportent_notice() {
                return importent_notice;
            }

            public void setImportent_notice(String importent_notice) {
                this.importent_notice = importent_notice;
            }

            public String getRefund_rule_notice() {
                return refund_rule_notice;
            }

            public void setRefund_rule_notice(String refund_rule_notice) {
                this.refund_rule_notice = refund_rule_notice;
            }
        }
    }
}
