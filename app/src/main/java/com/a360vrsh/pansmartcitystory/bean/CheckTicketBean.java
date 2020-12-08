package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/4
 * @description:
 */
public class CheckTicketBean {

    /**
     * data : {"id":11933,"sname":null,"currentAuthority":["admin","user"],"store_id":14211,"status":2,"store_type":3,"is_pano":1,"pano":{"outlink":false,"local":true}}
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
         * id : 11933
         * sname : null
         * currentAuthority : ["admin","user"]
         * store_id : 14211
         * status : 2
         * store_type : 3
         * is_pano : 1
         * pano : {"outlink":false,"local":true}
         */

        private String id;
        private String sname;
        private String store_id;
        private String status; //店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝
        private String store_type;
        private String is_pano;
        private PanoBean pano;
        private List<String> currentAuthority;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStore_type() {
            return store_type;
        }

        public void setStore_type(String store_type) {
            this.store_type = store_type;
        }

        public String getIs_pano() {
            return is_pano;
        }

        public void setIs_pano(String is_pano) {
            this.is_pano = is_pano;
        }

        public PanoBean getPano() {
            return pano;
        }

        public void setPano(PanoBean pano) {
            this.pano = pano;
        }

        public List<String> getCurrentAuthority() {
            return currentAuthority;
        }

        public void setCurrentAuthority(List<String> currentAuthority) {
            this.currentAuthority = currentAuthority;
        }

        public static class PanoBean implements Serializable {
            /**
             * outlink : false
             * local : true
             */

            private boolean outlink;
            private boolean local;

            public boolean isOutlink() {
                return outlink;
            }

            public void setOutlink(boolean outlink) {
                this.outlink = outlink;
            }

            public boolean isLocal() {
                return local;
            }

            public void setLocal(boolean local) {
                this.local = local;
            }
        }
    }
}
