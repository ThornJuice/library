package com.a360vrsh.library.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.a360vrsh.library.bean.EventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


public abstract class BaseLazyFragment extends Fragment {
    View view;
    /**
     * 视图是否加载完毕
     */
    private boolean isViewPrepared = false;
    /**
     * 是否已经执行过懒加载
     */
    private boolean isLazyLoaded = false;

    /**
     * 加载布局
     */
    protected abstract int getLayoutID();


    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void lazyLoad();

    protected abstract void initObserver();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutID(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        isViewPrepared = true;
        initView();
        lazyLoadDataIfPrepared();
        initObserver();
        initListener();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared();
        }
    }

    private void lazyLoadDataIfPrepared() {
        if (getUserVisibleHint() && isViewPrepared && !isLazyLoaded) {
            lazyLoad();
            isLazyLoaded = true;
        }
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
