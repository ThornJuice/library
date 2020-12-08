package com.a360vrsh.library.util;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author: wxj
 * @date: 2020/10/17
 * @description:
 */
public class WebViewUtil {
    public static String getHtmlData(String bodyHTML) {
        // 适配image和table标签

//        String head = "<head>"
//                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
//                + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
//                + "<style>table{max-width: 100%; width:auto; height:auto;}</style>"
//                + "<style>video{max-width: 100%; width:auto; height:auto;}</style>"
//                + "</head>";

        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:auto; height:auto; vertical-align: top}</style>"
                + "<style>table{max-width: 100%; width:auto; height:auto;}</style>"
                + "<style>video{max-width: 100%; width:auto; height:auto;}</style>"
                + "<style>body{word-break: break-all;}</style>"
                + "<style>p:empty{display: none!important;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";

    }

    public static void webSetting(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setAppCacheEnabled(false);
        webSettings.setSupportZoom(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(false);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setGeolocationEnabled(true);
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT <= 18) {
            webSettings.setSavePassword(false);
        }
        webSettings.setSaveFormData(false);
        webSettings.setSupportMultipleWindows(false);

    }
}
