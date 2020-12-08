package com.a360vrsh.library.http;

/**
 * @author: wxj
 * @date: 2020/8/17
 * @description:
 */
public class SimpleResponse {
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
