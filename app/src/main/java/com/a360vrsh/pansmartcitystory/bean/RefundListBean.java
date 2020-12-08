package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/16
 * @description:
 */
public class RefundListBean {

    /**
     * data : [{"id":123,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916175838424485","refund_sn":"2020091617595241326","pay_money":"400.00","payd_at":"2020-09-16 17:59:07","money":"350.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"},{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png"}],"info":[],"created_at":"2020-09-16 17:59:52"},{"id":122,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916175146342579","refund_sn":"2020091617531892941","pay_money":"400.00","payd_at":"2020-09-16 17:52:15","money":"370.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"},{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png"}],"info":[],"created_at":"2020-09-16 17:53:18"},{"id":121,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916171012937126","refund_sn":"2020091617113067911","pay_money":"400.00","payd_at":"2020-09-16 17:10:37","money":"360.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"},{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png"}],"info":[],"created_at":"2020-09-16 17:11:30"},{"id":120,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916165431487958","refund_sn":"2020091617015195019","pay_money":"400.00","payd_at":"2020-09-16 16:55:29","money":"350.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"},{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png"}],"info":[],"created_at":"2020-09-16 17:01:51"},{"id":119,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916163200673249","refund_sn":"2020091616330352042","pay_money":"100.00","payd_at":"2020-09-16 16:32:17","money":"100.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"}],"info":[],"created_at":"2020-09-16 16:33:03"},{"id":118,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916163038493808","refund_sn":"2020091616313066387","pay_money":"100.00","payd_at":"2020-09-16 16:31:11","money":"100.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"}],"info":[],"created_at":"2020-09-16 16:31:30"},{"id":117,"order_type":1,"status":3,"refund_status_title":"退款成功","order_sn":"20200916161955884020","refund_sn":"2020091616241758948","pay_money":"100.00","payd_at":"2020-09-16 16:20:28","money":"60.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"}],"info":[],"created_at":"2020-09-16 16:24:17"},{"id":105,"order_type":1,"status":-2,"refund_status_title":"取消退款","order_sn":"20200909164301101048","refund_sn":"2020090918003581601","pay_money":"40.10","payd_at":"2020-09-09 16:44:03","money":"40.10","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":2,"goods_title":"布丁奶茶","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/aKDFcZMgCj6TSpUBG1ypA1ZKRehvVOlDk3U0AQON.jpeg"},{"goods_id":3,"goods_title":"测试商品--双拼巧克力奶茶附图规划局规划局规划兔兔兔兔一题题题","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-01/BN2E1zhehPcrLhYOE1awevRWbJIgkTvDAdz1prmE.jpeg"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"}],"info":[],"created_at":"2020-09-09 18:00:35"},{"id":104,"order_type":1,"status":1,"refund_status_title":"审核中","order_sn":"20200902104311658741","refund_sn":"2020090316585027456","pay_money":"200.00","payd_at":"2020-09-02 10:43:30","money":"200.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"}],"info":[],"created_at":"2020-09-03 16:58:50"},{"id":103,"order_type":1,"status":-1,"refund_status_title":"拒绝退款","order_sn":"20200903161702408991","refund_sn":"2020090316210368505","pay_money":"372.00","payd_at":"2020-09-03 16:17:50","money":"372.00","reason":"退货退款","store":{"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3},"goods":[{"goods_id":21236,"goods_title":"ekfjif123","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-09/MWDAUhJovBIuGMOzUKjgr7Li78rxAS3VGWEUP3TH.png"}],"info":[],"created_at":"2020-09-03 16:21:03"}]
     * links : {"first":"http://order.inner.test.360vrsh.com/api/refunds/list?page=1","last":"http://order.inner.test.360vrsh.com/api/refunds/list?page=3","prev":null,"next":"http://order.inner.test.360vrsh.com/api/refunds/list?page=2"}
     * meta : {"current_page":1,"from":1,"last_page":3,"path":"http://order.inner.test.360vrsh.com/api/refunds/list","per_page":"10","to":10,"total":28}
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
         * id : 123
         * order_type : 1
         * status : 3
         * refund_status_title : 退款成功
         * order_sn : 20200916175838424485
         * refund_sn : 2020091617595241326
         * pay_money : 400.00
         * payd_at : 2020-09-16 17:59:07
         * money : 350.00
         * reason : 退货退款
         * store : {"store_id":11591,"store_name":"蜜雪冰城","store_type":1,"store_is_pano":1,"template":3}
         * goods : [{"goods_id":21275,"goods_title":"3D模型专用，勿删勿下架","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png"},{"goods_id":21279,"goods_title":"测试3D专用哦-1","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-08-21/YtNMwRrUnITuXSSj5oumMblpRqIddQiefX1zgICv.gif"},{"goods_id":21303,"goods_title":"测试规格商品","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/uOXGw53uzNhDA2g2oaFy4Rhv1LYdsk0mKdrLZ6td.jpeg"},{"goods_id":21305,"goods_title":"规格价格一样","goods_cover_image":"http://test360vrsh.360vrsh.com/store_avatar/2020-09-03/L8T4ec3tuB2Ppz6z0bHBlIfehS20sOazDalDbe7W.png"}]
         * info : []
         * created_at : 2020-09-16 17:59:52
         */

        private String id;
        private String order_type;
        private String status;
        private String refund_status_title;
        private String order_sn;
        private String refund_sn;
        private String pay_money;
        private String payd_at;
        private String money;
        private String reason;
        private StoreBean store;
        private String created_at;
        private List<GoodsBean> goods;

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

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
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

        public String getPayd_at() {
            return payd_at;
        }

        public void setPayd_at(String payd_at) {
            this.payd_at = payd_at;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
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
             * store_type : 1
             * store_is_pano : 1
             * template : 3
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
             * goods_id : 21275
             * goods_title : 3D模型专用，勿删勿下架
             * goods_cover_image : http://test360vrsh.360vrsh.com/store_avatar/2020-08-18/t70LdRNR4oker3I9zKmWfzUV7cLaqrjcytPCDacP.png
             */

            private String goods_id;
            private String goods_title;
            private String goods_cover_image;
            private String goods_pay_price;
            private String num;
            private String spec_label;
            private String ticket_price;
            private String ticket_id;
            private String ticket_affect_date;

            public String getTicket_price() {
                return ticket_price;
            }

            public void setTicket_price(String ticket_price) {
                this.ticket_price = ticket_price;
            }

            public String getTicket_id() {
                return ticket_id;
            }

            public void setTicket_id(String ticket_id) {
                this.ticket_id = ticket_id;
            }

            public String getTicket_affect_date() {
                return ticket_affect_date;
            }

            public void setTicket_affect_date(String ticket_affect_date) {
                this.ticket_affect_date = ticket_affect_date;
            }

            public String getGoods_pay_price() {
                return goods_pay_price;
            }

            public void setGoods_pay_price(String goods_pay_price) {
                this.goods_pay_price = goods_pay_price;
            }

            public String getSpec_label() {
                return spec_label;
            }

            public void setSpec_label(String spec_label) {
                this.spec_label = spec_label;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
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
        }
    }
}
