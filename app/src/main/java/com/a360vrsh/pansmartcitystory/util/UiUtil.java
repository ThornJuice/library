package com.a360vrsh.pansmartcitystory.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.a360vrsh.library.util.ActivityCollector;
import com.a360vrsh.library.util.DoubleClickUtil;
import com.a360vrsh.library.util.MMKVUtil;
import com.a360vrsh.library.util.ScreenUtil;
import com.a360vrsh.pansmartcitystory.MainActivity;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.activity.goods.FoodGoodsDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.goods.OtherGoodsDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.goods.TravelGoodsDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.order.FoodOrderDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.order.FoodRefundDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.order.TravelOrderDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.order.TravelRefundDetailActivity;
import com.a360vrsh.pansmartcitystory.activity.store.AddBaseStoreInfoActivity;
import com.a360vrsh.pansmartcitystory.activity.store.StoreSettingActivity;
import com.a360vrsh.pansmartcitystory.activity.login.LoginActivity;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigButton;
import com.mylhyl.circledialog.params.ButtonParams;
import com.noober.background.drawable.DrawableCreator;
import com.yzq.zxinglibrary.android.CaptureActivity;

/**
 * @author: wxj
 * @date: 2020/10/12
 * @description:
 */
public class UiUtil {
    public static View inflate(Context context, int layoutId) {
        return View.inflate(context, layoutId, null);
    }

    public static void gotoActivity(Context context, Class<?> clz) {
        gotoActivity(context, clz, false, null);
    }

    public static void gotoActivity(Context context, Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(context, clz, isCloseCurrentActivity, null);
    }

    public static void gotoActivity(Context context, Class<?> clz, Bundle ex) {
        gotoActivity(context, clz, false, ex);
    }

    public static void gotoActivity(Context context, Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        if (DoubleClickUtil.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(context, clz);
        if (ex != null) intent.putExtras(ex);
        context.startActivity(intent);
        if (isCloseCurrentActivity) ((Activity) context).finish();
    }

//    public static void showBigImage(Context context, int position, ArrayList<String> imageList) {
//        Bundle bundle = new Bundle();
//        bundle.putStringArrayList("imageUrls", imageList);
//        bundle.putInt("position", position);
//        com.a360vrsh.servicemarket.util.UiUtil.gotoActivity(context, ImageZoomActivity.class, bundle);
//    }

    public static CircleDialog.Builder getDialog(final Context context, String title, String msg) {

        CircleDialog.Builder circleDialog = new CircleDialog.Builder()
                .setTitle(title)
                .setWidth(0.7f)
                .setText(msg)
                .configNegative(new ConfigButton() {
                    @Override
                    public void onConfig(ButtonParams params) {
                        params.height = 45;
                    }
                })
                .configPositive(new ConfigButton() {
                    @Override
                    public void onConfig(ButtonParams params) {
                        params.height = 45;
                    }
                });
        return circleDialog;
    }
    /**
     * 设置页面的透明度
     *
     * @param bgAlpha 1表示不透明
     */
    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        lp.alpha = bgAlpha;
        activity.getWindow().setAttributes(lp);
    }

    public static void setBLBlueBorder(Context context, TextView textView, boolean enabled) {
        setBLBlueBorder(context, textView, 22f, enabled);
    }

    public static void setBLGrayBorder(Context context, TextView textView, boolean enabled) {
        setBLGrayBorder(context, textView, 22f, enabled);
    }

    public static void setBLBlueBorder(Context context, TextView textView, float radius, boolean enabled) {
        textView.setTextColor(ContextCompat.getColor(context, R.color.mainColor));
        textView.setBackground(new DrawableCreator.Builder()
                .setSolidColor(ContextCompat.getColor(context, R.color.library_white))
                .setCornersRadius(ScreenUtil.dip2px(context, radius))
                .setStrokeWidth(ScreenUtil.dip2px(context, 1f))
                .setStrokeColor(ContextCompat.getColor(context, R.color.mainColor))
                .build());
        textView.setEnabled(enabled);
    }

