package com.a360vrsh.pansmartcitystory.fragment

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.a360vrsh.library.adapter.SimpleListAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.DataUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.market.BaiduInfoActivity
import com.a360vrsh.pansmartcitystory.activity.market.RedPacketListActivity
import com.a360vrsh.pansmartcitystory.viewmodel.home.MarketingViewModel
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.marketing_fragment.*

class MarketingFragment : BaseFragment() {
    private lateinit var viewModel: MarketingViewModel
    private var mAdapter: SimpleListAdapter? = null

    companion object {
        fun newInstance() = MarketingFragment()
    }


    override fun getLayoutID(): Int {
        return R.layout.marketing_fragment
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this).get(MarketingViewModel::class.java)
//        RecycleViewUtil.setVerticalManager(getContext(), recyclerView)
//        mAdapter = SimpleListAdapter(null)
////        mAdapter?.setOnItemChildClickListener { adapter, view, position ->  }
//        recyclerView?.adapter = mAdapter

    }

    override fun initObserver() {

    }

    override fun initListener() {
        ll_my_red_packet.setSingleClick {
            gotoActivity(RedPacketListActivity::class.java)
        }
        ll_info.setSingleClick {
            gotoActivity(BaiduInfoActivity::class.java)
        }
    }

    override fun initData() {
        getData()

        setMarqueeView(DataUtil.getArrayList(5, "滚动广告"))
    }

    override fun initImmersionBar() {

        activity?.let {
            ImmersionBar.with(it)
                .statusBarColor(R.color.library_transparent)
                .statusBarDarkFont(false)
                .init()
        }
    }


    private fun getData() {
        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("texttexttexttexttexttexttexttext")
        }
        mAdapter?.addData(list)
    }

    private fun setMarqueeView(list: List<String>) {
        val viewList = ArrayList<View>()
        for (i in list.indices) {
            val itemView = LayoutInflater.from(context).inflate(R.layout.item_marquee_view, null)
            val textView = itemView.findViewById<View>(R.id.tv_marquee) as TextView
            textView.setText(list[i])
            viewList.add(itemView)
        }
        marqueeView.setViews(viewList)
    }
}