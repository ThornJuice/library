package com.a360vrsh.library.util;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.a360vrsh.baselibrary.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

/**
 * @author: wxj
 * @date: 2020/10/9
 * @description:
 */
public class ImageLoaderUtil {

    public static void displayImage(Context context, String url, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) {
                LogUtil.e("ImageLoaderUtil", "Activity isDestroyed");
                return;
            }
        }
        DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        RequestOptions requestOptions =
                new RequestOptions()
                        .error(R.color.library_f5)
                        .placeholder(R.color.library_f5);
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
//                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .into(imageView);
    }

    public static void displayImage(Context context, @DrawableRes int res, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) {
                LogUtil.e("ImageLoaderUtil", "Activity isDestroyed");
                return;
            }
        }
        DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
        RequestOptions requestOptions =
                new RequestOptions()
                        .error(R.color.library_f5)
                        .placeholder(R.color.library_f5);
        Glide.with(context)
                .load(res)
                .apply(requestOptions)
//                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .into(imageView);
    }

    public static void displayCircleImage(Context context, String url, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) {
                LogUtil.e("ImageLoaderUtil", "Activity isDestroyed");
                return;
            }
        }
        DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
        RequestOptions requestOptions =
                new RequestOptions()
                        .error(R.color.library_f5)
                        .placeholder(R.color.library_f5);
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
//                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .circleCrop()
                .into(imageView);
    }

    public static void displayRoundImage(Context context, String url, ImageView imageView, float radius) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) {
                LogUtil.e("ImageLoaderUtil", "Activity isDestroyed");
                return;
            }
        }
        RoundedCorners roundedCorners = new RoundedCorners(dip2px(context, radius));
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners)
                .error(R.color.library_f5)
                .placeholder(R.color.library_f5);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder) {

        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isDestroyed()) {
                return;
            }
        }
        DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        RequestOptions requestOptions =
                new RequestOptions()
                        .error(R.color.library_f5)
                        .placeholder(placeHolder);
        Glide.with(context)
                .load(url)
//                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .apply(requestOptions)
                .into(imageView);
    }

    public static int dip2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }
}
