package com.a360vrsh.library.activity

import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.base.BaseActivity
import com.a360vrsh.library.base.BaseTitleActivity

/**
 *空Activity模板
 * */
class EmptyActivity : BaseTitleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.library_activity_empty
    }

    override fun initView() {

    }


    override fun initListener() {
    }
    override fun initObserver() {

    }
    override fun initData() {
    }

}