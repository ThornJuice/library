package com.a360vrsh.pansmartcitystory.fragment

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.fragment.SimpleListWithPageFragment
import com.a360vrsh.pansmartcitystory.R
import com.google.android.material.tabs.TabLayout
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_discover.*


class DiscoverFragment : BaseFragment() {
    var fragmentsList = ArrayList<SimpleListWithPageFragment>()

    val tabTitleList = arrayListOf("全部", "选项2", "选项3", "选项4", "选项5")
    val tabIdList = arrayListOf("1", "2", "3", "4", "5")
    override fun getLayoutID(): Int {
        return R.layout.fragment_discover
    }

    override fun initView() {

    }

    override fun initObserver() {

    }

    override fun initListener() {

    }

    override fun initData() {
        setVpData(tabTitleList)
    }



    private fun setVpData(list: List<String>) {
        val tabs = ArrayList<String>()
        for (i in list.indices) {
            tabs.add(list[i])
            val fragment = SimpleListWithPageFragment.newInstance(tabIdList[i])
            fragmentsList.add(fragment)
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
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    companion object {
        fun newInstance() = DiscoverFragment()
        private const val TAG = "DiscoverFragment"
    }
    override fun initImmersionBar() {
        activity?.let {
            ImmersionBar.with(it)
                .statusBarColor(R.color.library_transparent)
                .statusBarDarkFont(true)
                .titleBarMarginTop(ll_title)
                .init()
        }
    }
}