package com.a360vrsh.library.fragment

import android.os.Bundle
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.adapter.SimpleListAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.RecyclerViewUtil
import kotlinx.android.synthetic.main.library_simple_list.*

/**
 * 带list的Fragment模板
 * */
class SimpleListFragment : BaseFragment() {
    private var mAdapter: SimpleListAdapter? = null

    companion object {
        private const val TAG = "SimpleListFragment"

        @JvmStatic
        fun newInstance() =
            SimpleListFragment().apply {
                arguments = Bundle().apply {
//                    putString("ARG_PARAM1", param1)

                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.library_simple_list
    }

    override fun initView() {
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
        RecyclerViewUtil.setVerticalManager(getContext(), recyclerView)
        mAdapter = SimpleListAdapter(null)
//        mAdapter?.setOnItemChildClickListener { adapter, view, position ->  }
        recyclerView?.adapter = mAdapter
    }

    override fun initListener() {
        mAdapter?.setOnItemClickListener { adapter, view, position ->


        }
    }
    override fun initObserver() {

    }
    override fun initData() {
        getData()
    }

    override fun initImmersionBar() {
//        ImmersionBar.with(context as Activity)
//            .statusBarColor(R.color.library_white)
//            .statusBarDarkFont(true)
//            .init()
    }

    private fun getData() {
        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("texttexttexttexttexttexttexttext")
        }
        mAdapter?.addData(list)
    }
}