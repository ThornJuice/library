package com.a360vrsh.pansmartcitystory.activity.market

import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.viewmodel.market.AddRedPacketViewModel

class AddRedPacketActivity : BaseTitleActivity() {
    private val viewModel: AddRedPacketViewModel by lazy {
        initViewModel(AddRedPacketViewModel::class.java) as AddRedPacketViewModel
    }

    override fun initView() {
        titleText.text = "发红包"
    }


    override fun initListener() {

    }

    override fun initData() {

    }

    override fun initObserver() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_add_red_packet
    }
}