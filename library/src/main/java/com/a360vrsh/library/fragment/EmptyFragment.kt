package com.a360vrsh.library.fragment

import android.app.Activity
import android.os.Bundle
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.base.BaseFragment
import com.gyf.immersionbar.ImmersionBar

/**
 * 空Fragment模板
 * */
class EmptyFragment : BaseFragment() {

    companion object {
        private const val TAG = "EmptyFragment"

        @JvmStatic
        fun newInstance() =
            EmptyFragment().apply {
                arguments = Bundle().apply {
//                    putString("ARG_PARAM1", param1)

                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.library_empty_fragment
    }

    override fun initView() {
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun initListener() {

    }
    override fun initObserver() {

    }
    override fun initData() {

    }

    override fun initImmersionBar() {
//        ImmersionBar.with(context as Activity)
//            .statusBarColor(R.color.library_white)
//            .statusBarDarkFont(true)
//            .init()
    }

}