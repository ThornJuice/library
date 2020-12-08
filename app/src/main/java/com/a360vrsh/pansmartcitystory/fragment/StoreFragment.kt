package com.a360vrsh.pansmartcitystory.fragment

import androidx.lifecycle.Observer
import com.a360vrsh.library.arouter.ARouterUtils
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.user.AboutUsActivity
import com.a360vrsh.pansmartcitystory.activity.user.DiyShareActivity
import com.a360vrsh.pansmartcitystory.activity.user.ReceiptCodeActivity
import com.a360vrsh.pansmartcitystory.adapter.HomeFunctionAdapter
import com.a360vrsh.pansmartcitystory.bean.FunctionBean
import com.a360vrsh.pansmartcitystory.util.DataUtils
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.home.StoreViewModel
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.store_fragment.*

class StoreFragment : BaseFragment() {
    private var functionAdapter: HomeFunctionAdapter? = null
    private var otherFunctionAdapter: HomeFunctionAdapter? = null

    companion object {
        fun newInstance() = StoreFragment()
    }

    private lateinit var viewModel: StoreViewModel


    override fun getLayoutID(): Int {
        return R.layout.store_fragment
    }

    override fun initView() {

        viewModel = initViewModel(StoreViewModel::class.java) as StoreViewModel

        refreshLayout.setOnRefreshListener {
            refreshLayout.finishRefresh()
        }
        refreshLayout.isEnableLoadmore = false

        RecyclerViewUtil.setGridManager(requireContext(), rv_function, 4)
        functionAdapter = HomeFunctionAdapter(DataUtils.getStoreFunction(requireContext()))
        rv_function.adapter = functionAdapter

        RecyclerViewUtil.setGridManager(requireContext(), rv_other_function, 4)
        otherFunctionAdapter =
            HomeFunctionAdapter(DataUtils.getStoreOtherFunction(requireContext()))
        rv_other_function.adapter = otherFunctionAdapter
    }

    override fun initListener() {
        otherFunctionAdapter?.setOnItemClickListener { adapter, view, position ->

            when (position) {
                0 -> {
                    gotoActivity(ReceiptCodeActivity::class.java)
                }
                1 -> {
//                    ARouterUtils.navigation(ARouterConstant.ACTIVITY_USER_ABOUT_US)
                    gotoActivity(AboutUsActivity::class.java)
                }
                2 -> {

                    UiUtil.goLogin(requireContext())
                    //viewModel.loginOut(requireContext(), true)
                }
            }
        }
        functionAdapter?.setOnItemClickListener { adapter, view, position ->
            val item = adapter.getItem(position) as FunctionBean
            when (position) {
                4 -> {
                    viewModel.getStorePano(requireContext(), MMKVUtil.getStoreId(), true)
                }

                else -> {
                    ARouterUtils.navigation(item.url)
                }
            }

        }
    }

    override fun initObserver() {
        viewModel.currentUserLiveData.observe(this, Observer {

        })
        viewModel.storePanoLiveData.observe(this, Observer {
            it.data?.apply {
                if (this.pano_id.isNullOrEmpty()) {
                    showToast("您的本地全景未创建/未审核通过或未启用,暂无法使用此功能")
                } else {
                    gotoActivity(DiyShareActivity::class.java)
                }
            }

        })
        viewModel.loginOutLiveData.observe(this, Observer {
            UiUtil.goLogin(requireContext())
        })
    }

    override fun initData() {

    }

    override fun initImmersionBar() {

        activity?.let {
            ImmersionBar.with(it)
                .statusBarColor(R.color.library_transparent)
                .statusBarDarkFont(false)
                .init()
        }
    }

}