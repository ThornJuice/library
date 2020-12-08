package com.a360vrsh.pansmartcitystory.fragment

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.base.BaseLazyFragment
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.EvaluateListAdapter
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.viewmodel.order.EvaluateViewModel
import com.iarcuschin.simpleratingbar.SimpleRatingBar
import kotlinx.android.synthetic.main.fragment_evaluate_list.*

/**
 * 评价列表
 * */
class EvaluateListFragment : BaseLazyFragment() {
    private lateinit var viewModel: EvaluateViewModel
    private var mAdapter: EvaluateListAdapter? = null
    private var page = 1
    private var ratingBar: SimpleRatingBar? = null
    private var tvScore: TextView? = null

    companion object {
        @JvmStatic
        fun newInstance() = EvaluateListFragment()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_evaluate_list
    }

    override fun initView() {
        viewModel = initViewModel(EvaluateViewModel::class.java) as EvaluateViewModel


        RecyclerViewUtil.setVerticalManager(requireContext(), recyclerView)
        mAdapter = EvaluateListAdapter(null)
//        mAdapter?.setOnItemChildClickListener { adapter, view, position ->  }
        recyclerView?.adapter = mAdapter
        val headView = UiUtil.inflate(requireContext(), R.layout.layout_evaluate_head)
        ratingBar = headView.findViewById<SimpleRatingBar>(R.id.rating_bar)
        tvScore = headView.findViewById<TextView>(R.id.tv_score)
        mAdapter?.addHeaderView(headView)

        smartRefreshLayout.setOnRefreshListener {
            page = 1
            getOrderList()
        }
        smartRefreshLayout.setOnLoadmoreListener {
            page++
            getOrderList()
        }

    }

    override fun lazyLoad() {
        viewModel.getStoreInfo(requireContext(), MMKVUtil.getStoreId(), true)

        getOrderList()
    }

    @SuppressLint("SetTextI18n")
    override fun initObserver() {

        //获取店铺信息回调
        viewModel.storeInfoLiveData.observe(this, Observer {
            try {
                ratingBar?.rating = it.data.evaluation_average.toFloat()
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            tvScore?.text = it.data.evaluation_average + "分"

        })

        viewModel.evaluateListLiveData.observe(this, Observer {
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

    override fun initListener() {
        mAdapter?.setOnItemClickListener { adapter, view, position ->


        }
    }



    private fun getOrderList() {

        viewModel.getEvaluateList(requireContext(), MMKVUtil.getStoreId(), "" + page, true)
    }


}