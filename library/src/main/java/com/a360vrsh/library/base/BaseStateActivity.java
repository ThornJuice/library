package com.a360vrsh.library.base;

import android.content.Context;
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

import com.a360vrsh.baselibrary.R;
import com.a360vrsh.library.service.ISplashService;
import com.bumptech.glide.Glide;
import com.gyf.immersionbar.ImmersionBar;
import com.ns.yc.ycstatelib.StateLayoutManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


public abstract class BaseStateActivity extends FragmentActivity {

    public TextView tvBack;
    public LinearLayout llBack;
    public TextView titleText;
    public ImageView ivRight;
    public LinearLayout llRight;
    public TextView tvRight;
    public RelativeLayout rlRoot;


    private ISplashService splashService;
    public Context context;
    protected StateLayoutManager statusLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initImmersionBar();
        setPortrait();
        super.setContentView(R.layout.library_base_activity);
        initLayout();
        initBaseView();


//      FrameLayout  flContainer = findViewById(R.id.fl_container);
//        if (flContainer == null) {
//            splashService = ARouter.getInstance().navigation(ISplashService.class);
//            splashService.toSplash();
//            finish();
//            return;
//        }
//        View view = getLayoutInflater().inflate(getLayoutId(), null);
//        flContainer.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        initTitleBar();
        initView();
        initData();
    }


    /**
     * 获取到子布局
     */
    private void initBaseView() {
        FrameLayout flMain = findViewById(R.id.base_container);
        flMain.addView(statusLayoutManager.getRootLayout());
    }

    /**
     * 设置沉浸式状态栏
     */
    public void initImmersionBar() {

        ImmersionBar.with(this).statusBarDarkFont(true, 0f).init();

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

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
        initData();
    }

    /**
     * 状态切换
     **/
    protected abstract void initLayout();

    protected abstract void initView();

    protected abstract void initData();

//    protected abstract int getLayoutId();

    public void gotoActivity(Class<?> clz) {

        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Object event) {

    }

}
