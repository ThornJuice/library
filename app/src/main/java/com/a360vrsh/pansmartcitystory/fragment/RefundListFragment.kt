package com.a360vrsh.pansmartcitystory.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.base.BaseLazyFragment
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.RefundListAdapter
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.viewmodel.order.RefundViewModel
import kotlinx.android.synthetic.main.fragment_order_list.*

/**
 * 售后列表
 * 订单状态:all=全部,under_review=审核中,review_success=同意退款,review_fail=拒绝退款
 * */
class RefundListFragment : BaseLazyFragment() {
    private lateinit var viewModel: RefundViewModel
    private var mAdapter: RefundListAdapter? = null
    private var status: String? = "all"//
    private var page = 1

    companion object {
        @JvmStatic
        fun newInstance(status: String) =
            RefundListFragment().apply {
                arguments = Bundle().apply {
                    putString("status", status)
                }
            }

        @JvmStatic
        fun newInstance() = RefundListFragment()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_order_list
    }

    override fun initView() {
        viewModel = initViewModel(RefundViewModel::class.java) as RefundViewModel

        arguments?.let {
            status = it.getString("status")
        }

        RecyclerViewUtil.setVerticalManager(requireContext(), recyclerView)
        mAdapter = RefundListAdapter(null)
//        mAdapter?.setOnItemChildClickListener { adapter, view, position ->  }
        recyclerView?.adapter = mAdapter

        smartRefreshLayout.setOnRefreshListener {
            page = 1
            getRefundList()
        }
        smartRefreshLayout.setOnLoadmoreListener {
            page++
            getRefundList()
        }

    }

    override fun lazyLoad() {
        getRefundList()
    }

    override fun initObserver() {
        viewModel.refundListLiveData.observe(this, Observer {
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
        mAdapter?.apply {
            setOnItemChildClickListener { _, v, position ->
                val item = this.getItem(position)
                if (v.id == R.id.tv_one_btn) {


                } else if (v.id == R.id.tv_two_btn) {

                    item?.let {
//                        var lmmProductId: String? = null
//                        if (it.goods.isNotEmpty()) {
//                            lmmProductId = it.goods[0].lvmama_product_id
//                        }
                        UiUtil.goRefundDetail(
                            requireContext(),
                            it.id,
                            it.store?.store_type
                        )
                    }
                }
            }
        }
    }



    private fun getRefundList() {
        viewModel.getRefundList(requireContext(), status, "" + page, true)
    }


}