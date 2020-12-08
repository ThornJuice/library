package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;

/**
 * @author: wxj
 * @date: 2020/11/24
 * @description:
 */
public class RedPacketDetailBean {

    /**
     * data : {"id":26,"type":2,"is_pay":2,"money":"1.00","amount":"1.00","money_surplus":"0.02","pay_no":"8b04c5363e89503a21ac7e5a42d45ceb","pay_type":1,"number_total":3,"number_surplus":2,"is_open":1,"is_over":1,"created_at":"2020-06-24 15:57:32"}
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
         * id : 26
         * type : 2
         * is_pay : 2
         * money : 1.00
         * amount : 1.00
         * money_surplus : 0.02
         * pay_no : 8b04c5363e89503a21ac7e5a42d45ceb
         * pay_type : 1
         * number_total : 3
         * number_surplus : 2
         * is_open : 1
         * is_over : 1
         * created_at : 2020-06-24 15:57:32
         */

        private String id;
        private String type;
        private String is_pay;
        private String money;
        private String amount;
        private String money_surplus;
        private String pay_no;
        private String pay_type;
        private String number_total;
        private String number_surplus;
        private String is_open;
        private String is_over;
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

        public String getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(String is_pay) {
            this.is_pay = is_pay;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getNumber_total() {
            return number_total;
        }

        public void setNumber_total(String number_total) {
            this.number_total = number_total;
        }

        public String getNumber_surplus() {
            return number_surplus;
        }

        public void setNumber_surplus(String number_surplus) {
            this.number_surplus = number_surplus;
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

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getMoney_surplus() {
            return money_surplus;
        }

        public void setMoney_surplus(String money_surplus) {
            this.money_surplus = money_surplus;
        }

        public String getPay_no() {
            return pay_no;
        }

        public void setPay_no(String pay_no) {
            this.pay_no = pay_no;
        }


        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
