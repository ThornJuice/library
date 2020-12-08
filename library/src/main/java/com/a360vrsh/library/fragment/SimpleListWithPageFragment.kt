package com.a360vrsh.library.fragment

import android.os.Bundle
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.adapter.SimpleListAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.RecyclerViewUtil
import kotlinx.android.synthetic.main.library_simple_list_with_page_fragment.*

/**
 * 带分页列表的Fragment模板
 * */
class SimpleListWithPageFragment : BaseFragment() {
    private var mAdapter: SimpleListAdapter? = null
    private var page = 1

    companion object {
        private const val TAG = "SimpleListWithPageFragment"

        @JvmStatic
        fun newInstance(param: String) =
            SimpleListWithPageFragment().apply {
                arguments = Bundle().apply {
                    putString("param", param)
                }
            }

        @JvmStatic
        fun newInstance() = SimpleListWithPageFragment()
    }

    override fun getLayoutID(): Int {
        return R.layout.library_simple_list_with_page_fragment
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

        smartRefreshLayout.setOnRefreshListener {
            page = 1
            getData()
        }
        smartRefreshLayout.setOnLoadmoreListener {
            page++
            loadMoreData()
        }


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
        mAdapter?.setNewData(list)
        smartRefreshLayout.finishRefresh()
    }

    private fun loadMoreData() {
        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("texttexttexttexttexttexttexttext")
        }
        mAdapter?.addData(list)
        smartRefreshLayout.finishLoadmore()
    }
}