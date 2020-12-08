package com.a360vrsh.library.http;

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description:
 */
public interface HttpListener {
    public void onSucceed(String response);

    public void onFailed(String errorInfo);
}
