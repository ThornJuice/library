package com.a360vrsh.library.base;

import android.app.Application;
import android.content.Context;
import android.util.Config;

import androidx.multidex.MultiDex;

import com.a360vrsh.library.http.RxHttpManager;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Describe：基础Application，所有需要模块化开发的module都需要继承自此BaseApplication。
 */
public class BaseApplication extends Application {
    public static final boolean DEBUG = true;
    //全局唯一的context
    private static BaseApplication instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
        //MultiDexf分包初始化，必须最先初始化
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        RxHttpManager.init(this, true);
    }


    /**
     * 初始化路由
     */
    protected void initARouter() {
        if (DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);// 尽可能早，推荐在Application中初始化
    }

    /**
     * 获取全局唯一上下文
     *
     * @return BaseApplication
     */
    public static BaseApplication getInstance() {
        return instance;
    }

}
