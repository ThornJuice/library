package com.a360vrsh.library.activity

import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.base.BaseActivity
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.fragment.EmptyFragment

/**
 *带一个空fragment的Activity模板
 * */
class EmptyFragmentInActivity : BaseTitleActivity() {
    private var fragment: EmptyFragment? = null
    override fun getLayoutId(): Int {
        return R.layout.library_empty_fragment_in_activity
    }

    override fun initView() {
        val fTransaction = supportFragmentManager.beginTransaction()
        if (fragment == null) {
            fragment = EmptyFragment.newInstance()
            fTransaction.add(R.id.fl_container, fragment!!)
        } else {
            fTransaction.show(fragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }

    override fun initListener() {
    }
    override fun initObserver() {

    }
    override fun initData() {
    }


}