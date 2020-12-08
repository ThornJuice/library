package com.a360vrsh.library.bean;

/**
 * @author: wxj
 * @date: 2020/9/11
 * @description:
 */

public class EventBean {


    public int id;
    public String oneParam;
    public String twoParam;
    public String threeParam;
    public String fourParam;

    public EventBean(int id, String oneParam, String twoParam, String threeParam, String fourParam) {
        this.id = id;
        this.oneParam = oneParam;
        this.twoParam = twoParam;
        this.threeParam = threeParam;
        this.fourParam = fourParam;
    }

    public EventBean(int id, String oneParam, String twoParam, String threeParam) {
        this.id = id;
        this.oneParam = oneParam;
        this.twoParam = twoParam;
        this.threeParam = threeParam;
    }

    public EventBean(int id, String oneParam, String twoParam) {
        this.id = id;
        this.oneParam = oneParam;
        this.twoParam = twoParam;
    }

    public EventBean(int id, String oneParam) {
        this.id = id;
        this.oneParam = oneParam;
    }

    public EventBean(int id) {
        this.id = id;
    }
}

