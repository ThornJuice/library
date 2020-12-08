package com.a360vrsh.library.base.mvp;

import android.content.Context;

import com.a360vrsh.library.base.BasePresenter;
import com.a360vrsh.library.base.BaseStateActivity;

public abstract class BaseStateMvpActivity<P extends BasePresenter> extends BaseStateActivity implements IView {
    protected P mPresenter;

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
