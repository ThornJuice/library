package com.a360vrsh.pansmartcitystory.wxapi;


import android.os.Bundle;

import com.a360vrsh.library.bean.EventBean;
import com.umeng.weixin.callback.WXCallbackActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WXEntryActivity extends WXCallbackActivity {


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        EventBus.getDefault().register(this);
    }

    @Override
    public void a(com.umeng.weixin.umengwx.b b) {

        if (b instanceof com.umeng.weixin.umengwx.i) {

//            EventBus.getDefault().post(new EventBean(28, ((i) b).e));
            finish();

        } else {
            super.a(b);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBean event) {

    }
}
