package com.a360vrsh.pansmartcitystory.activity.order

import android.annotation.SuppressLint
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.ImageLoaderUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.library.widget.CheckCodeView
import com.a360vrsh.library.widget.CommonPopupWindow
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.TravelOrderDetailTouristAdapter
import com.a360vrsh.pansmartcitystory.bean.LMMOrderDetailBean
import com.a360vrsh.pansmartcitystory.bean.TravelOrderDetailBean
import com.a360vrsh.pansmartcitystory.util.*
import com.a360vrsh.pansmartcitystory.viewmodel.order.TravelOrderDetailViewModel
import kotlinx.android.synthetic.main.activity_travel_order_detail.*
import org.greenrobot.eventbus.EventBus

class TravelOrderDetailActivity : BaseTitleActivity() {

    private val viewModel: TravelOrderDetailViewModel by lazy {
        initViewModel(TravelOrderDetailViewModel::class.java) as TravelOrderDetailViewModel
    }
    private var popPriceInfo: CommonPopupWindow? = null //价格明细
    private var mTouristAdapter: TravelOrderDetailTouristAdapter? = null
    private var orderId: String? = null
    private var orderDetailBean: TravelOrderDetailBean.DataBean? = null
    private var lmmOrderDetailBean: LMMOrderDetailBean.DataBean? = null
    private val mShowCount = 3
    override fun getLayoutId(): Int {
        return R.layout.activity_travel_order_detail
    }

    override fun initView() {
        titleText.text = "订单详情"
        orderId = intent.getStringExtra("id")

        mTouristAdapter = TravelOrderDetailTouristAdapter(null)
        RecyclerViewUtil.setVerticalManager(getContext(), rv_tourist)
        rv_tourist.adapter = mTouristAdapter
    }


    override fun initListener() {
        tv_one_btn.setSingleClick {
            if (tv_one_btn.text == "核销码核销") {
                showCheckPopup()
            }

        }
        tv_two_btn.setSingleClick {
            if (tv_two_btn.text == "扫码核销") {
                showToast("扫码核销")
                UiUtil.goQrCodeActivity(this@TravelOrderDetailActivity)
            }
        }
    }

    override fun initObserver() {
        viewModel.orderDetailLiveData.observe(this, Observer {
            orderDetailBean = it.data
            setUiData(orderDetailBean)
        })
        viewModel.lmmOrderDetailLiveData.observe(this, Observer {
            lmmOrderDetailBean = it.data
            setUiData(lmmOrderDetailBean)
        })
        viewModel.operationSuccessLiveData.observe(this, Observer {
            getOrderDetail()
            EventBus.getDefault().post(EventBean(EventID.ORDER_OPERATION_SUCCESS))
        })
    }


    override fun initData() {
        getOrderDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun setUiData(lmmOrderDetailBean: LMMOrderDetailBean.DataBean?) {
        lmmOrderDetailBean?.apply {

            setStatusLayout(this.status)

            tv_status_title.text = this.status_title
            tv_order_sn.text = this.sn
            tv_create_date.text = this.created_at
            if (this.payd_at.isNotEmpty()) {
                ll_pay_date.setVisible()
                tv_pay_date.text = this.payd_at
            } else {
                ll_pay_date.setGone()
            }
            tv_num.text = "游玩人数：" + this.goods_num
            goods?.let {
                if (it.size > 0) {
                    tv_title.text = it[0].goods_title
                    tv_type.text = "门票：" + it[0].ticket_name
                    tv_use_date.text = "使用日期：" + it[0].ticket_affect_date
                    ImageLoaderUtil.displayImage(getContext(), it[0].goods_cover_image, iv_image)
                }
            }

            ll_tourist_group.setVisible()
            rv_tourist.setGone()
            this.info.let {
                tv_tourist_name.text = it.tourist_name
                tv_tourist_phone.text = it.tourist_phone
                tv_tourist_id.text = it.tourist_idcard
            }

        }
    }

    private fun setStatusLayout(status: String?) {
        when (status) {
            "5" -> {
                iv_status.setImageResource(R.mipmap.ic_dhx)
                ll_bottom_group.setVisible()
                tv_one_btn.setVisible()
                tv_two_btn.setVisible()
                tv_one_btn.text = "核销码核销"
                tv_two_btn.text = "扫码核销"
            }

            else -> {
//                ll_bottom_group.setGone()
                ll_bottom_group.setVisible()
                iv_status.setImageResource(R.mipmap.ic_order_status)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setUiData(orderDetailBean: TravelOrderDetailBean.DataBean?) {
        orderDetailBean?.apply {
            setStatusLayout(this.status)

            tv_price_info.setSingleClick {
                initPriceInfoPopupWindow(this)
            }
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
            tv_num.text = "游玩人数：" + this.goods_num

            //商品信息
            this.goods?.let {
                if (it.size > 0) {
                    tv_title.text = it[0].goods_title
                    tv_type.text = "门票：" + it[0].ticket_name
                    tv_use_date.text = "使用日期：" + it[0].ticket_affect_date
                    ImageLoaderUtil.displayImage(getContext(), it[0].goods_cover_image, iv_image)
                }
            }
            ll_tourist_group.setGone()
            rv_tourist.setVisible()
            mTouristAdapter?.setNewData(this.info)
            //出行人
            this.info.apply {
                if (this.size > mShowCount) {
                    ll_expend_more.setVisible()
                    ll_expend_close.setGone()
                    mTouristAdapter?.setShowCount(mShowCount)
                    ll_expend_more.setOnClickListener {
                        mTouristAdapter?.setShowCount(this.size)
                        ll_expend_more.setGone()
                        ll_expend_close.setVisible()
                    }
                    ll_expend_close.setOnClickListener {
                        mTouristAdapter?.setShowCount(mShowCount)
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

    private fun initPriceInfoPopupWindow(dataBean: TravelOrderDetailBean.DataBean) {
        popPriceInfo?.cancel()
        popPriceInfo = CommonPopupWindow.Builder(this@TravelOrderDetailActivity)
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
            if (intent.getBooleanExtra("isLMM", false)) {
                viewModel.getLMMOrderDetail(getContext(), it, true)
            } else {
                viewModel.getOrderDetail(getContext(), it, true)
            }
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
            CommonPopupWindow.Builder(this@TravelOrderDetailActivity)
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