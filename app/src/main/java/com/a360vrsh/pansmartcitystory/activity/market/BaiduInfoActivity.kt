package com.a360vrsh.pansmartcitystory.activity.market

import androidx.lifecycle.Observer
import com.a360vrsh.library.adapter.SimpleListAdapter
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.RedPacketListAdapter
import com.a360vrsh.pansmartcitystory.util.DataUtils
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.viewmodel.market.RedPacketListViewModel
import kotlinx.android.synthetic.main.activity_baidu_info.*

/**
 *百度地图全景展示
 * */
class BaiduInfoActivity : BaseTitleActivity() {
    private val viewModel: RedPacketListViewModel by lazy {
        initViewModel(RedPacketListViewModel::class.java) as RedPacketListViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_baidu_info
    }

    override fun initView() {
        titleText.text = "百度地图全景展示"

    }

    override fun initListener() {
       tv_rules.text = DataUtils.getBaiduRules()
    }

    override fun initObserver() {

    }

    override fun initData() {

    }



}