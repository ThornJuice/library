package com.a360vrsh.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.a360vrsh.library.bean.EventBean;
import com.a360vrsh.library.util.DoubleClickUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


/**
 * basefragment
 */

public abstract class BaseFragment extends BaseImmersionFragment {
    View view;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initView();
        initListener();
        initObserver();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutID(), container, false);
        return view;
    }


    public View getView() {


        return view;
    }

    protected abstract int getLayoutID();

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

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        if (DoubleClickUtil.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(requireContext(), clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) (requireActivity()).finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBean event) {

    }

    protected ViewModel initViewModel(Class<? extends ViewModel> modelClass) {
        return ViewModelProviders.of(this).get(modelClass);
    }
}
