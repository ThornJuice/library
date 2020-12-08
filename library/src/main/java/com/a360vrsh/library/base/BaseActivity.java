package com.a360vrsh.library.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.a360vrsh.library.bean.EventBean;
import com.a360vrsh.library.util.ActivityCollector;
import com.a360vrsh.library.util.DoubleClickUtil;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 无标题栏
 */
public abstract class BaseActivity extends FragmentActivity {
    public String TAG = this.getClass().getSimpleName();
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initImmersionBar();
        setPortrait();
        super.setContentView(getLayoutId());

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        ActivityCollector.addActivity(this);
        initView();
        initListener();
        initData();
    }

    /**
     * 设置沉浸式状态栏
     */
    protected void initImmersionBar() {

        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0f)
                .init();

    }

    /**
     * 设置强制竖屏
     */
    public void setPortrait() {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();


    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, Bundle ex) {
        gotoActivity(clz, false, ex);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        if (DoubleClickUtil.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        ActivityCollector.removeActivity(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBean event) {

    }

}
