package com.a360vrsh.library.base.mvp;

import android.content.Context;

import com.a360vrsh.library.base.BaseActivity;
import com.a360vrsh.library.base.BasePresenter;
import com.a360vrsh.library.base.mvp.IView;

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IView {
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
