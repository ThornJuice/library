package com.a360vrsh.pansmartcitystory.activity.market

import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.a360vrsh.pansmartcitystory.viewmodel.market.RedPacketDetailViewModel

class RedPacketDetailActivity : BaseTitleActivity() {
    private val viewModel: RedPacketDetailViewModel by lazy {
        initViewModel(RedPacketDetailViewModel::class.java) as RedPacketDetailViewModel
    }
    private var redPacketId: String? = null
    private var page = 1
    override fun getLayoutId(): Int {
        return R.layout.activity_red_packet_detail
    }

    override fun initView() {
        titleText.text = "红包详情"
        tvRight.text = "删除此红包"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

    }

    override fun initListener() {
        llRight.setSingleClick {
            delete()
        }
    }

    override fun initData() {
        getDetail()
        getReceiveList()
    }

    override fun initObserver() {
        viewModel.redPacketDetailLiveData.observe(this, Observer {

        })
        viewModel.redPacketDetailLiveData.observe(this, Observer {

        })
        viewModel.deleteSuccessLiveData.observe(this, Observer {

        })
    }

    /**
     * 删除红包
     */
    private fun delete() {
        UiUtil.getDialog(this@RedPacketDetailActivity, "提示", "确定删除该红包？")
            .setPositive("确定") { v ->
                redPacketId?.let {
                    viewModel.deleteRedPacket(
                        getContext(),
                        it, true
                    )
                }

            }
            .setNegative("取消") { v -> }
            .show(supportFragmentManager)
    }

    /**
     * 红包详情
     */
    private fun getDetail() {

        redPacketId?.let {
            viewModel.getDetail(
                getContext(),
                it, true
            )
        }
    }

    /**
     * 红包领取记录
     */
    private fun getReceiveList() {

        redPacketId?.let {
            viewModel.getReceiveList(
                getContext(),
                it, "" + page, true
            )
        }
    }
}