package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description:
 */
public class ArticleListBean {

    /**
     * data : [{"id":1464,"class_name":"全景学院","title":"erwetdhggd","cover_image":"http://test360vrsh.360vrsh.com/article/2020-07-18/k47JuZ5HqhEehBySs3jkJFDcvpLhMCCU5OBXoOhV.png","weigh":0,"is_check":1,"is_recommend":0,"pageview":0,"link_num":0,"comment_num":0,"favorites_num":0,"describe":"tyutyu","created_at":"2020-07-18 16:24:22","updated_at":"2020-07-18 17:03:20"},{"id":1463,"class_name":"全景学院","title":"234```(){\\","cover_image":"http://test360vrsh.360vrsh.com/article/2020-07-18/lvvFT424xDDNFlQgtoHLKw8Nq4zm5bjlQQOwli6G.png","weigh":0,"is_check":1,"is_recommend":0,"pageview":0,"link_num":0,"comment_num":0,"favorites_num":0,"describe":"234","created_at":"2020-07-18 16:23:57","updated_at":"2020-07-18 17:03:21"},{"id":1461,"class_name":"全景学院","title":"平遥古城","cover_image":"http://test360vrsh.360vrsh.com/article/2020-07-18/r7Qn0aLirX0be1fEFGyXlPvN96xJcPpgjw6kqqst.jpeg","weigh":0,"is_check":1,"is_recommend":0,"pageview":0,"link_num":0,"comment_num":0,"favorites_num":0,"describe":"颠三倒四多","created_at":"2020-07-18 15:35:30","updated_at":"2020-07-18 17:03:22"},{"id":1458,"class_name":"全景学院","title":"LivepanoVR全景嵌入人物视频","cover_image":"http://test360vrsh.360vrsh.com/article/2020-07-18/3tzTX9790yDyH4rLr95ZuZzhk9sQO8CvRZJPh6SI.jpeg","weigh":0,"is_check":1,"is_recommend":0,"pageview":0,"link_num":0,"comment_num":0,"favorites_num":0,"describe":"livepano 即完全无缝融合到全景图中的变形热点视频。\n这种无缝融合是真正无缝，从而让观者产生沉浸感和真实感。","created_at":"2020-07-18 15:18:03","updated_at":"2020-07-18 17:03:22"}]
     * links : {"first":"http://find.inner.test.360vrsh.com/api/article/lists?page=1","last":"http://find.inner.test.360vrsh.com/api/article/lists?page=1","prev":null,"next":null}
     * meta : {"current_page":1,"from":1,"last_page":1,"path":"http://find.inner.test.360vrsh.com/api/article/lists","per_page":5,"to":4,"total":4}
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
         * id : 1464
         * class_name : 全景学院
         * title : erwetdhggd
         * cover_image : http://test360vrsh.360vrsh.com/article/2020-07-18/k47JuZ5HqhEehBySs3jkJFDcvpLhMCCU5OBXoOhV.png
         * weigh : 0
         * is_check : 1
         * is_recommend : 0
         * pageview : 0
         * link_num : 0
         * comment_num : 0
         * favorites_num : 0
         * describe : tyutyu
         * created_at : 2020-07-18 16:24:22
         * updated_at : 2020-07-18 17:03:20
         */

        private String id;
        private String class_name;
        private String title;
        private String cover_image;
        private String weigh;
        private String is_check;
        private String is_recommend;
        private String pageview;
        private String link_num;
        private String comment_num;
        private String favorites_num;
        private String describe;
        private String created_at;
        private String updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getWeigh() {
            return weigh;
        }

        public void setWeigh(String weigh) {
            this.weigh = weigh;
        }

        public String getIs_check() {
            return is_check;
        }

        public void setIs_check(String is_check) {
            this.is_check = is_check;
        }

        public String getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(String is_recommend) {
            this.is_recommend = is_recommend;
        }

        public String getPageview() {
            return pageview;
        }

        public void setPageview(String pageview) {
            this.pageview = pageview;
        }

        public String getLink_num() {
            return link_num;
        }

        public void setLink_num(String link_num) {
            this.link_num = link_num;
        }

        public String getComment_num() {
            return comment_num;
        }

        public void setComment_num(String comment_num) {
            this.comment_num = comment_num;
        }

        public String getFavorites_num() {
            return favorites_num;
        }

        public void setFavorites_num(String favorites_num) {
            this.favorites_num = favorites_num;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
