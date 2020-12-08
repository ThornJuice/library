package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/12
 * @description:
 */
public class PanoListBean {

    /**
     * data : [{"id":10902,"thumb":"https://test.res.jsvry.cn/test/image/2020/06/17/16314827r8mua.jpg","title":"蜜雪冰城","status":{"value":1,"label":"审核通过"},"is_default":1,"created_at":"2020-07-14 14:07:26","type":{"value":1,"label":"本地","pano_id":22109,"pano_status":1,"id":9312}}]
     * links : {"first":"http://scenter.inner.test.360vrsh.com/api/manage/pano?page=1","last":"http://scenter.inner.test.360vrsh.com/api/manage/pano?page=1","prev":null,"next":null}
     * meta : {"current_page":1,"from":1,"last_page":1,"path":"http://scenter.inner.test.360vrsh.com/api/manage/pano","per_page":10,"to":1,"total":1}
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
         * id : 10902
         * thumb : https://test.res.jsvry.cn/test/image/2020/06/17/16314827r8mua.jpg
         * title : 蜜雪冰城
         * status : {"value":1,"label":"审核通过"}
         * is_default : 1
         * created_at : 2020-07-14 14:07:26
         * type : {"value":1,"label":"本地","pano_id":22109,"pano_status":1,"id":9312}
         */

        private String id;
        private String thumb;
        private String title;
        private String reason;
        private StatusBean status;
        private String is_default;
        private String created_at;
        private TypeBean type;
        private List<String> evidence;

        public List<String> getEvidence() {
            return evidence;
        }

        public void setEvidence(List<String> evidence) {
            this.evidence = evidence;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public static class StatusBean implements Serializable {
            /**
             * value : 1
             * label : 审核通过
             */

            private String value;
            private String label;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        }

        public static class TypeBean implements Serializable {
            /**
             * value : 1
             * label : 本地
             * pano_id : 22109
             * pano_status : 1
             * id : 9312
             */

            private String value;
            private String label;
            private String pano_id;
            private String pano_status;
            private String id;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getPano_id() {
                return pano_id;
            }

            public void setPano_id(String pano_id) {
                this.pano_id = pano_id;
            }

            public String getPano_status() {
                return pano_status;
            }

            public void setPano_status(String pano_status) {
                this.pano_status = pano_status;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
