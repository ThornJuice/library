package com.a360vrsh.library.base.mvp;


import com.a360vrsh.library.base.BaseFragment;
import com.a360vrsh.library.base.BasePresenter;

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IView {
    protected P mPresenter;

    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

}
