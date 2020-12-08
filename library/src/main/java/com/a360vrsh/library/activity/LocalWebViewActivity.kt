package com.a360vrsh.library.activity

import android.webkit.WebView
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.WebViewUtil
import kotlinx.android.synthetic.main.activity_local_web_view.*

class LocalWebViewActivity : BaseTitleActivity() {

    private var webView: WebView? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_local_web_view
    }

    override fun initView() {

        webView = WebView(this@LocalWebViewActivity)
        mViewContainer.addView(webView)
    }


    override fun initListener() {
    }

    override fun initObserver() {

    }

    override fun initData() {
        titleText.text = intent.getStringExtra("title")

        webView?.loadDataWithBaseURL(
            null,
            WebViewUtil.getHtmlData(intent.getStringExtra("content")),
            "text/html",
            "utf-8",
            null
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        if (webView != null) {
            webView?.clearCache(false)
            mViewContainer.removeAllViews()
            webView = null
        }
    }
}