package com.a360vrsh.library.base.mvp;


import com.a360vrsh.library.base.BasePresenter;
import com.a360vrsh.library.base.BaseStateFragment;

public abstract class BaseStateMvpFragment<P extends BasePresenter> extends BaseStateFragment implements IView {
    protected P mPresenter;

    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

}
