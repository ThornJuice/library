package com.a360vrsh.pansmartcitystory.bean;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/23
 * @description:
 */
public class RedPacketListBean {
    private int errcode;
    private String errmsg;
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
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

    public static class DataBean {
        private String id;

        private String type;

        private String slogan;

        private String money;

        private String balance;

        private String pay_money;

        private String number_total;

        private String number_receive;

        private String number_surplus;

        private String is_pay;

        private String is_open;

        private String is_over;

        private String is_too_long;

        private String created_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getNumber_total() {
            return number_total;
        }

        public void setNumber_total(String number_total) {
            this.number_total = number_total;
        }

        public String getNumber_receive() {
            return number_receive;
        }

        public void setNumber_receive(String number_receive) {
            this.number_receive = number_receive;
        }

        public String getNumber_surplus() {
            return number_surplus;
        }

        public void setNumber_surplus(String number_surplus) {
            this.number_surplus = number_surplus;
        }

        public String getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(String is_pay) {
            this.is_pay = is_pay;
        }

        public String getIs_open() {
            return is_open;
        }

        public void setIs_open(String is_open) {
            this.is_open = is_open;
        }

        public String getIs_over() {
            return is_over;
        }

        public void setIs_over(String is_over) {
            this.is_over = is_over;
        }

        public String getIs_too_long() {
            return is_too_long;
        }

        public void setIs_too_long(String is_too_long) {
            this.is_too_long = is_too_long;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }

}
