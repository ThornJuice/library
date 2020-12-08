package com.a360vrsh.library.http;

import android.text.TextUtils;

import com.a360vrsh.baselibrary.R;
import com.a360vrsh.library.base.BaseApplication;
import com.a360vrsh.library.util.ToastUtil;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import rxhttp.wrapper.exception.HttpStatusCodeException;
import rxhttp.wrapper.exception.ParseException;

/**
 * Http请求错误信息
 */
public class ErrorInfo {

    private int errorCode;  //仅指服务器返回的错误码
    private String errorMsg; //错误文案，网络错误、请求失败错误、服务器返回的错误等文案
    private Throwable throwable; //异常信息

    public ErrorInfo(Throwable throwable) {
        this.throwable = throwable;
        String errorMsg = null;
        if (throwable instanceof UnknownHostException) {
            if (!ExceptionHelper.isNetworkConnected(BaseApplication.getInstance())) {
                errorMsg = getString(R.string.library_network_error);
            } else {
                errorMsg = getString(R.string.library_notify_no_network);
            }
        } else if (throwable instanceof SocketTimeoutException || throwable instanceof TimeoutException) {
            //前者是通过OkHttpClient设置的超时引发的异常，后者是对单个请求调用timeout方法引发的超时异常
            errorMsg = getString(R.string.library_time_out_please_try_again_later);
        } else if (throwable instanceof ConnectException) {
            errorMsg = getString(R.string.library_esky_service_exception);
        } else if (throwable instanceof HttpStatusCodeException) { //请求失败异常
            String errorCode = throwable.getLocalizedMessage();
            this.errorCode = Integer.parseInt(errorCode);
            errorMsg = "服务器开小差,请稍后再试";
        } else if (throwable instanceof JsonSyntaxException) { //请求成功，但Json语法异常,导致解析失败
            errorMsg = "数据解析失败,请稍后再试";
        } else if (throwable instanceof ParseException) { // ParseException异常表明请求成功，但是数据不正确
            String errorCode = throwable.getLocalizedMessage();
            this.errorCode = Integer.parseInt(errorCode);
            errorMsg = throwable.getMessage();
            if (TextUtils.isEmpty(errorMsg)) errorMsg = errorCode;//errorMsg为空，显示errorCode
        } else {
            errorMsg = throwable.getMessage();
        }
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Throwable getThrowable() {
        return throwable;
    }


    public String getString(int resId) {
        return BaseApplication.getInstance().getString(resId);
    }
}
