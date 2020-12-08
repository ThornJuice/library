package com.a360vrsh.pansmartcitystory.fragment

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseLazyFragment
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.GoodsListAdapter
import com.a360vrsh.pansmartcitystory.adapter.LeftClassifyAdapter
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.goods.GoodsViewModel
import kotlinx.android.synthetic.main.fragment_goods_list.*
import org.greenrobot.eventbus.EventBus

/**
 * 我的商品列表
 * */
class GoodsListFragment : BaseLazyFragment() {

    private lateinit var viewModel: GoodsViewModel

    private var mClassifyAdapter: LeftClassifyAdapter? = null
    private var mAdapter: GoodsListAdapter? = null
    private var page = 1
    private var status_audit: String? = null//审核状态:0=编辑中,1=提交审核(审核中),2=审核通过,3=审核拒绝 4审核中
    private var status_shelf: String? = null//上架状态:1=上架,2=下架
    private var classId: String? = ""//分类id


    companion object {
        @JvmStatic
        fun newInstance(status_audit: String, status_shelf: String) =
            GoodsListFragment().apply {
                arguments = Bundle().apply {
                    putString("status_audit", status_audit)
                    putString("status_shelf", status_shelf)
                }
            }

        @JvmStatic
        fun newInstance() = GoodsListFragment()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_goods_list
    }

    override fun initView() {
        viewModel = initViewModel(GoodsViewModel::class.java) as GoodsViewModel

        arguments?.let {
            status_audit = it.getString("status_audit")
            status_shelf = it.getString("status_shelf")
        }
        RecyclerViewUtil.setVerticalManager(requireContext(), rv_left)
        mClassifyAdapter = LeftClassifyAdapter(null)
        rv_left?.adapter = mClassifyAdapter

        RecyclerViewUtil.setVerticalManager(requireContext(), rv_right)
        mAdapter = GoodsListAdapter(null)
        rv_right?.adapter = mAdapter

        smartRefreshLayout.setOnRefreshListener {
            page = 1
            getGoodsList()
        }
        smartRefreshLayout.setOnLoadmoreListener {
            page++
            getGoodsList()
        }


    }


    override fun initListener() {
        mClassifyAdapter?.apply {
            setOnItemClickListener { adapter, view, position ->
                val item = getItem(position)
                setPosition(position)

                classId = item?.id
                page = 1
                //获取商品列表
                getGoodsList()
            }
        }
        mAdapter?.apply {
            setOnItemChildClickListener { _, v, position ->
                val item = this.getItem(position)
                if (v.id == R.id.tv_one_btn) {
                    if ((v as TextView).text.toString() == "上架") {
                        item?.id?.let {
                            goodsStart(it)
                        }
                    } else if (v.text.toString() == "下架") {
                        item?.id?.let {
                            goodsStop(it)
                        }
                    }

                } else if (v.id == R.id.tv_two_btn) {
                    item?.let {
                        UiUtil.goGoodsDetail(requireContext(), it.id, MMKVUtil.getStoreType())
                    }
                }
            }
        }


    }

    override fun initObserver() {
        viewModel.goodsClassLiveData.observe(this, Observer {

            mClassifyAdapter?.setNewData(it.data)

            it.data?.run {
                if (this.size > 0) {
                    classId = this[0].id
                    page = 1
                    getGoodsList()
                }
            }

        })
        viewModel.goodsListLiveData.observe(this, Observer {

            if (page == 1) {
                mAdapter?.setNewData(it.data)
                mAdapter?.setEmptyView(R.layout.library_view_empty_data, rv_right)
            } else {
                mAdapter?.addData(it.data)
            }

            it.data?.run {
                smartRefreshLayout.isEnableLoadmore = this.size >= 10
            }
            smartRefreshLayout.finishRefresh()
            smartRefreshLayout.finishLoadmore()
        })
        viewModel.successLiveData.observe(this, Observer {

            showToast("操作成功")
            EventBus.getDefault().post(EventBean(EventID.GOODS_OPERATION_SUCCESS))

        })
    }

    override fun lazyLoad() {
        //获取商品分类
        viewModel.getGoodsClass(requireContext(), MMKVUtil.getStoreId(), true)

    }


    private fun getGoodsList() {
        viewModel.getGoodsList(
            requireContext(),
            MMKVUtil.getStoreId(),
            classId,
            status_audit,
            status_shelf, "" + page, true
        )
    }

    /**
     * 商品下架
     */
    private fun goodsStop(id: String) {

        UiUtil.getDialog(requireContext(), "提示", "确定将此商品下架？")
            .setPositive("确定") { v ->
                viewModel.goodsStop(
                    requireContext(),
                    id, MMKVUtil.getStoreId(), true
                )
            }
            .setNegative("取消") { v -> }
            .show(fragmentManager)
    }

    /**
     * 商品上架
     */
    private fun goodsStart(id: String) {

        viewModel.goodsStart(
            requireContext(),
            id, MMKVUtil.getStoreId(), true
        )
    }

    override fun onEventMainThread(event: EventBean?) {
        event?.let {
            if (it.id == EventID.GOODS_OPERATION_SUCCESS || it.id == EventID.GOODS_EDIT_SUCCESS) {
                getGoodsList()
            }
        }
    }
}