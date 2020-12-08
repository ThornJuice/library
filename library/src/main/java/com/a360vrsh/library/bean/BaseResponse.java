package com.a360vrsh.library.bean;

/**
 * @author: wxj
 * @date: 2020/9/21
 * @description:
 */
public class BaseResponse {

    private int errcode;
    private String errmsg;

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
}
