package com.a360vrsh.pansmartcitystory.activity.user

import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.pansmartcitystory.R

/**
 *意见反馈
 * */
class FeedBackActivity : BaseTitleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_feed_back
    }

    override fun initView() {
        titleText.text = "意见反馈"
    }


    override fun initListener() {

    }

    override fun initObserver() {

    }

    override fun initData() {
    }

}