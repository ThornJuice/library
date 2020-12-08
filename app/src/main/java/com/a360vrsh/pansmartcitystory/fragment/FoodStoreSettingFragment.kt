package com.a360vrsh.pansmartcitystory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.CalendarUtil
import com.a360vrsh.library.util.EditTextUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.bean.StoreInfoBean
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.store.StoreSettingViewModel
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import com.mylhyl.circledialog.BaseCircleDialog
import com.mylhyl.circledialog.CircleDialog
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.fragment_food_store_setting.*


/**
 * 美食行业店铺设置
 */
class FoodStoreSettingFragment : BaseFragment() {
    private lateinit var viewModel: StoreSettingViewModel

//    private var storeTag: String? = null//标签
//    private var describe: String? = null//描述
//    private var openTime: String? = null//营业时间
//    private var closeTime: String? = null//营业时间
//    private var perCost: String? = null//人均消费
//    private var deliveryCost: String? = null//配送费

    private var isSupportDelivery: String? = "0"//支持配送
    private var isSupportSelf: String = "0"//支持自取
    private var isAutoReceiver: String = "0"//自动接单

    private var storeId: String? = null//店铺id
    private var storeInfoBean: StoreInfoBean? = null//店铺信息bean
    private var timePickerView: TimePickerView? = null//时间选择
    private var circleDialog: CircleDialog.Builder? = null//标签输入弹框

    private var dialog: BaseCircleDialog? = null
    val tags = ArrayList<String>()//标签


