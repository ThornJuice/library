package com.a360vrsh.pansmartcitystory.activity.order

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.widget.CommonPopupWindow
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.MyPanoImageAdapter
import com.a360vrsh.pansmartcitystory.adapter.RefundDetailGoodsAdapter
import com.a360vrsh.pansmartcitystory.bean.RefundDetailBean
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setGone
import com.a360vrsh.pansmartcitystory.util.setVisible
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.order.RefundDetailViewModel
import kotlinx.android.synthetic.main.activity_food_refund_detail.*
import kotlinx.android.synthetic.main.layout_refund_detail_bottom.*

class FoodRefundDetailActivity : BaseTitleActivity() {

    private val viewModel: RefundDetailViewModel by lazy {
        initViewModel(RefundDetailViewModel::class.java) as RefundDetailViewModel
    }
    private var popPriceInfo: CommonPopupWindow? = null //价格明细

    private var mImageAdapter: MyPanoImageAdapter? = null
    private var mGoodsAdapter: RefundDetailGoodsAdapter? = null
    private var orderId: String? = null
    private var refundDetailBean: RefundDetailBean.DataBean? = null
    private val mShowCount = 3

    override fun getLayoutId(): Int {
        return R.layout.activity_food_refund_detail
    }

    override fun initView() {
        titleText.text = "售后详情"
        orderId = intent.getStringExtra("id")

        mGoodsAdapter = RefundDetailGoodsAdapter(null)
        RecyclerViewUtil.setVerticalManager(getContext(), rv_goods)
        rv_goods.adapter = mGoodsAdapter

        mImageAdapter = MyPanoImageAdapter(null)
        RecyclerViewUtil.setGridManager(getContext(), rv_images, 3)
        rv_images.adapter = mImageAdapter

    }


    override fun initListener() {
        tv_one_btn.setOnClickListener {
            showToast("jujue")

        }
        tv_two_btn.setOnClickListener {
            showToast("tuikuan")
        }
    }

    override fun initObserver() {
        viewModel.refundDetailLiveData.observe(this, Observer {
            refundDetailBean = it.data
            setUiData(refundDetailBean)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setUiData(refundDetailBean: RefundDetailBean.DataBean?) {

        refundDetailBean?.apply {
            tv_price_info.setOnClickListener {
                initPriceInfoPopupWindow(this)
            }
            mGoodsAdapter?.setNewData(this.goods)

            tv_status_title.text = this.refund_status_title
            tv_refund_money.text = this.money
            tv_pay_money.text = "¥ " + this.pay_money
            tv_refund_type.text = this.refund_status_title
            tv_refund_reason.text = this.reason
            tv_refund_sn.text = this.refund_sn
            tv_create_date.text = this.created_at
            tv_refund_date.text = this.updated_at
            tv_contact_name.text = this.user_name
            tv_contact_phone.text = this.user_phone

            if (this.desc.isNullOrEmpty()) {
                tv_remark.text = "未填写"
            } else {
                tv_remark.text = this.desc
            }

            if (this.images.isNullOrEmpty()) {
                ll_images.setGone()
            } else {
                ll_images.setVisible()
                mImageAdapter?.setNewData(images)
            }

            this.goods.apply {
                if (this.size > mShowCount) {
                    ll_expend_more.setVisible()
                    ll_expend_close.setGone()
                    mGoodsAdapter?.setShowCount(mShowCount)
                    ll_expend_more.setOnClickListener {
                        mGoodsAdapter?.setShowCount(this.size)
                        ll_expend_more.setGone()
                        ll_expend_close.setVisible()
                    }
                    ll_expend_close.setOnClickListener {
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


    override fun initData() {
        orderId?.let {

            viewModel.getRefundDetail(getContext(), it, true)

        }
    }
    private fun initPriceInfoPopupWindow(dataBean: RefundDetailBean.DataBean) {
        popPriceInfo?.cancel()
        popPriceInfo = CommonPopupWindow.Builder(this@FoodRefundDetailActivity)
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
//                tvRandom.text = "¥ " + dataBean.pay_money
                tvCommission.text = "¥ " + dataBean.pay_money
                tvTotal.text = "¥ " + dataBean.pay_money
                view.findViewById<RelativeLayout>(R.id.rl_close).setOnClickListener {
                    popPriceInfo?.dismiss()
                }

            }.setOnDismissListener {

            }
            .create()
            .showAtBottom(findViewById<View>(R.id.rl_root),0,0)
    }
}