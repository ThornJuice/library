package com.a360vrsh.pansmartcitystory.activity.market

import androidx.lifecycle.Observer
import com.a360vrsh.library.adapter.SimpleListAdapter
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.RedPacketListAdapter
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.viewmodel.market.RedPacketListViewModel
import kotlinx.android.synthetic.main.activity_red_packet_list.*

/**
 *我的红包
 * */
class RedPacketListActivity : BaseTitleActivity() {
    private val viewModel: RedPacketListViewModel by lazy {
        initViewModel(RedPacketListViewModel::class.java) as RedPacketListViewModel
    }
    private var mAdapter: RedPacketListAdapter? = null
    private var page = 1

    override fun getLayoutId(): Int {
        return R.layout.activity_red_packet_list
    }

    override fun initView() {
        titleText.text = "红包管理"
        RecyclerViewUtil.setVerticalManager(getContext(), recyclerView)
        mAdapter = RedPacketListAdapter(null)
//        mAdapter?.setOnItemChildClickListener { adapter, view, position ->  }
        recyclerView?.adapter = mAdapter
    }

    override fun initListener() {
        mAdapter?.setOnItemClickListener { adapter, view, position ->


        }
        smartRefreshLayout.setOnRefreshListener {
            page = 1
            getData()
        }
        smartRefreshLayout.setOnLoadmoreListener {
            page++
            getData()
        }
    }

    override fun initObserver() {
        viewModel.redPacketListLiveData.observe(this, Observer {
            if (page == 1) {
                mAdapter?.setNewData(it.data)
                mAdapter?.setEmptyView(R.layout.library_view_empty_data, recyclerView)
            } else {
                mAdapter?.addData(it.data)
            }

            it.data?.run {
                smartRefreshLayout.isEnableLoadmore = this.size >= 10
            }
            smartRefreshLayout.finishRefresh()
            smartRefreshLayout.finishLoadmore()
        })
    }

    override fun initData() {
        getData()
    }


    private fun getData() {
        viewModel.getDataList(getContext(), "" + page, true)
    }
}