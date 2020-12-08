package com.a360vrsh.pansmartcitystory.activity.goods

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.activity.LocalWebViewActivity
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.ScreenUtil
import com.a360vrsh.library.widget.CommonPopupWindow
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.GoodsDetailImageAdapter
import com.a360vrsh.pansmartcitystory.adapter.TicketListAdapter
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean
import com.a360vrsh.pansmartcitystory.bean.TicketInfoBean
import com.a360vrsh.pansmartcitystory.util.*
import com.a360vrsh.pansmartcitystory.viewmodel.goods.GoodsDetailViewModel
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_travel_goods_detail.*
import kotlinx.android.synthetic.main.activity_travel_goods_detail.ll_bottom_group
import kotlinx.android.synthetic.main.layout_goods_detail_bottom.*
import org.greenrobot.eventbus.EventBus

/**
 * 商品详情-旅游
 * */
class TravelGoodsDetailActivity : BaseTitleActivity(), TicketListAdapter.OnAdapterClickListener {

    private val viewModel: GoodsDetailViewModel by lazy {
        initViewModel(GoodsDetailViewModel::class.java) as GoodsDetailViewModel
    }

    private var ticketInfoPopup: CommonPopupWindow? = null
    private var mImageAdapter: GoodsDetailImageAdapter? = null
    private var mTicketListAdapter: TicketListAdapter? = null
    private var goodsDetailBean: GoodsDetailBean.DataBean? = null
    private var goodsId: String? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_travel_goods_detail
    }

    override fun initView() {

        titleText.text = "商品详情"
        tvRight.text = "编辑"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

        mImageAdapter = GoodsDetailImageAdapter(null)
        RecyclerViewUtil.setGridManager(getContext(), rv_images, 3)
        rv_images.adapter = mImageAdapter

        mTicketListAdapter = TicketListAdapter(null)
        mTicketListAdapter?.setAdapterClickListener(this@TravelGoodsDetailActivity)
        RecyclerViewUtil.setVerticalManager(getContext(), rv_ticket)
        rv_ticket.adapter = mTicketListAdapter


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

    override fun initData() {
        goodsId = intent.getStringExtra("id")
        goodsId?.let {
            viewModel.getGoodsDetail(getContext(), it, MMKVUtil.getStoreId(), true)
            viewModel.getTicketList(getContext(), it, true)
        }

    }

    override fun initObserver() {
        viewModel.goodsDetailLiveData.observe(this, Observer {
            goodsDetailBean = it.data
            setUiData(it.data)
        })
        viewModel.ticketListBeanLiveData.observe(this, Observer {
            if (it.data.isNullOrEmpty()) {
                ll_ticket_group.setGone()
            } else {
                ll_ticket_group.setVisible()
                mTicketListAdapter?.setNewData(it.data)
            }

        })
        viewModel.ticketInfoBeanLiveData.observe(this, Observer {
            initTicketInfoPopup(it.data)
        })
        viewModel.operationSuccessLiveData.observe(this, Observer {

            showToast("操作成功")
            goodsId?.let {
                viewModel.getGoodsDetail(getContext(), it, MMKVUtil.getStoreId(), true)
                viewModel.getTicketList(getContext(), it, true)
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

            it.toruism?.apply {

                tv_site_name.text = this.site_name
                tv_site_location.text =
                    this.province + "-" + this.city + "-" + this.region
                tv_site_address.text = this.site_address
                tv_site_type_name.text = this.site_type_name

                if (this.tag.isNullOrEmpty()) {
                    ll_tag_group.setGone()
                } else {
                    ll_tag_group.setVisible()
                    tagFlowLayout.adapter = object : TagAdapter<String>(it.toruism.tag) {
                        override fun getView(
                            parent: FlowLayout,
                            position: Int,
                            s: String?
                        ): View {
                            val view = LayoutInflater.from(getContext()).inflate(
                                R.layout.item_goods_tag,
                                tagFlowLayout, false
                            ) as TextView
                            view.text = s
                            return view
                        }
                    }
                }
            }

            mImageAdapter?.setNewData(it.images)
        }
    }




    @SuppressLint("SetTextI18n")
    private fun initTicketInfoPopup(data: TicketInfoBean.DataBean) {
        val screenHeight: Int = ScreenUtil.getScreenRealHeight(this@TravelGoodsDetailActivity)

        ticketInfoPopup = CommonPopupWindow.Builder(this@TravelGoodsDetailActivity)
            .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
            .setHeight(screenHeight * 2 / 3)
            .setContentView(R.layout.layout_popup_ticket_info)
            .setAnimationStyle(R.style.library_pop_bottom_anim)
            .setFocusable(true)
            .setOutsideTouchable(true)
            .enableBackgroundAlpha(true)
            .setOnCreateView { view ->
                view.findViewById<RelativeLayout>(R.id.rl_close).setOnClickListener {
                    ticketInfoPopup?.dismiss()
                }
                view.findViewById<TextView>(R.id.tv_ticket_name).text = data.name
                view.findViewById<TextView>(R.id.tv_ticket_type).text = mTicketType
                view.findViewById<TextView>(R.id.tv_entry_address).text = data.use_entry_address
                view.findViewById<TextView>(R.id.tv_effect).text =
                    "出票" + data.reserve_effect.toString() + "小时后生效"
                view.findViewById<TextView>(R.id.tv_valid).text =
                    "指定入园日期" + data.reserve_valid.toString() + "天内有效"
                view.findViewById<TextView>(R.id.tv_cost_contain).text = data.cost_contain
                view.findViewById<TextView>(R.id.tv_cost_without).text = data.cost_without
                view.findViewById<TextView>(R.id.tv_use_entry_sort).text = data.use_entry_sort
                view.findViewById<TextView>(R.id.tv_exchange_time).text =
                    data.use_exchange_start.toString() + "-" + data.use_exchange_end
                view.findViewById<TextView>(R.id.tv_exchange_address).text =
                    data.use_entry_address
                view.findViewById<TextView>(R.id.tv_entry_time).text =
                    data.use_entry_start.toString() + "-" + data.use_entry_end
                view.findViewById<TextView>(R.id.tv_verification).text =
                    getReserveVerification(data.verification)
                view.findViewById<TextView>(R.id.tv_change).text = data.change
                view.findViewById<TextView>(R.id.tv_other).text = data.other

            }.setOnDismissListener {

            }
            .create()
            .showAtBottom(rl_root, 0, 0)
    }

    /**
     * 身份验证
     */
    private fun getReserveVerification(verification: String): String? {
        return when (verification) {
            "0" -> "需要单个出行人信息"
            "1" -> "需要多个出行人信息"
            else -> ""
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

        UiUtil.getDialog(this@TravelGoodsDetailActivity, "提示", "确定将此商品下架？")
            .setPositive("确定") { v ->
                goodsId?.let {
                    viewModel.goodsStop(
                        getContext(),
                        it, MMKVUtil.getStoreId(), true
                    )
                }

            }
            .setNegative("取消") { v -> }
            .show(supportFragmentManager)
    }

    /**
     * 删除商品
     */
    private fun goodsDelete() {

        UiUtil.getDialog(this@TravelGoodsDetailActivity, "提示", "确定删除该商品？")
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

    private var mTicketType: String? = null//门票类型

    /**
     * 查看门票详情
     */
    override fun onAdapterClick(type: String, id: String) {
        goodsId?.let {
            mTicketType = type
            viewModel.getTicketInfo(getContext(), id, it, true)
        }
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
                    viewModel.getTicketList(getContext(), it, true)
                }
            }
        }
    }
}