    companion object {
        @JvmStatic
        fun newInstance() =
            FoodStoreSettingFragment().apply {
                arguments = Bundle().apply {
//                    putString("ARG_PARAM1", param1)

                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_food_store_setting
    }

    override fun initData() {
        //获取店铺id
        viewModel.checkTicket(requireContext(), true)
    }

    override fun initView() {
        viewModel = initViewModel(StoreSettingViewModel::class.java) as StoreSettingViewModel

        timePickerView = TimePickerBuilder(requireContext(),
            OnTimeSelectListener { date, v -> //选中事件回调
                if (v == tv_open_time) {
                    tv_open_time.text = CalendarUtil.dateFormat(date, "HH:mm")
                } else {
                    tv_close_time.text = CalendarUtil.dateFormat(date, "HH:mm")
                }
            }
        )
            .setType(booleanArrayOf(false, false, false, true, true, false))
            .build()


        tagFlowLayout.adapter = object : TagAdapter<String>(tags) {
            override fun getView(
                parent: FlowLayout,
                position: Int,
                s: String?
            ): View {
                val view = LayoutInflater.from(requireContext()).inflate(
                    R.layout.item_add_tag,
                    tagFlowLayout, false
                ) as LinearLayout
                val ll_tag_group: LinearLayout = view.findViewById(R.id.ll_tag_group)
                val tv_tag: TextView = view.findViewById(R.id.tv_tag)
                val iv_delete: ImageView = view.findViewById(R.id.iv_delete)
                tv_tag.text = s


                if (position == tags.size - 1) {
                    if (tags.size > 3) {
                        ll_tag_group.visibility = View.GONE
                    } else {
                        ll_tag_group.visibility = View.VISIBLE
                    }

                    iv_delete.visibility = View.GONE
                } else {
                    iv_delete.visibility = View.VISIBLE
                }
                tv_tag.setOnClickListener {
                    if (position == tags.size - 1) {
                        initInputDialog()
                    }
                }
                iv_delete.setOnClickListener {
                    tags.removeAt(position)
                    tagFlowLayout.adapter.notifyDataChanged()
                }

                return view
            }
        }

    }

    var edtTagValue: EditText? = null
    private fun initInputDialog() {

        circleDialog = CircleDialog.Builder()
            .setBodyView(R.layout.layout_simple_input) { view ->
                edtTagValue = view.findViewById(R.id.edt_content)
                edtTagValue?.requestFocus()
            }
            .setTitle("请输入标签名称")
            .setWidth(0.7f)
            .setPositive("确定") {
                val value = edtTagValue?.text.toString().trim()
                if (value.isNotBlank()) {
                    tags.add(tags.size - 1, value)
                    tagFlowLayout.adapter.notifyDataChanged()
                }

            }
            .setNegative("取消") {}
            .setCancelable(false)
        dialog = circleDialog?.show(fragmentManager)
    }

    override fun initObserver() {
        //获取店铺id回调
        viewModel.checkTicketLiveData.observe(this, Observer { checkTicketBean ->

            //获取店铺信息
            storeId = checkTicketBean.data?.store_id
            storeId?.let { it ->
                viewModel.getStoreInfo(requireContext(), it, true)
            }


        })
        //获取店铺信息回调
        viewModel.storeInfoLiveData.observe(this, Observer {
            storeInfoBean = it
            setUiData()

        })
        //保存成功回调
        viewModel.saveSuccessLiveData.observe(this, Observer {

            showToast("保存成功")

        })
    }

    override fun initListener() {
        edt_per_cost.filters = EditTextUtil.inputTwoDecimal()
        tv_open_time.setOnClickListener {
            timePickerView?.show(tv_open_time)
        }
        tv_close_time.setOnClickListener {
            timePickerView?.show(tv_close_time)
        }

        switchButton.setOnClickListener {
            isAutoReceiver = if (switchButton.isOpened) {
                "1"
            } else {
                "0"
            }
        }

        cb_delivery.setOnCheckedChangeListener { buttonView, isChecked ->
            isSupportDelivery = if (isChecked) {
                "1"
            } else {
                "0"
            }

        }
        cb_self.setOnCheckedChangeListener { buttonView, isChecked ->
            isSupportSelf = if (isChecked) {
                "1"
            } else {
                "0"
            }
        }
    }


    /**
     * 设置ui数据
     * */
    private fun setUiData() {
        storeInfoBean?.data?.let {

            edt_per_cost.setText(it.industry?.per_capita)
            edt_delivery_cost.setText(it.industry?.delivery_cost)
            edt_describe.setText(it.describe)
            tv_open_time.text = it.industry?.open_time
            tv_close_time.text = it.industry?.close_time
            cb_delivery.isChecked = it.industry.is_delivery == "1"
            cb_self.isChecked = it.industry.is_self_get == "1"
            switchButton.isOpened = it.industry.is_receipt == "1"

//            describe = it.describe
//            openTime = it.industry?.open_time
//            closeTime = it.industry?.close_time
//            perCost = it.industry?.per_capita
//            deliveryCost = it.industry?.delivery_cost

            tags.clear()
            it.industry?.tag?.let { tag ->
                tags.addAll(tag)
                tags.add("+ 添加")
                tagFlowLayout.adapter.notifyDataChanged()
            }
        }

    }

    override fun initImmersionBar() {

    }

    /**
     * 保存数据
     * */


    fun save() {

        storeInfoBean?.let {

            if (edt_per_cost.text.toString().isBlank()) {
                showToast("人均消费不能为空")
                return@let
            }
            if (edt_per_cost.text.toString().trim().toFloat() > 10000f) {
                showToast("人均消费最大不能超过10000")
                return@let
            }

            tags.removeAt(tags.size - 1)
            val storeTag = tags.joinToString(",")
            val perCost = edt_per_cost.text.toString().trim()
            val deliveryCost = edt_delivery_cost.text.toString().trim()
            val describe = edt_describe.text.toString().trim()
            val openTime = tv_open_time.text.toString()
            val closeTime = tv_close_time.text.toString()

            val paramMap = HashMap<String, String?>()
            paramMap["tag"] = storeTag
            paramMap["describe"] = describe
            paramMap["open_time"] = openTime
            paramMap["close_time"] = closeTime
            paramMap["per_capita"] = perCost
            paramMap["delivery_cost"] = deliveryCost
            paramMap["is_delivery"] = isSupportDelivery
            paramMap["is_self_get"] = isSupportSelf
            paramMap["is_receipt"] = isAutoReceiver

            storeId?.let { id -> viewModel.saveIndustry(requireContext(), id, paramMap, true) }
        }
    }
}