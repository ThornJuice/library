package com.a360vrsh.pansmartcitystory.bean;

/**
 * @author: wxj
 * @date: 2020/9/22
 * @description:
 */
public class CurrentUserBean {

    /**
     * data : {"id":11933,"name":"亲！","nick_name":null,"email":null,"phone":"19903966606","store_id":14211,"store_name":"橘子游乐园","store_logo":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png","is_set_pw":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11933
         * name : 亲！
         * nick_name : null
         * email : null
         * phone : 19903966606
         * store_id : 14211
         * store_name : 橘子游乐园
         * store_logo : http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/jQHlKTqWAk42IthUGS07FkKAaY64jY8uxgr8KhKq.png
         * is_set_pw : 1
         */

        private int id;
        private String name;
        private String nick_name;
        private String email;
        private String phone;
        private String store_id;
        private String store_name;
        private String store_logo;
        private int is_set_pw;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

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

        public int getIs_set_pw() {
            return is_set_pw;
        }

        public void setIs_set_pw(int is_set_pw) {
            this.is_set_pw = is_set_pw;
        }
    }
}
