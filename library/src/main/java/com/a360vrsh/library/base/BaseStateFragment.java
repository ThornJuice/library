package com.a360vrsh.library.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.a360vrsh.baselibrary.R;
import com.bumptech.glide.Glide;
import com.ns.yc.ycstatelib.StateLayoutManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


/**
 * basefragment
 */

public abstract class BaseStateFragment extends BaseImmersionFragment {

    public Context context;
    View view;
    protected StateLayoutManager statusLayoutManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initView();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(getLayoutID(), container, false);
        view = inflater.inflate(R.layout.library_base_fragment, container, false);
        initLayout();
        initBaseView(view);
        return view;
    }


    public View getView() {
        return view;
    }

    /**
     * 获取到子布局
     */
    private void initBaseView(View view) {
        LinearLayout flMain = view.findViewById(R.id.base_state_root);
        flMain.addView(statusLayoutManager.getRootLayout());
    }

    /**
     * 状态切换
     **/
    protected abstract void initLayout();

//    protected abstract int getLayoutID();

    protected abstract void initView();


    protected abstract void initData();


    public void gotoActivity(Class<?> clz) {

        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(context, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) ((Activity) context).finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Object event) {

    }
}
