package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;

/**
 * @author: wxj
 * @date: 2020/11/11
 * @description:
 */
public class TicketInfoBean {

    /**
     * data : {"id":201,"name":"成人票","reserve_effect":0,"reserve_valid":1,"cost_contain":"所有","cost_without":"无","use_exchange_start":"00:00","use_exchange_end":"00:00","use_exchange_address":"大门口","use_entry_sort":"凭票","use_entry_start":"00:00","use_entry_end":"00:00","use_entry_address":"大门口","change":"不能退改","other":"","verification":1}
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
         * id : 201
         * name : 成人票
         * reserve_effect : 0
         * reserve_valid : 1
         * cost_contain : 所有
         * cost_without : 无
         * use_exchange_start : 00:00
         * use_exchange_end : 00:00
         * use_exchange_address : 大门口
         * use_entry_sort : 凭票
         * use_entry_start : 00:00
         * use_entry_end : 00:00
         * use_entry_address : 大门口
         * change : 不能退改
         * other :
         * verification : 1
         */

        private String id;
        private String name;
        private String reserve_effect;
        private String reserve_valid;
        private String cost_contain;
        private String cost_without;
        private String use_exchange_start;
        private String use_exchange_end;
        private String use_exchange_address;
        private String use_entry_sort;
        private String use_entry_start;
        private String use_entry_end;
        private String use_entry_address;
        private String change;
        private String other;
        private String verification;

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

        public String getReserve_effect() {
            return reserve_effect;
        }

        public void setReserve_effect(String reserve_effect) {
            this.reserve_effect = reserve_effect;
        }

        public String getReserve_valid() {
            return reserve_valid;
        }

        public void setReserve_valid(String reserve_valid) {
            this.reserve_valid = reserve_valid;
        }

        public String getCost_contain() {
            return cost_contain;
        }

        public void setCost_contain(String cost_contain) {
            this.cost_contain = cost_contain;
        }

        public String getCost_without() {
            return cost_without;
        }

        public void setCost_without(String cost_without) {
            this.cost_without = cost_without;
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

        public String getUse_entry_sort() {
            return use_entry_sort;
        }

        public void setUse_entry_sort(String use_entry_sort) {
            this.use_entry_sort = use_entry_sort;
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

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getVerification() {
            return verification;
        }

        public void setVerification(String verification) {
            this.verification = verification;
        }
    }
}
