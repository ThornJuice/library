package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/16
 * @description:
 */
public class OrderListBean {

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
         * id : 859
         * sn : 20200927160951487216
         * order_type : 1
         * status : 0
         * status_title : 待付款
         * refund_status : 0
         * refund_status_title : 正常
         * payd_at : null
         * order_price : 20.00
         * pay_price : 20.00
         * fee : 0.00
         * actually_arrived : 20.00
         * commission : 0.00
         * remark : null
         * goods_num : 2
         * order_code : 87934993
         * created_at : 2020-09-27 16:09:51
         * store : {"store_id":11591,"store_name":"蜜雪冰城","store_logo":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/c7ckBlFNzkHHxs9lDOtQiUChZpBMS4gaJ7gVT65d.jpeg","store_type":1,"store_is_pano":1,"template":3}
         * goods : [{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png","is_spec":1,"spec_label":"大","goods_price":"10.00","pay_price":"10.00","num":1},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png","is_spec":1,"spec_label":"小","goods_price":"10.00","pay_price":"10.00","num":1}]
         * info : {"distribution_mode":1,"name":"王先生","phone":"19903966606","address_detail":"河南省郑州市管城回族区中兴南路与商都路交叉路口西北侧(建正东方中心)17","packing_cost":"0.00","delivery_cost":"0.00"}
         * commission_type : distribution
         */

        private String id;
        private String sn;
        private String order_type;
        private String status;
        private String status_title;
        private String refund_status;
        private String refund_status_title;
        private String payd_at;
        private String order_price;
        private String pay_price;
        private String fee;
        private String actually_arrived;
        private String commission;
        private String remark;
        private String goods_num;
        private String order_code;
        private String created_at;
        private StoreBean store;
        private InfoBean info;
        private String commission_type;
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

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
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

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getCommission_type() {
            return commission_type;
        }

        public void setCommission_type(String commission_type) {
            this.commission_type = commission_type;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class StoreBean implements Serializable {
            /**
             * store_id : 11591
             * store_name : 蜜雪冰城
             * store_logo : http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/c7ckBlFNzkHHxs9lDOtQiUChZpBMS4gaJ7gVT65d.jpeg
             * store_type : 1
             * store_is_pano : 1
             * template : 3
             */

            private String store_id;
            private String store_name;
            private String store_logo;
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

            public String getStore_logo() {
                return store_logo;
            }

            public void setStore_logo(String store_logo) {
                this.store_logo = store_logo;
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

        public static class InfoBean implements Serializable {
            /**
             * distribution_mode : 1
             * name : 王先生
             * phone : 19903966606
             * address_detail : 河南省郑州市管城回族区中兴南路与商都路交叉路口西北侧(建正东方中心)17
             * packing_cost : 0.00
             * delivery_cost : 0.00
             */

            private String distribution_mode;
            private String name;
            private String phone;
            private String address_detail;
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

        public static class GoodsBean implements Serializable {
            /**
             * goods_id : 21305
             * goods_title : 规格价格一样
             * goods_cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png
             * is_spec : 1
             * spec_label : 大
             * goods_price : 10.00
             * pay_price : 10.00
             * num : 1
             */

            private String goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String is_spec;
            private String spec_label;
            private String goods_price;
            private String pay_price;
            private String num;
            private String ticket_affect_date;
            private String lvmama_goods_id;
            private String lvmama_product_id;

            public String getLvmama_goods_id() {
                return lvmama_goods_id;
            }

            public void setLvmama_goods_id(String lvmama_goods_id) {
                this.lvmama_goods_id = lvmama_goods_id;
            }

            public String getLvmama_product_id() {
                return lvmama_product_id;
            }

            public void setLvmama_product_id(String lvmama_product_id) {
                this.lvmama_product_id = lvmama_product_id;
            }

            public String getTicket_affect_date() {
                return ticket_affect_date;
            }

            public void setTicket_affect_date(String ticket_affect_date) {
                this.ticket_affect_date = ticket_affect_date;
            }

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

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getPay_price() {
                return pay_price;
            }

            public void setPay_price(String pay_price) {
                this.pay_price = pay_price;
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
