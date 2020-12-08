package com.a360vrsh.pansmartcitystory.activity.goods

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import com.a360vrsh.library.activity.LocalWebViewActivity
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.AttributeAdapter
import com.a360vrsh.pansmartcitystory.adapter.GoodsDetailImageAdapter
import com.a360vrsh.pansmartcitystory.adapter.SpecAdapter
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean
import com.a360vrsh.pansmartcitystory.util.*
import com.a360vrsh.pansmartcitystory.viewmodel.goods.GoodsDetailViewModel
import kotlinx.android.synthetic.main.activity_food_goods_detail.*
import kotlinx.android.synthetic.main.activity_food_goods_detail.ll_bottom_group
import kotlinx.android.synthetic.main.layout_goods_detail_bottom.*
import org.greenrobot.eventbus.EventBus

/**
 * 商品详情-美食
 * */
class FoodGoodsDetailActivity : BaseTitleActivity() {

    private val viewModel: GoodsDetailViewModel by lazy {
        initViewModel(GoodsDetailViewModel::class.java) as GoodsDetailViewModel
    }

    private var imageAdapter: GoodsDetailImageAdapter? = null
    private var attributeAdapter: AttributeAdapter? = null
    private var specAdapter: SpecAdapter? = null
    private var goodsDetailBean: GoodsDetailBean.DataBean? = null
    private var goodsId: String? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_food_goods_detail
    }

    override fun initView() {

        titleText.text = "商品详情"
        tvRight.text = "编辑"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

        imageAdapter = GoodsDetailImageAdapter(null)
        RecyclerViewUtil.setGridRecycleView(getContext(), rv_images, 3, imageAdapter)

        attributeAdapter = AttributeAdapter(null)
        RecyclerViewUtil.setVerticalRecycleView(getContext(), rv_attribute, attributeAdapter)

        specAdapter = SpecAdapter(null)
        RecyclerViewUtil.setVerticalRecycleView(getContext(), rv_spec, specAdapter)

    }


    override fun initListener() {

        //商品编辑
        llRight.setOnClickListener {
            goodsId?.let {
                val bundle = Bundle()
                bundle.putString("id", it)
                bundle.putString("type", MMKVUtil.getStoreType())
                gotoActivity(EditGoodsActivity::class.java, false, bundle)
            }
        }
        //上架/下架
        tv_operation.setOnClickListener {
            val action = tv_operation.text.toString()
            if (action == "上架") {
                goodsStart()
            } else if (action == "下架") {
                goodsStop()
            }
        }
        //删除商品
        tv_delete.setOnClickListener {
            goodsDelete()
        }
        tv_go_detail.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("title", "图文详情")
            bundle.putString("content", goodsDetailBean?.toruism?.product)
            gotoActivity(LocalWebViewActivity::class.java, false, bundle)
        }
    }

    override fun initObserver() {
        viewModel.goodsDetailLiveData.observe(this, Observer {
            goodsDetailBean = it.data
            setUiData(it.data)
        })
        viewModel.operationSuccessLiveData.observe(this, Observer {

            showToast("操作成功")
            goodsId?.let {
                viewModel.getGoodsDetail(getContext(), it, MMKVUtil.getStoreId(), true)
                EventBus.getDefault().post(EventBean(EventID.GOODS_OPERATION_SUCCESS))
            }
        })
        viewModel.deleteSuccessLiveData.observe(this, Observer {

            showToast("删除成功")
            EventBus.getDefault().post(EventBean(EventID.GOODS_OPERATION_SUCCESS))
            finish()
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setUiData(data: GoodsDetailBean.DataBean?) {
        data?.let {
            handleStatus(it.status_audit, it.status_shelf)

            tv_goods_name.text = it.title
            tv_goods_code.text = it.gs1_code
            tv_goods_class.text = it.class_name
            tv_share_describe.text = it.describe
            tv_sale_price.text = "¥ " + it.price
            tv_market_price.text = "¥ " + it.price_origin
            tv_price_cost.text = "¥ " + it.price_cost
            tv_packing_cost.text = "¥ " + it.packing_cost

            imageAdapter?.setNewData(it.images)
            if (it.attribute.isNullOrEmpty()) {
                ll_spec_group.setGone()
            } else {
                ll_spec_group.setVisible()
                attributeAdapter?.setNewData(it.attribute)
                specAdapter?.setNewData(it.specs)
            }

        }
    }

    override fun initData() {
        goodsId = intent.getStringExtra("id")
        goodsId?.let {
            viewModel.getGoodsDetail(getContext(), it, MMKVUtil.getStoreId(), true)
        }

    }
    /**
     * 商品上架
     */
    private fun goodsStart() {
        goodsId?.let {
            viewModel.goodsStart(
                getContext(),
                it, MMKVUtil.getStoreId(), true
            )
        }
    }

    /**
     * 商品下架
     */
    private fun goodsStop() {
        goodsId?.let {
            viewModel.goodsStop(
                getContext(),
                it, MMKVUtil.getStoreId(), true
            )
        }
    }
    /**
     * 删除商品
     */
    private fun goodsDelete() {
        UiUtil.getDialog(this@FoodGoodsDetailActivity, "提示", "确定删除该商品？")
            .setPositive("确定") { v ->
                goodsId?.let {
                    viewModel.goodsDelete(
                        getContext(),
                        it, MMKVUtil.getStoreId(), true
                    )
                }

            }
            .setNegative("取消") { v -> }
            .show(supportFragmentManager)
    }

    /**
     * 商品状态处理
     *@param statusAudit 0 编辑中 1审核中 2审核通过 3审核拒绝 4 审核中
     *@param statusShelf 1上架 2下架
     *@describe
     * 审核通过，未上架的可上架已上架的可下架
     * 不在上架状态可删除
     * 审核中不能编辑
     * 再次编辑触发审核后变为已下架
     * 编辑中无法上架
     * 编辑中状态归为待审核，编辑中可以编辑
     * 审核失败可以编辑
     * */
    private fun handleStatus(statusAudit: String?, statusShelf: String?) {
        when (statusAudit) {
            "0" -> {
                llRight.setVisible()
                ll_bottom_group.setVisible()
                tv_operation.setGone()
                tv_delete.setVisible()
            }
            "1", "4" -> {
                llRight.setGone()
                ll_bottom_group.setGone()
            }
            "2" -> {
                llRight.setVisible()
                ll_bottom_group.setVisible()
                tv_operation.setVisible()
                if (statusShelf == "1") {
                    tv_operation.text = "下架"
                    tv_delete.setGone()
                } else if (statusShelf == "2") {
                    tv_operation.text = "上架"
                    tv_delete.setVisible()
                }
            }
            "3" -> {
                llRight.setVisible()
                ll_bottom_group.setVisible()
                tv_operation.setGone()
                tv_delete.setVisible()
            }
            else -> {
                llRight.setGone()
                ll_bottom_group.setGone()
            }
        }
    }
    override fun onEventMainThread(event: EventBean?) {
        event?.let {
            if (it.id == EventID.GOODS_EDIT_SUCCESS) {
                goodsId?.let {
                    viewModel.getGoodsDetail(getContext(), it, MMKVUtil.getStoreId(), true)
                }
            }
        }
    }
}