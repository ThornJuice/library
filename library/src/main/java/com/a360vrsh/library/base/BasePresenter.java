package com.a360vrsh.library.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.a360vrsh.library.base.mvp.IModel;
import com.a360vrsh.library.base.mvp.IPresenter;
import com.a360vrsh.library.base.mvp.IView;

import java.lang.reflect.ParameterizedType;


public class BasePresenter<M extends IModel, V extends IView> implements IPresenter, LifecycleObserver {
    protected final String TAG = this.getClass().getSimpleName();
    protected M mModel;
    protected V mView;

    public BasePresenter(V view) {
        this.mView = view;
        this.mModel = newModel();
        init();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private  void onCreate() {
//        Logger.d(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
//        Logger.d(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
//        Logger.d(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
//        Logger.d(TAG, "onDestroy" );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy(LifecycleOwner owner) {
        //        Logger.d(TAG, "onDestroy");
        owner.getLifecycle().removeObserver(this);
        mView = null;

    }

    @Override
    public void init() {
        if (mView != null && mView instanceof LifecycleOwner) {
            ((LifecycleOwner) mView).getLifecycle().addObserver(this);
            if (mModel != null) {
                ((LifecycleOwner) mView).getLifecycle().addObserver(mModel);
            }
        }
    }

    private M newModel() {
        M newModel;
        try {
            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<M> clazz = (Class<M>) pt.getActualTypeArguments()[0];
            // 通过反射创建model的实例
            newModel = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newModel;
    }
    /**
     * 判断activity或fragment是否为空
     * */
    protected boolean checkView(){
        return mView != null;
    }
}
