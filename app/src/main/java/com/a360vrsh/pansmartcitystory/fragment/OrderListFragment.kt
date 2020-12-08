package com.a360vrsh.pansmartcitystory.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.base.BaseLazyFragment
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.OrderListAdapter
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.viewmodel.order.OrderViewModel
import kotlinx.android.synthetic.main.fragment_order_list.*

/**
 * 订单列表
 * 订单状态status: all=全部,unpaid=待支付,unshipped=待发货,unreceipt=待收货,unused=待使用,complete=已完成,comment=待评价,all_order=全部订单(不包含退款)
 * */
class OrderListFragment : BaseLazyFragment() {
    private lateinit var viewModel: OrderViewModel
    private var mAdapter: OrderListAdapter? = null
    private var status: String? = "all"//
    private var page = 1

    companion object {
        @JvmStatic
        fun newInstance(status: String) =
            OrderListFragment().apply {
                arguments = Bundle().apply {
                    putString("status", status)
                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_order_list
    }

    override fun initView() {
        viewModel = initViewModel(OrderViewModel::class.java) as OrderViewModel

        arguments?.let {
            status = it.getString("status")
        }

        RecyclerViewUtil.setVerticalManager(requireContext(), recyclerView)
        mAdapter = OrderListAdapter(null)
        recyclerView?.adapter = mAdapter

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
        getOrderList()
    }

    override fun initObserver() {
        viewModel.orderListLiveData.observe(this, Observer {
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
                        var lmmProductId: String? = null
                        if (it.goods.isNotEmpty()) {
                            lmmProductId = it.goods[0].lvmama_product_id
                        }
                        UiUtil.goOrderDetail(
                            requireContext(),
                            it.id,
                            it.store?.store_type,
                            lmmProductId
                        )
                    }
                }
            }
        }
    }



    private fun getOrderList() {
        viewModel.getOrderList(requireContext(), status, "" + page, true)
    }

    override fun onEventMainThread(event: EventBean?) {
        event?.let {
            if (it.id == EventID.ORDER_OPERATION_SUCCESS) {
                getOrderList()
            }
        }
    }
}