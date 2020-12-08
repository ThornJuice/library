package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/17
 * @description:
 */
public class TravelOrderDetailBean {

    /**
     * data : {"id":641,"sn":"20200819110301263645","order_type":2,"status":-3,"status_title":"已取消","refund_status":0,"refund_status_title":"正常","pay_type":0,"pay_sn":"","payd_at":"","order_price":"1.00","pay_price":"1.00","commission":"0.00","fee":"0.00","actually_arrived":"1.00","goods_num":1,"remark":"","order_code":"61489922","created_at":"2020-08-19 11:03:01","goods":[{"goods_id":21158,"goods_title":"郑州方特水上乐园","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-06-04/yOGSRIfgPh8CJhpSkUl9MKGSuWPrCXTzXo6MH2X9.png","ticket_id":172,"ticket_type":1,"ticket_type_name":"成人票","ticket_name":"成人票--方特","ticket_affect_date":"2020-08-21","price":"1.00","use_entry_sort":"12","use_exchange_start":"00:00:00","use_exchange_end":"00:00:00","use_exchange_address":"12","use_entry_start":"00:00:00","use_entry_end":"00:00:00","use_entry_address":"12","change":"12","ticket_verification":0}],"info":[{"tourist_id":129,"tourist_name":"测试测试测试测试测测","tourist_idcard":"412827199007131517","tourist_phone":"19903966606"}],"store":{"store_id":14097,"store_name":"郑州方特欢乐世界","store_phone":"400-611-1360","store_type":3,"address":"新兴家园","lng":"113.0296321292","lat":"34.7559067165","template":0}}
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
         * id : 641
         * sn : 20200819110301263645
         * order_type : 2
         * status : -3
         * status_title : 已取消
         * refund_status : 0
         * refund_status_title : 正常
         * pay_type : 0
         * pay_sn :
         * payd_at :
         * order_price : 1.00
         * pay_price : 1.00
         * commission : 0.00
         * fee : 0.00
         * actually_arrived : 1.00
         * goods_num : 1
         * remark :
         * order_code : 61489922
         * created_at : 2020-08-19 11:03:01
         * goods : [{"goods_id":21158,"goods_title":"郑州方特水上乐园","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-06-04/yOGSRIfgPh8CJhpSkUl9MKGSuWPrCXTzXo6MH2X9.png","ticket_id":172,"ticket_type":1,"ticket_type_name":"成人票","ticket_name":"成人票--方特","ticket_affect_date":"2020-08-21","price":"1.00","use_entry_sort":"12","use_exchange_start":"00:00:00","use_exchange_end":"00:00:00","use_exchange_address":"12","use_entry_start":"00:00:00","use_entry_end":"00:00:00","use_entry_address":"12","change":"12","ticket_verification":0}]
         * info : [{"tourist_id":129,"tourist_name":"测试测试测试测试测测","tourist_idcard":"412827199007131517","tourist_phone":"19903966606"}]
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
        private StoreBean store;
        private List<GoodsBean> goods;
        private List<InfoBean> info;

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

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
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
             * goods_id : 21158
             * goods_title : 郑州方特水上乐园
             * goods_cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-06-04/yOGSRIfgPh8CJhpSkUl9MKGSuWPrCXTzXo6MH2X9.png
             * ticket_id : 172
             * ticket_type : 1
             * ticket_type_name : 成人票
             * ticket_name : 成人票--方特
             * ticket_affect_date : 2020-08-21
             * price : 1.00
             * use_entry_sort : 12
             * use_exchange_start : 00:00:00
             * use_exchange_end : 00:00:00
             * use_exchange_address : 12
             * use_entry_start : 00:00:00
             * use_entry_end : 00:00:00
             * use_entry_address : 12
             * change : 12
             * ticket_verification : 0
             */

            private String goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String ticket_id;
            private String ticket_type;
            private String ticket_type_name;
            private String ticket_name;
            private String ticket_affect_date;
            private String price;
            private String use_entry_sort;
            private String use_exchange_start;
            private String use_exchange_end;
            private String use_exchange_address;
            private String use_entry_start;
            private String use_entry_end;
            private String use_entry_address;
            private String change;
            private String ticket_verification;

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

            public String getTicket_id() {
                return ticket_id;
            }

            public void setTicket_id(String ticket_id) {
                this.ticket_id = ticket_id;
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

            public String getUse_entry_sort() {
                return use_entry_sort;
            }

            public void setUse_entry_sort(String use_entry_sort) {
                this.use_entry_sort = use_entry_sort;
            }

            public String getUse_exchange_start() {
                return use_exchange_start;
            }

            public void setUse_exchange_start(String use_exchange_start) {
                this.use_exchange_start = use_exchange_start;
            }

            public String getUse_exchange_end() {
                return use_exchange_end;
            }

            public void setUse_exchange_end(String use_exchange_end) {
                this.use_exchange_end = use_exchange_end;
            }

            public String getUse_exchange_address() {
                return use_exchange_address;
            }

            public void setUse_exchange_address(String use_exchange_address) {
                this.use_exchange_address = use_exchange_address;
            }

            public String getUse_entry_start() {
                return use_entry_start;
            }

            public void setUse_entry_start(String use_entry_start) {
                this.use_entry_start = use_entry_start;
            }

            public String getUse_entry_end() {
                return use_entry_end;
            }

            public void setUse_entry_end(String use_entry_end) {
                this.use_entry_end = use_entry_end;
            }

            public String getUse_entry_address() {
                return use_entry_address;
            }

            public void setUse_entry_address(String use_entry_address) {
                this.use_entry_address = use_entry_address;
            }

            public String getChange() {
                return change;
            }

            public void setChange(String change) {
                this.change = change;
            }

            public String getTicket_verification() {
                return ticket_verification;
            }

            public void setTicket_verification(String ticket_verification) {
                this.ticket_verification = ticket_verification;
            }
        }

        public static class InfoBean implements Serializable {
            /**
             * tourist_id : 129
             * tourist_name : 测试测试测试测试测测
             * tourist_idcard : 412827199007131517
             * tourist_phone : 19903966606
             */

            private String tourist_id;
            private String tourist_name;
            private String tourist_idcard;
            private String tourist_phone;

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
        }
    }
}
