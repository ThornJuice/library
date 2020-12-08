package com.a360vrsh.pansmartcitystory.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.a360vrsh.library.activity.LocalWebViewActivity
import com.a360vrsh.library.adapter.HomeBannerAdapter
import com.a360vrsh.library.arouter.ARouterUtils
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.util.DataUtil
import com.a360vrsh.library.util.IntentUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.ArticleListAdapter
import com.a360vrsh.pansmartcitystory.adapter.HomeFunctionAdapter
import com.a360vrsh.pansmartcitystory.bean.FunctionBean
import com.a360vrsh.pansmartcitystory.bean.StoreInfoBean
import com.a360vrsh.pansmartcitystory.util.DataUtils
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.home.HomeViewModel
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : BaseFragment() {
    private lateinit var viewModel: HomeViewModel

    private var articleListAdapter: ArticleListAdapter? = null
    private var operation: String? = null//is_rest is_open
    private val homeFunctionAdapter: HomeFunctionAdapter by lazy {
        HomeFunctionAdapter(
            DataUtils.getHomeFunctionData(requireContext())
        )
    }

    override fun getLayoutID(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {

        viewModel = initViewModel(HomeViewModel::class.java) as HomeViewModel

        refreshLayout.setOnRefreshListener {
            getData()
        }
        refreshLayout.isEnableLoadmore = false
        initBanner()
        setMarqueeView(DataUtil.getArrayList(5, "滚动广告滚动广告滚动广告"))
        RecyclerViewUtil.setGridManager(requireContext(), rv_function, 4)

        rv_function.adapter = homeFunctionAdapter

        RecyclerViewUtil.setVerticalManager(requireContext(), rv_article)
        articleListAdapter = ArticleListAdapter(null)
        rv_article.adapter = articleListAdapter
    }

    private fun initBanner() {

        roll_banner.setAdapter(HomeBannerAdapter(roll_banner, context, DataUtil.getArrayList(5)))

    }

    override fun initObserver() {

        viewModel.storeInfoLiveData.observe(this, Observer {

            setUiData(it)
        })

        viewModel.singleBean.observe(viewLifecycleOwner, Observer {
            showToast(it?.data?.name)
            refreshLayout.finishRefresh()
        })
        viewModel.articleListLiveData.observe(viewLifecycleOwner, Observer {
            articleListAdapter?.setNewData(it.data)
            refreshLayout.finishRefresh()
        })
        viewModel.articleDetailLiveData.observe(this, Observer {
            val bundle = Bundle().apply {
                putString("title", it.data.title)
                putString("content", it.data.content)
            }
            gotoActivity(LocalWebViewActivity::class.java, false, bundle)

        })
        viewModel.areaCheckLiveData.observe(this, Observer {
            val value = it.data?.address
            tv_city.text = value?.substringAfterLast("-")

        })
        viewModel.onErrorLiveData.observe(viewLifecycleOwner, Observer {
            refreshLayout.finishRefresh()
        })
        viewModel.changeStoreStatusLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.getStoreInfo(requireContext(), MMKVUtil.getString(MMKVUtil.STORE_ID), true)
        })

    }

    /**
     * 设置ui数据
     * */
    private fun setUiData(storeInfoBean: StoreInfoBean?) {
        storeInfoBean?.data?.let {
            tv_store_name.text = it.name
            val status = it.status //店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝
            val isReset = it.industry.is_rest // 是否歇业
            val isOpen = it.industry.is_open//是否营业
            if (status == "2") {//审核通过
                if (isReset == "1") {
                    tv_store_status.text = "歇业中"
                    iv_store_status.setImageResource(R.mipmap.ic_status_close)
                } else {
                    if (isOpen == "1") {
                        tv_store_status.text = "营业中"
                        iv_store_status.setImageResource(R.mipmap.ic_status_open)
                    } else {
                        tv_store_status.text = "休息中"
                        iv_store_status.setImageResource(R.mipmap.ic_status_close)
                    }
                }

            } else if (status == "1") {
                tv_store_status.text = "审核中"
                iv_store_status.setImageResource(R.mipmap.ic_status_audit)
            } else if (status == "3") {
                tv_store_status.text = "审核拒绝"
                iv_store_status.setImageResource(R.mipmap.ic_status_refuse)
            }

            viewModel.areaCheck(requireContext(), it.province_id, it.city_id, it.region_id, true)

        }
    }

    override fun initListener() {
//        tv_share.setOnClickListener {
//            AppUtil.share(context, "标题", "xxx", "描述", "http://www.baidu.com")

//            ARouterUtils.navigation(ARouterConstant.ACTIVITY_PERSON_LOGIN)
//            gotoActivity(AddBaseStoreInfoActivity::class.java)
//        }
//        tv_more_article.setOnClickListener {//更多资讯
//            gotoActivity(ArticleActivity::class.java)
//        }
        homeFunctionAdapter.setOnItemClickListener { adapter, _, position ->
            val item = adapter.getItem(position) as FunctionBean
            if (position == 0) {
                UiUtil.goQrCodeActivity(requireActivity())
            } else {
                ARouterUtils.navigation(item.url)
            }

        }
        //关闭/打开店铺
        ll_store_status.setOnClickListener {
            if (tv_store_status.text.toString() == "营业中" || tv_store_status.text.toString() == "休息中") {
                operation = "is_rest"
                UiUtil.getDialog(requireContext(), "温馨提示", "您确定要关闭店铺?")
                    .setPositive("确定") {
                        if (tv_store_status.text.toString() == "营业中") {
                            viewModel.closeStore(
                                requireContext(),
                                MMKVUtil.getString(MMKVUtil.STORE_ID)
                            )
                        } else {
                            viewModel.changeStoreStatus(
                                requireContext(),
                                MMKVUtil.getString(MMKVUtil.STORE_ID),
                                "is_rest", true
                            )
                        }

                    }
                    .setNegative("取消") {}
                    .show(fragmentManager)
            } else if (tv_store_status.text.toString() == "歇业中") {
                operation = "is_open"
                UiUtil.getDialog(requireContext(), "温馨提示", "您确定要开启店铺?")
                    .setPositive("确定") {
                        if (tv_store_status.text.toString() == "营业中") {
                            viewModel.closeStore(
                                requireContext(),
                                MMKVUtil.getString(MMKVUtil.STORE_ID)
                            )
                        } else {
                            viewModel.changeStoreStatus(
                                requireContext(),
                                MMKVUtil.getString(MMKVUtil.STORE_ID),
                                "is_open", true
                            )
                        }

                    }
                    .setNegative("取消") {}
                    .show(fragmentManager)
            }


        }
        articleListAdapter?.apply {
            setOnItemClickListener { _, _, position ->
                getItem(position)?.id?.let {
                    viewModel.getArticleDetail(requireContext(), it, true)
                }

            }
        }
    }


    override fun initData() {

//        viewModel.getCurrentUser(context, true);
//        viewModel.getDetail2(context, "140960", true)
        //获取店铺信息
        getData()

    }

    private fun getData() {
        viewModel.getStoreInfo(requireContext(), MMKVUtil.getStoreId(), true)
        viewModel.getArticle(requireContext(), true)
    }

    override fun initImmersionBar() {

        activity?.let {
            ImmersionBar.with(it)
                .statusBarColor(R.color.library_transparent)
                .statusBarDarkFont(true)
                .titleBarMarginTop(title_group)
                .init()
        }
    }

    private fun setMarqueeView(list: List<String>) {
        val viewList = ArrayList<View>()
        for (i in list.indices) {
            val itemView = LayoutInflater.from(context).inflate(R.layout.item_marquee_view, null)
            val textView = itemView.findViewById<View>(R.id.tv_marquee) as TextView
            textView.text = list[i]
            viewList.add(itemView)
        }
        marqueeView.setViews(viewList)
    }


    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            data?.apply {
                val result = this.getStringExtra("codedContent")
                showToast(result)
                IntentUtil.startUri(requireContext(), result)
            }
        }
    }
}