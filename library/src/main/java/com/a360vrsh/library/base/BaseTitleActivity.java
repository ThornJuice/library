package com.a360vrsh.library.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.a360vrsh.baselibrary.R;
import com.a360vrsh.library.bean.EventBean;
import com.a360vrsh.library.service.ISplashService;
import com.a360vrsh.library.util.ActivityCollector;
import com.a360vrsh.library.util.DoubleClickUtil;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public abstract class BaseTitleActivity extends FragmentActivity {
    protected String TAG = this.getClass().getSimpleName();
    protected TextView tvBack;
    protected LinearLayout llBack;
    protected TextView titleText;
    protected ImageView ivRight;
    protected LinearLayout llRight;
    protected TextView tvRight;
    protected RelativeLayout rlRoot;

    private FrameLayout flContainer;

    private ISplashService splashService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initImmersionBar();
        setPortrait();
        super.setContentView(R.layout.library_base_activity);

        View view = getLayoutInflater().inflate(getLayoutId(), null);

        flContainer = findViewById(R.id.base_container);
//        if (flContainer == null) {
//            splashService = ARouter.getInstance().navigation(ISplashService.class);
//            splashService.toSplash();
//            finish();
//            return;
//        }
        flContainer.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        ButterKnife.bind(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        ActivityCollector.addActivity(this);
        initTitleBar();
        initView();
        initListener();
        initObserver();
        initData();

    }

    /**
     * 设置沉浸式状态栏
     */
    protected void initImmersionBar() {

        ImmersionBar.with(this)
                .statusBarColor(R.color.library_white)
                .statusBarDarkFont(true, 0f)
                .init();

    }

    /**
     * 设置强制竖屏
     */
    public void setPortrait() {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void initTitleBar() {

        tvBack = findViewById(R.id.tv_back);
        llBack = findViewById(R.id.ll_back);
        titleText = findViewById(R.id.title_text);
        ivRight = findViewById(R.id.iv_right);
        llRight = findViewById(R.id.ll_right);
        tvRight = findViewById(R.id.tv_right);
        rlRoot = findViewById(R.id.base_title_bar_root);
        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void removeTitleBar() {
        if (rlRoot != null) {
            rlRoot.setVisibility(View.GONE);
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initObserver();

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

    protected ViewModel initViewModel(Class<? extends ViewModel> modelClass) {
        return ViewModelProviders.of(this).get(modelClass);
    }
}
