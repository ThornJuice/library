package com.a360vrsh.pansmartcitystory.activity.order

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.IntentUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.library.widget.CheckCodeView
import com.a360vrsh.library.widget.CommonPopupWindow
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.common.MapAddressActivity
import com.a360vrsh.pansmartcitystory.adapter.FoodOrderDetailGoodsAdapter
import com.a360vrsh.pansmartcitystory.bean.FoodOrderDetailBean
import com.a360vrsh.pansmartcitystory.util.*
import com.a360vrsh.pansmartcitystory.viewmodel.order.FoodOrderDetailViewModel
import kotlinx.android.synthetic.main.activity_food_order_detail.*
import org.greenrobot.eventbus.EventBus


class FoodOrderDetailActivity : BaseTitleActivity() {
    private val viewModel: FoodOrderDetailViewModel by lazy {
        initViewModel(FoodOrderDetailViewModel::class.java) as FoodOrderDetailViewModel
    }
    private var distributionMode: String? = null//配送方式1=配送,2=到店

    private var popPriceInfo: CommonPopupWindow? = null //价格明细
    private var mGoodsAdapter: FoodOrderDetailGoodsAdapter? = null

    private var orderId: String? = null
    private var orderDetailBean: FoodOrderDetailBean.DataBean? = null
    private val mShowCount = 3

    override fun getLayoutId(): Int {
        return R.layout.activity_food_order_detail
    }

    override fun initView() {
        titleText.text = "订单详情"
        orderId = intent.getStringExtra("id")

        mGoodsAdapter = FoodOrderDetailGoodsAdapter(null)
        RecyclerViewUtil.setVerticalManager(getContext(), rv_goods)
        rv_goods.adapter = mGoodsAdapter
    }


    override fun initListener() {

        tv_one_btn.setOnClickListener {
            if (tv_one_btn.text == "拒绝接单") {
                updateOrderStatus(OrderConstant.REFUSE)
            } else if (tv_one_btn.text == "核销码核销") {
                showCheckPopup()
            }

        }
        tv_two_btn.setOnClickListener {
            when (tv_two_btn.text) {
                "立即接单" -> {

                    updateOrderStatus(OrderConstant.ACCEPT)
                }
                "发货" -> {

                    updateOrderStatus(OrderConstant.SHIP)
                }
                "扫码核销" -> {
                    UiUtil.goQrCodeActivity(this@FoodOrderDetailActivity)
                }
            }
        }
    }

