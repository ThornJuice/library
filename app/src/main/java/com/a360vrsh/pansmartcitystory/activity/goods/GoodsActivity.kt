package com.a360vrsh.pansmartcitystory.activity.goods

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.fragment.GoodsListFragment
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_goods.*

/**
 *商品
 * */
@Route(path = ARouterConstant.ACTIVITY_GOODS)

//审核状态:1=创建,2=提交审核,3=审核通过,4=审核不通过 传值与实际状态不一致
class GoodsActivity : BaseTitleActivity() {
    private var fragmentsList = ArrayList<GoodsListFragment>()

    private val tabTitleList = arrayListOf("已上架", "待审核", "审核未通过", "已下架")
    private val audits = arrayListOf("", "5", "4", "")//审核状态
    private val shelfs = arrayListOf("1", "", "", "2")//上架状态
    override fun getLayoutId(): Int {
        return R.layout.activity_goods
    }

    override fun initView() {
        titleText.text = "我的商品"
        tvRight.text = "+发布商品"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

    }


    override fun initListener() {
        llRight.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", MMKVUtil.getStoreType())
            gotoActivity(EditGoodsActivity::class.java, false, bundle)
        }
    }

    override fun initObserver() {

    }

    override fun initData() {
        setVpData(tabTitleList)
    }

    private fun setVpData(list: List<String>) {
        val tabs = ArrayList<String>()
        for (i in list.indices) {
            tabs.add(list[i])
            val fragment = GoodsListFragment.newInstance(audits[i], shelfs[i])
            fragmentsList.add(fragment)
        }
        val adapter =
            object : ViewPageAdapter(supportFragmentManager, fragmentsList as List<Fragment>) {
                @Nullable
                override fun getPageTitle(position: Int): CharSequence {
                    return tabs[position]
                }
            }
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = tabs.size

        tabLayout.setViewPager(view_pager)

    }
}