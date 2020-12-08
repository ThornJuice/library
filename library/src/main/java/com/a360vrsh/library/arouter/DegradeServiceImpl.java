package com.a360vrsh.library.arouter;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.ActivityCompat;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;


/**
 * desc  : ARouter路由降级处理
 */
@Route(path = DegradeServiceImpl.PATH)
public class DegradeServiceImpl implements DegradeService {

    static final String PATH = "/service/DegradeServiceImpl";

    @Override
    public void onLost(Context context, Postcard postcard) {
//        if (context != null && postcard.getGroup().equals("activity_test")) {
//            Intent intent = new Intent(context, WebViewActivity.class);
//            intent.putExtra(Constant.URL, Constant.GITHUB);
//            intent.putExtra(Constant.TITLE, "github地址");
//            ActivityCompat.startActivity(context, intent, null);
//        }
    }

    @Override
    public void init(Context context) {

    }
}
