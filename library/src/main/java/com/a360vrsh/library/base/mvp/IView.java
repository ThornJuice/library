package com.a360vrsh.library.base.mvp;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

public interface IView extends LifecycleOwner {
    void showLoading();

    void dismissLoading();

    Context getContext();
}
