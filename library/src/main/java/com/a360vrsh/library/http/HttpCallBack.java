package com.a360vrsh.library.http;

import com.a360vrsh.library.util.LogUtil;
import com.a360vrsh.library.util.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author: wxj
 * @date: 2020/8/17
 * @description:
 */
public abstract class HttpCallBack {

    public String onSucceed(String response) {
        String result = "";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            int errorCode = jsonObject.optInt("errcode");
            if (errorCode == 0) {
                LogUtil.e("RxHttpResponse", "onSucceed:" + response);
                onSuccess(response);
                return result;
            } else if (errorCode == 4002) {
                LogUtil.e("RxHttpResponse", "onSucceed:" + response);
                ToastUtil.show("4002");
                return result;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void onFailed(String response) {
        LogUtil.e("RxHttpResponse", "onFailed:" + response);
    }

    public abstract void onSuccess(String response);
}
