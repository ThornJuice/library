package com.a360vrsh.pansmartcitystory.bean;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/16
 * @description:
 */
public class EvaluateListBean {

    /**
     * data : [{"id":218,"user_nickname":"王洪春","user_avatar":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/member_avatar/2020-02-19/aRxO33XNn5LaivIAjqeJnZDPPpIMR6BrN517vGsi.jpeg","score":5,"content":"","image":[],"goods":["哈哈麻花hhh","嘿嘿麻花"],"created_at":"2020.02.28"},{"id":217,"user_nickname":"王洪春","user_avatar":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/member_avatar/2020-02-19/aRxO33XNn5LaivIAjqeJnZDPPpIMR6BrN517vGsi.jpeg","score":3,"content":"","image":[],"goods":["哈哈麻花hhh","嘿嘿麻花"],"created_at":"2020.02.28"},{"id":214,"user_nickname":"匿名用户","user_avatar":"https://ores.360vrsh.com/mob/avatar.png","score":4,"content":"","image":[{"id":31,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/YSP6KxCRIGch15sjfiMG1mdAWIksphcx4m93mMkg.jpeg"},{"id":32,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/PdXPv6Um8y84XhMmZNvVZYwyo0OY95PzEB3fdQjn.jpeg"},{"id":33,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/FZDyOhMemUKN2SCntvCtfnNknYiqq9XOLD8qWHRh.jpeg"},{"id":34,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/Fd0vHV9SDVi20XZR81ZxLJ8YDTfLaoi7ySF6HjBi.jpeg"},{"id":35,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/q8lGAb1ILkt5Uy2CcCB4OrfuVDwzgdCdy5ARBPpx.jpeg"},{"id":36,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/eLXQne87Ddlk30UrjbraUUdJNhA55bIxZ6zjTLeS.jpeg"}],"goods":["哈哈麻花hhh"],"created_at":"2020.02.28"},{"id":213,"user_nickname":"王洪春","user_avatar":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/member_avatar/2020-02-19/aRxO33XNn5LaivIAjqeJnZDPPpIMR6BrN517vGsi.jpeg","score":4,"content":"王老师","image":[{"id":29,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/ZV6Sec03m6IhZknMWLzXzb8q49K0MonLiUr9D5pC.jpeg"},{"id":30,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2020-02-28/jjwiVP3fzkBpC4015IhuFdMtQzpaKrW1CIt0saUO.jpeg"}],"goods":["哈哈麻花hhh","嘿嘿麻花"],"created_at":"2020.02.28"},{"id":19,"user_nickname":"匿名用户","user_avatar":"https://ores.360vrsh.com/mob/avatar.png","score":3,"content":"你模糊","image":[{"id":2,"url":"http://test360vrsh.oss-cn-qingdao.aliyuncs.com/comment/2019-11-08/Mdj1pswiLis6hINhFD2qbow3zifafuML6wfFm0LG.jpeg"}],"goods":["嘿嘿麻花"],"created_at":"2019.11.08"},{"id":14,"user_nickname":"匿名用户","user_avatar":"https://ores.360vrsh.com/mob/avatar.png","score":5,"content":"","image":[],"goods":["嘿嘿麻花"],"created_at":"2019.11.07"},{"id":2,"user_nickname":"匿名用户","user_avatar":"https://ores.360vrsh.com/mob/avatar.png","score":3,"content":"啥东西啊","image":[],"goods":["哈哈麻花","嘿嘿麻花"],"created_at":"2019.11.07"}]
     * links : {"first":"http://test.inner.comment.360vrsh.com/api/comment/store?page=1","last":"http://test.inner.comment.360vrsh.com/api/comment/store?page=1","prev":null,"next":null}
     * meta : {"current_page":1,"from":1,"last_page":1,"path":"http://test.inner.comment.360vrsh.com/api/comment/store","per_page":10,"to":7,"total":7}
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


    public static class DataBean {
        /**
         * id : 218
         * user_nickname : 王洪春
         * user_avatar : http://test360vrsh.oss-cn-qingdao.aliyuncs.com/member_avatar/2020-02-19/aRxO33XNn5LaivIAjqeJnZDPPpIMR6BrN517vGsi.jpeg
         * score : 5
         * content :
         * image : []
         * goods : ["哈哈麻花hhh","嘿嘿麻花"]
         * created_at : 2020.02.28
         */

        private String id;
        private String user_nickname;
        private String user_avatar;
        private String  score;
        private String content;
        private String created_at;
        private List<image> image;
        private List<String> goods;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String  score) {
            this.score = score;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public List<image> getImage() {
            return image;
        }

        public void setImage(List<image> image) {
            this.image = image;
        }

        public List<String> getGoods() {
            return goods;
        }

        public void setGoods(List<String> goods) {
            this.goods = goods;
        }

        public static class image {

            private  String id ;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

    }

}
