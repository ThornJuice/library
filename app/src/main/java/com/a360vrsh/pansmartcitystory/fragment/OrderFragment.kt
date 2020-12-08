package com.a360vrsh.pansmartcitystory.fragment

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.bean.GoodsTabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_order.*

//订单状态status: all=全部,unpaid=待支付,unshipped=待发货,unreceipt=待收货,unused=待使用,complete=已完成,comment=待评价,all_order=全部订单(不包含退款)
class OrderFragment : BaseFragment() {
    private var fragmentsList = ArrayList<Fragment>()

    private val mTitles = arrayListOf("待处理", "进行中", "退款售后", "订单评价", "全部")
    private val mStatus = arrayListOf("unshipped", "ongoing", "", "", "all")
    private val mTabEntities = ArrayList<CustomTabEntity>()

    companion object {
        fun newInstance() = OrderFragment()
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_order
    }

    override fun initView() {

    }

    override fun initObserver() {

    }

    override fun initListener() {

    }

    override fun initData() {
        setVpData(mTitles)
    }

    private fun setVpData(list: List<String>) {
        val mIconSelectIds = intArrayOf(
            R.mipmap.ic_order_01,
            R.mipmap.ic_order_02,
            R.mipmap.ic_order_03,
            R.mipmap.ic_order_04,
            R.mipmap.ic_order_05
        )
        val mIconUnSelectIds = intArrayOf(
            R.mipmap.ic_order_01,
            R.mipmap.ic_order_02,
            R.mipmap.ic_order_03,
            R.mipmap.ic_order_04,
            R.mipmap.ic_order_05
        )
        val tabs = ArrayList<String>()
        for (i in list.indices) {
            mTabEntities.add(
                GoodsTabEntity(
                    mTitles[i],
                    mIconSelectIds[i],
                    mIconUnSelectIds[i]
                )
            )

            tabs.add(list[i])
            if (i == 2) {
                val fragment = RefundFragment.newInstance()
                fragmentsList.add(fragment)
            } else if (i == 3) {
                val fragment = EvaluateListFragment.newInstance()
                fragmentsList.add(fragment)
            } else {
                val fragment = OrderListFragment.newInstance(mStatus[i])
                fragmentsList.add(fragment)
            }

        }
        val adapter =
            object : ViewPageAdapter(childFragmentManager, fragmentsList as List<Fragment>) {
                @Nullable
                override fun getPageTitle(position: Int): CharSequence {
                    return tabs[position]
                }

            }
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = tabs.size
        tabLayout.setViewPager(viewPager)
//        tabLayout.setTabData(mTabEntities)
//        tabLayout.setOnTabSelectListener(object : OnTabSelectListener {
//            override fun onTabSelect(position: Int) {
//                viewPager.currentItem = position
//            }
//
//            override fun onTabReselect(position: Int) {
//
//            }
//
//        })
//        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                tabLayout.currentTab = position
//            }
//
//        })
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