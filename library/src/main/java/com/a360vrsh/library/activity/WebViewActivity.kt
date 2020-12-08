package com.a360vrsh.library.activity

import android.graphics.Bitmap
import android.os.Build
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.LoadingUtil
import com.a360vrsh.library.util.LogUtil
import kotlinx.android.synthetic.main.activity_local_web_view.*

class WebViewActivity : BaseTitleActivity() {
    private var webView: WebView? = null
    private var url: String? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_local_web_view
    }

    override fun initView() {
        webView = WebView(this@WebViewActivity)
        mViewContainer.addView(webView)
        webView?.let {
            it.webChromeClient = getWebChromeClient()
            it.webViewClient = getWebViewClient()
            webSetting(it)
        }
    }


    override fun initListener() {
    }

    override fun initObserver() {

    }

    override fun initData() {
        url = intent.getStringExtra("url")
        LogUtil.e("WebViewActivity", url)

        webView?.loadUrl(url)
    }

    private fun getWebChromeClient(): WebChromeClient {
        return object : WebChromeClient() {

        }

    }

    private fun getWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                LoadingUtil.showLoading(this@WebViewActivity)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                LoadingUtil.disMissLoading()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (webView != null) {
            webView?.clearCache(false)
            mViewContainer.removeAllViews()
            webView = null
        }
    }

    fun webSetting(webView: WebView) {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true //将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小
        webSettings.builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件
        webSettings.setAppCacheEnabled(false)
        webSettings.setSupportZoom(true)
        webSettings.domStorageEnabled = false
        webSettings.databaseEnabled = false
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.setGeolocationEnabled(true)
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8" //设置编码格式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webSettings.mediaPlaybackRequiresUserGesture = false
        }
        if (Build.VERSION.SDK_INT <= 18) {
            webSettings.savePassword = false
        }
        webSettings.saveFormData = false
        webSettings.setSupportMultipleWindows(false)
    }

}