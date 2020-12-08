package com.a360vrsh.pansmartcitystory.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.a360vrsh.library.util.LogUtil;
import com.dou361.pay.wxpay.WechatPayHelper;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, "wx2fe9b0b6c1938e6d");
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
        WechatPayHelper.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        LogUtil.d(TAG, " === wxPay onReq " + req.toString() + " === ");
        WechatPayHelper.handleonReq(req);
    }

    @Override
    public void onResp(BaseResp resp) {
        LogUtil.d(TAG, " ==== wxPay onResp ===" + resp.errStr + ";code=" + String.valueOf(resp.errCode));
        WechatPayHelper.handleOnResp(resp);
        this.finish();
    }
}