    override fun initObserver() {
        viewModel.orderDetailLiveData.observe(this, Observer {
            orderDetailBean = it.data
            setUiData(orderDetailBean)
        })
        viewModel.operationSuccessLiveData.observe(this, Observer {
            getOrderDetail()
            EventBus.getDefault().post(EventBean(EventID.ORDER_OPERATION_SUCCESS))
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setUiData(refundDetailBean: FoodOrderDetailBean.DataBean?) {

        refundDetailBean?.apply {
            setStatusLayout(this.status)
            setDistributionLayout(this)
            tv_price_info.setSingleClick {
                initPriceInfoPopupWindow(this)
            }

            mGoodsAdapter?.setNewData(this.goods)

            tv_status_title.text = this.status_title
            tv_order_price.text = this.order_price
            tv_order_sn.text = this.sn
            tv_create_date.text = this.created_at

            if (this.payd_at.isNullOrEmpty()) {
                ll_pay_date.setGone()
            } else {
                ll_pay_date.setVisible()
                tv_pay_date.text = this.payd_at
            }
            if (this.remark.isNullOrEmpty()) {
                tv_remark.text = "未填写"
            } else {
                tv_remark.text = this.remark
            }

            this.goods.apply {
                if (this.size > mShowCount) {
                    ll_expend_more.setVisible()
                    ll_expend_close.setGone()
                    mGoodsAdapter?.setShowCount(mShowCount)
                    ll_expend_more.setSingleClick {
                        mGoodsAdapter?.setShowCount(this.size)
                        ll_expend_more.setGone()
                        ll_expend_close.setVisible()
                    }
                    ll_expend_close.setSingleClick {
                        mGoodsAdapter?.setShowCount(mShowCount)
                        ll_expend_more.setVisible()
                        ll_expend_close.setGone()
                    }
                } else {
                    ll_expend_more.setGone()
                    ll_expend_close.setGone()
                }
            }
        }


    }

    private fun setDistributionLayout(bean: FoodOrderDetailBean.DataBean?) {

        bean?.info?.apply {
            if (this.distribution_mode == "1") {//商家配送
                ll_user_group.setGone()
                ll_distribute_group.setVisible()
                tv_contact_name.text = this.name
                tv_contact_address.text = this.address_detail
                iv_phone.setSingleClick {
                    IntentUtil.callPhone(getContext(), this.phone)
                }
                iv_address.setSingleClick {
                    val bundle = Bundle()
                    bundle.putString("lat", this.lat)
                    bundle.putString("lng", this.lng)
                    gotoActivity(MapAddressActivity::class.java, bundle)
                }

            } else if (this.distribution_mode == "2") {//到店自取
                ll_user_group.setVisible()
                ll_distribute_group.setGone()
                tv_user_name.text = this.name
                tv_user_phone.text = this.phone
                iv_user_phone.setSingleClick {
                    IntentUtil.callPhone(getContext(), this.phone)
                }
            }
        }
    }

    private fun setStatusLayout(status: String?) {
        when (status) {
            "2" -> {
                ll_bottom_group.setVisible()
                tv_one_btn.setVisible()
                tv_two_btn.setVisible()
                tv_one_btn.text = "拒绝接单"
                tv_two_btn.text = "立即接单"
            }

            "5" -> {
                iv_status.setImageResource(R.mipmap.ic_dhx)
                ll_bottom_group.setVisible()
                tv_one_btn.setVisible()
                tv_two_btn.setVisible()
                tv_one_btn.text = "核销码核销"
                tv_two_btn.text = "扫码核销"
            }
            "9" -> {
                ll_bottom_group.setVisible()
                tv_one_btn.setGone()
                tv_two_btn.setVisible()
                tv_two_btn.text = "发货"
            }
            else -> {
                ll_bottom_group.setGone()
                iv_status.setImageResource(R.mipmap.ic_order_status)
            }
        }

    }
    override fun initData() {
        getOrderDetail()
    }

    private fun initPriceInfoPopupWindow(dataBean: FoodOrderDetailBean.DataBean) {
        popPriceInfo?.cancel()
        popPriceInfo = CommonPopupWindow.Builder(this@FoodOrderDetailActivity)
            .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
            .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
            .setContentView(R.layout.layout_popup_order_price_info)
            .setAnimationStyle(R.style.library_pop_bottom_anim)
            .setFocusable(true)
            .setOutsideTouchable(false)
            .enableBackgroundAlpha(true)
            .setOnCreateView { view ->

                val tvTotal = view.findViewById<TextView>(R.id.tv_total)
                val tvOrderPrice = view.findViewById<TextView>(R.id.tv_order_price)
                val tvRandom = view.findViewById<TextView>(R.id.tv_random)
                val tvCommission = view.findViewById<TextView>(R.id.tv_commission)
                tvOrderPrice.text = "¥ " + dataBean.order_price
//                tvRandom.text = "¥ " + dataBean.order_price
                tvCommission.text = "¥ " + dataBean.commission
                tvTotal.text = "¥ " + dataBean.pay_price
                view.findViewById<RelativeLayout>(R.id.rl_close).setOnClickListener {
                    popPriceInfo?.dismiss()
                }

            }.setOnDismissListener {

            }
            .create()
            .showAtBottom(findViewById<View>(R.id.rl_root), 0, 0)
    }

    /**
     * 获取订单详情
     * */
    private fun getOrderDetail() {
        orderId?.let {

            viewModel.getOrderDetail(getContext(), it, true)

        }
    }

    /**
     * 更改订单状态
     * */
    private fun updateOrderStatus(status: String) {
        orderId?.let {
            viewModel.orderUpdate(getContext(), it, status, true)
        }
    }

    /**
     * 核销码弹框
     * */
    private var checkPopupWindow: CommonPopupWindow? = null
    private fun showCheckPopup() {
        checkPopupWindow?.cancel()
        checkPopupWindow =
            CommonPopupWindow.Builder(this@FoodOrderDetailActivity)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentView(R.layout.layout_order_check_dialog)
                .setAnimationStyle(R.style.library_scale_fade_in_and_out_anim)
                .setFocusable(true)
                .setOutsideTouchable(false)
                .enableBackgroundAlpha(true)
                .setOnCreateView { view ->
                    var isComplete = false
                    val codeView = view.findViewById<CheckCodeView>(R.id.check_code_view)
                    codeView.setInputCompleteListener(object : CheckCodeView.InputCompleteListener {
                        override fun inputComplete() {
                            isComplete = true
                        }

                        override fun invalidContent() {
                            isComplete = false
                        }

                    })
                    view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
                        checkPopupWindow?.dismiss()
                    }
                    view.findViewById<TextView>(R.id.tv_confirm).setOnClickListener {
                        if (isComplete) {
                            showToast("核销")
                        } else {
                            showToast("请输入正确的核销码")
                        }

                    }
                }.setOnDismissListener {

                }
                .create()
                .showAtLocation(findViewById<View>(R.id.rl_root), Gravity.NO_GRAVITY, 0, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            data?.apply {
                val result = this.getStringExtra("codedContent")
                showToast(result)
            }
        }
    }
}