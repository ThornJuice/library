package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/10
 * @description: 商品详情bean
 */
public class GoodsDetailBean {

    /**
     * data : {"id":21254,"store_id":14211,"store_type":3,"store_type_name":"旅游","status_audit":2,"status_shelf":1,"title":"游乐园1号","gs1_code":"123","class_id":4207,"class_name":"游乐园","price":"0.00","price_origin":0,"price_cost":"0.00","describe":"游乐园1号描述","images":[{"id":34315,"name":"UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png","path":"store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png","url":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png"}],"attribute":[],"specs":[],"shelf_auto":0,"content":"","toruism":{"tag":["标签1"],"type":1,"site_name":"这是游乐园1号","province_id":16,"province":"河南省","city_id":240,"city":"郑州市","region_id":2664,"region":"金水区","site_address":"这是游乐园1号的地址","site_type":2,"site_type_name":"游乐园","product":"<p><\/p>","cost":"<p>费用<\/p>","notice":"<p>购买须知<\/p>"}}
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
         * id : 21254
         * store_id : 14211
         * store_type : 3
         * store_type_name : 旅游
         * status_audit : 2
         * status_shelf : 1
         * title : 游乐园1号
         * gs1_code : 123
         * class_id : 4207
         * class_name : 游乐园
         * price : 0.00
         * price_origin : 0
         * price_cost : 0.00
         * describe : 游乐园1号描述
         * images : [{"id":34315,"name":"UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png","path":"store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png","url":"http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png"}]
         * attribute : []
         * specs : []
         * shelf_auto : 0
         * content :
         * toruism : {"tag":["标签1"],"type":1,"site_name":"这是游乐园1号","province_id":16,"province":"河南省","city_id":240,"city":"郑州市","region_id":2664,"region":"金水区","site_address":"这是游乐园1号的地址","site_type":2,"site_type_name":"游乐园","product":"<p><\/p>","cost":"<p>费用<\/p>","notice":"<p>购买须知<\/p>"}
         */

        private String id;
        private String store_id;
        private String store_type;
        private String store_type_name;
        private String status_audit;
        private String status_shelf;
        private String title;
        private String gs1_code;
        private String class_id;
        private String class_name;
        private String price;
        private String price_origin;
        private String price_cost;
        private String packing_cost;
        private String describe;
        private String shelf_auto;
        private String content;
        private ToruismBean toruism;
        private List<ImagesBean> images;
        private List<AttributeBean> attribute;
        private List<SpecsBean> specs;

        public String getPacking_cost() {
            return packing_cost;
        }

        public void setPacking_cost(String packing_cost) {
            this.packing_cost = packing_cost;
        }

        public String getStore_type_name() {
            return store_type_name;
        }

        public void setStore_type_name(String store_type_name) {
            this.store_type_name = store_type_name;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGs1_code() {
            return gs1_code;
        }

        public void setGs1_code(String gs1_code) {
            this.gs1_code = gs1_code;
        }


        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }


        public String getPrice_cost() {
            return price_cost;
        }

        public void setPrice_cost(String price_cost) {
            this.price_cost = price_cost;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ToruismBean getToruism() {
            return toruism;
        }

        public void setToruism(ToruismBean toruism) {
            this.toruism = toruism;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public List<AttributeBean> getAttribute() {
            return attribute;
        }

        public void setAttribute(List<AttributeBean> attribute) {
            this.attribute = attribute;
        }

        public List<SpecsBean> getSpecs() {
            return specs;
        }

        public void setSpecs(List<SpecsBean> specs) {
            this.specs = specs;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_type() {
            return store_type;
        }

        public void setStore_type(String store_type) {
            this.store_type = store_type;
        }

        public String getStatus_audit() {
            return status_audit;
        }

        public void setStatus_audit(String status_audit) {
            this.status_audit = status_audit;
        }

        public String getStatus_shelf() {
            return status_shelf;
        }

        public void setStatus_shelf(String status_shelf) {
            this.status_shelf = status_shelf;
        }

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }

        public String getPrice_origin() {
            return price_origin;
        }

        public void setPrice_origin(String price_origin) {
            this.price_origin = price_origin;
        }

        public String getShelf_auto() {
            return shelf_auto;
        }

        public void setShelf_auto(String shelf_auto) {
            this.shelf_auto = shelf_auto;
        }

        public static class ToruismBean implements Serializable {
            /**
             * tag : ["标签1"]
             * type : 1
             * site_name : 这是游乐园1号
             * province_id : 16
             * province : 河南省
             * city_id : 240
             * city : 郑州市
             * region_id : 2664
             * region : 金水区
             * site_address : 这是游乐园1号的地址
             * site_type : 2
             * site_type_name : 游乐园
             * product : <p></p>
             * cost : <p>费用</p>
             * notice : <p>购买须知</p>
             */

            private String type;
            private String site_name;
            private String province_id;
            private String province;
            private String city_id;
            private String city;
            private String region_id;
            private String region;
            private String site_address;
            private String site_type;
            private String site_type_name;
            private String product;
            private String cost;
            private String notice;
            private List<String> tag;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSite_name() {
                return site_name;
            }

            public void setSite_name(String site_name) {
                this.site_name = site_name;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getRegion_id() {
                return region_id;
            }

            public void setRegion_id(String region_id) {
                this.region_id = region_id;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getSite_address() {
                return site_address;
            }

            public void setSite_address(String site_address) {
                this.site_address = site_address;
            }

            public String getSite_type() {
                return site_type;
            }

            public void setSite_type(String site_type) {
                this.site_type = site_type;
            }

            public String getSite_type_name() {
                return site_type_name;
            }

            public void setSite_type_name(String site_type_name) {
                this.site_type_name = site_type_name;
            }

            public String getProduct() {
                return product;
            }

            public void setProduct(String product) {
                this.product = product;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public List<String> getTag() {
                return tag;
            }

            public void setTag(List<String> tag) {
                this.tag = tag;
            }

        }

        public static class ImagesBean implements Serializable {
            /**
             * id : 34315
             * name : UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png
             * path : store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png
             * url : http://test360vrsh.360vrsh.com/store_avatar/2020-07-17/UTKkGt3GyGB6xhonnmUJNPlgOUVLosjvnSxYHSPB.png
             */

            private String id;
            private String name;
            private String path;
            private String url;

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

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        public static class AttributeBean implements Serializable {
            /**
             * name : 规格
             * value : ["大","小"]
             */

            private String name;
            private List<String> value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getValue() {
                return value;
            }

            public void setValue(List<String> value) {
                this.value = value;
            }
        }

        public static class SpecsBean implements Serializable {
            /**
             * id : 21281
             * name : ["大","男","热"]
             * price : 1.00
             * price_cost : 1.00
             * price_origin : 1.00
             * sku : qwe
             */

            private String id;
            private String price;
            private String price_cost;
            private String price_origin;
            private String sku;
            private List<String> name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPrice_cost() {
                return price_cost;
            }

            public void setPrice_cost(String price_cost) {
                this.price_cost = price_cost;
            }

            public String getPrice_origin() {
                return price_origin;
            }

            public void setPrice_origin(String price_origin) {
                this.price_origin = price_origin;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public List<String> getName() {
                return name;
            }

            public void setName(List<String> name) {
                this.name = name;
            }
        }
    }
}
