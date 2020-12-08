package com.a360vrsh.library.http;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;

import com.a360vrsh.library.arouter.ARouterConstant;
import com.a360vrsh.library.arouter.ARouterUtils;
import com.a360vrsh.library.util.ActivityCollector;
import com.a360vrsh.library.util.LoadingUtil;
import com.a360vrsh.library.util.MMKVUtil;
import com.a360vrsh.library.util.ToastUtil;
import com.a360vrsh.library.util.UrlConstant;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigButton;
import com.mylhyl.circledialog.params.ButtonParams;
import com.rxjava.rxlife.RxLife;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.functions.Consumer;
import rxhttp.RxHttp;

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description:
 */
public class HttpUtil {


    private HttpUtil() {

    }

    /**
     * get请求
     *
     * @param context
     * @param url
     * @param paramMap
     * @param httpListener
     * @param showLoading
     */
    public static void get(Context context, String url, HashMap<String, String> paramMap, HttpListener httpListener, boolean showLoading) {

        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        RxHttp.get(url)
                .addAll(paramMap)
                .asString()
                .doFinally(() -> {
                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }

                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败
                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * post请求
     *
     * @param context
     * @param url
     * @param paramMap
     * @param httpListener
     * @param showLoading
     */
    public static void post(Context context, String url, HashMap<String, String> paramMap, HttpListener httpListener, final boolean showLoading) {


        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        RxHttp.postForm(url)
                .addAll(paramMap)
                .asString()
                .doFinally(() -> {

                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }
                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败
                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * put请求
     *
     * @param context
     * @param url
     * @param paramMap
     * @param httpListener
     * @param showLoading
     */
    public static void put(Context context, String url, HashMap<String, String> paramMap, HttpListener httpListener, final boolean showLoading) {


        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        RxHttp.putForm(url)
                .addAll(paramMap)
                .asString()
                .doFinally(() -> {

                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }
                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败

                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * delete请求
     *
     * @param context
     * @param url
     * @param paramMap
     * @param httpListener
     * @param showLoading
     */
    public static void delete(Context context, String url, HashMap<String, String> paramMap, HttpListener httpListener, boolean showLoading) {

        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        RxHttp.deleteForm(url)
                .addAll(paramMap)
                .asString()
                .doFinally(() -> {
                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }

                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败
                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * 图片上传
     *
     * @param context
     * @param type
     * @param file
     * @param httpListener
     * @param showLoading
     */
    public static void upLoad(Context context, String type, File file, HttpListener httpListener, boolean showLoading) {

        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        Log.i("upLoadImage", "fileListSize:" + file.getPath());
        RxHttp.postForm(UrlConstant.UPLOAD)
                .add("type", type)
                .addFile("file", file)
                .asString()
                .doFinally(() -> {
                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }

                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败
                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * 批量图片上传
     *
     * @param context
     * @param type
     * @param fileList
     * @param httpListener
     * @param showLoading
     */
    public static void upLoads(Context context, String type, List<File> fileList, HttpListener httpListener, boolean showLoading) {
        Log.i("upLoadImage", "fileListSize:" + fileList.size());
        if (showLoading) {
            LoadingUtil.showLoading((FragmentActivity) context);
        }
        RxHttp.postForm(UrlConstant.UPLOADS)
                .add("type", type)
                .addFile("file", fileList)
                .asString()
                .doFinally(() -> {
                    if (showLoading) {
                        LoadingUtil.disMissLoading();
                    }

                })
                .to(RxLife.toMain((LifecycleOwner) context))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String resonse) throws Throwable {//网络请求成功
                        handleSuccess(context, resonse, httpListener);
                    }
                }, new OnError() {
                    @Override
                    public void onError(ErrorInfo errorInfo) throws Exception {//网络请求失败
                        handleFailed(context, errorInfo, httpListener);
                    }
                });


    }

    /**
     * 处理业务code
     */
    private static void handleSuccess(Context context, String response, HttpListener httpListener) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            int errorCode = jsonObject.optInt("errcode");
            String errorMsg = jsonObject.optString("errmsg");
//            LogUtil.e("handleSuccess", errorMsg);
            if (errorCode == 0) {//业务请求成功
                httpListener.onSucceed(response);
            } else if (errorCode == 3001 && "TGT不合法".equals(errorMsg)) {//登录过期
                goLogin(context);
            } else {
                httpListener.onFailed(errorMsg);
                ToastUtil.show(errorMsg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * 处理业务code
     */
    private static void handleFailed(Context context,ErrorInfo errorInfo,HttpListener httpListener) {
        if (errorInfo.getErrorCode() == 433) {//登录过期
            goLogin(context);
        }else{
            ToastUtil.show(errorInfo.getErrorMsg());
            httpListener.onFailed(errorInfo.getErrorCode() + ":" + errorInfo.getErrorMsg());
        }
    }

    private static CircleDialog.Builder circleDialog;

    private static void goLogin(Context context) {
//        ToastUtil.show("goLogin");
//        Intent mIntent = new Intent();
//        mIntent.setClassName(context,"com.a360vrsh.pansmartcitystory.activity.user.LoginActivity");
//        context.startActivity(mIntent);
        MMKVUtil.clearLoginInfo();
        if (circleDialog == null) {
            circleDialog = new CircleDialog.Builder()
                    .setTitle("温馨提示")
                    .setWidth(0.7f)
                    .setCancelable(false)
                    .setText("登录信息已过期，请重新登录!")
                    .setPositive("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityCollector.finishAll();
                            ARouterUtils.navigation(ARouterConstant.ACTIVITY_PERSON_LOGIN);
                        }
                    })
                    .configPositive(new ConfigButton() {
                        @Override
                        public void onConfig(ButtonParams params) {

                            params.height = 45;
                        }
                    });
            circleDialog.show(((FragmentActivity) context).getSupportFragmentManager());
        } else {
            circleDialog.show(((FragmentActivity) context).getSupportFragmentManager());
        }


    }


}
