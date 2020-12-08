package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/10
 * @description:
 */
public class TicketListBean {

    /**
     * data : [{"type":1,"type_name":"成人票","list":[{"id":201,"name":"成人票","price_min":"99.00","price_max":"99.00","is_edit":1,"is_price":1}]}]
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
         * type : 1
         * type_name : 成人票
         * list : [{"id":201,"name":"成人票","price_min":"99.00","price_max":"99.00","is_edit":1,"is_price":1}]
         */

        private String type;
        private String type_name;
        private List<ListBean> list;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * id : 201
             * name : 成人票
             * price_min : 99.00
             * price_max : 99.00
             * is_edit : 1
             * is_price : 1
             */

            private String id;
            private String name;
            private String price_min;
            private String price_max;
            private String is_edit;
            private String is_price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice_min() {
                return price_min;
            }

            public void setPrice_min(String price_min) {
                this.price_min = price_min;
            }

            public String getPrice_max() {
                return price_max;
            }

            public void setPrice_max(String price_max) {
                this.price_max = price_max;
            }

            public String getIs_edit() {
                return is_edit;
            }

            public void setIs_edit(String is_edit) {
                this.is_edit = is_edit;
            }

            public String getIs_price() {
                return is_price;
            }

            public void setIs_price(String is_price) {
                this.is_price = is_price;
            }
        }
    }
}
