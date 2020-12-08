package com.a360vrsh.library.fragment

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.library_fragment_view_pager_in.*

/**
 * 带viewpager的Fragment模板
 * */
class ViewPagerInFragment : BaseFragment() {
    var fragmentsList = ArrayList<SimpleListWithPageFragment>()

    val tabTitleList = arrayListOf("全部", "选项2", "选项3", "选项4", "选项5")
    val tabIdList = arrayListOf("1", "2", "3", "4", "5")


    companion object {
        private const val TAG = "ViewPagerInFragment"

        @JvmStatic
        fun newInstance() =
            ViewPagerInFragment().apply {
                arguments = Bundle().apply {
//                    putString("ARG_PARAM1", param1)

                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.library_fragment_view_pager_in
    }

    override fun initView() {
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun initListener() {

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

    override fun initImmersionBar() {
//        ImmersionBar.with(context as Activity)
//            .statusBarColor(R.color.library_white)
//            .statusBarDarkFont(true)
//            .init()
    }
}