    public static void setBLGrayBorder(Context context, TextView textView, float radius, boolean enabled) {
        textView.setTextColor(ContextCompat.getColor(context, R.color.library_text_999));
        textView.setBackground(new DrawableCreator.Builder()
                .setSolidColor(ContextCompat.getColor(context, R.color.library_white))
                .setCornersRadius(ScreenUtil.dip2px(context, radius))
                .setStrokeWidth(ScreenUtil.dip2px(context, 1f))
                .setStrokeColor(ContextCompat.getColor(context, R.color.library_E1E1E1))
                .build());
        textView.setEnabled(enabled);
    }

    public static void setBLBlueSolid(Context context, TextView textView, float radius, boolean enabled) {
        textView.setTextColor(ContextCompat.getColor(context, R.color.library_white));
        textView.setBackground(new DrawableCreator.Builder()
                .setSolidColor(ContextCompat.getColor(context, R.color.mainColor))
                .setPressedSolidColor(ContextCompat.getColor(context, R.color.mainColorDark), ContextCompat.getColor(context, R.color.mainColor))
                .setCornersRadius(ScreenUtil.dip2px(context, radius))
                .build());
        textView.setEnabled(enabled);
    }

    public static void setBLGraySolid(Context context, TextView textView, float radius, boolean enabled) {
        textView.setTextColor(ContextCompat.getColor(context, R.color.library_text_999));
        textView.setBackground(new DrawableCreator.Builder()
                .setSolidColor(ContextCompat.getColor(context, R.color.unable_gray))
                .setCornersRadius(ScreenUtil.dip2px(context, radius))
                .build());
        textView.setEnabled(enabled);
    }

    public static void goMain(Context context, String status, String storeType) {

        if (!TextUtils.equals("0", status)) {//非审核中跳转到首页
            gotoActivity(context, MainActivity.class);
        } else {
            if (TextUtils.equals(storeType, "0")) {//未填写第一步
                gotoActivity(context, AddBaseStoreInfoActivity.class);
            } else {//跳转到第二步
                Bundle bundle = new Bundle();
                bundle.putString("type", storeType);
                gotoActivity(context, StoreSettingActivity.class, bundle);
            }
        }

    }

    /**
     * 跳转到商品详情
     */
    public static void goGoodsDetail(Context context, String goodsId, String storeType) {

        Bundle bundle = new Bundle();
        bundle.putString("id", goodsId);
        if (TextUtils.equals(storeType, "1")) {//美食
            gotoActivity(context, FoodGoodsDetailActivity.class, bundle);
        } else if (TextUtils.equals(storeType, "3")) {//旅游
            gotoActivity(context, TravelGoodsDetailActivity.class, bundle);
        } else {//其他
            gotoActivity(context, OtherGoodsDetailActivity.class, bundle);
        }


    }

    /**
     * 跳转到订单详情
     */
    public static void goOrderDetail(Context context, String orderId, String storeType, String lmmProductId) {

        Bundle bundle = new Bundle();
        bundle.putString("id", orderId);
        bundle.putBoolean("isLMM", !TextUtils.isEmpty(lmmProductId));
        if (TextUtils.equals(storeType, "1")) {//美食
            gotoActivity(context, FoodOrderDetailActivity.class, bundle);
        } else if (TextUtils.equals(storeType, "3")) {//旅游
            gotoActivity(context, TravelOrderDetailActivity.class, bundle);
        }

    }

    /**
     * 跳转到售后详情
     */
    public static void goRefundDetail(Context context, String orderId, String storeType) {

        Bundle bundle = new Bundle();
        bundle.putString("id", orderId);
        if (TextUtils.equals(storeType, "1")) {//美食
            gotoActivity(context, FoodRefundDetailActivity.class, bundle);
        } else if (TextUtils.equals(storeType, "3")) {//旅游
            gotoActivity(context, TravelRefundDetailActivity.class, bundle);
        }

    }

    /**
     * 跳转到扫码页面
     */
    public static void goQrCodeActivity(Activity activity) {

        Intent intent = new Intent(activity, CaptureActivity.class);
        activity.startActivityForResult(intent, 1000);

    }

    /**
     * 清空栈内activity并跳转到登录
     */
    public static void goLogin(Context context) {

        MMKVUtil.clearLoginInfo();//清除本地保存的登录信息
        ActivityCollector.finishAll();
        gotoActivity(context, LoginActivity.class);

    }
}
