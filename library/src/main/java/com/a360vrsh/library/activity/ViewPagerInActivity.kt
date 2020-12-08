package com.a360vrsh.library.activity

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.baselibrary.R
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.base.BaseActivity
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.fragment.SimpleListWithPageFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.library_activity_view_pager_in.*

/**
 *带ViewPager的Activity模板
 * */
class ViewPagerInActivity : BaseTitleActivity() {
    var fragmentsList = ArrayList<SimpleListWithPageFragment>()

    val tabTitleList = arrayListOf("全部", "选项2", "选项3", "选项4", "选项5")
    val tabIdList = arrayListOf("1", "2", "3", "4", "5")

    override fun getLayoutId(): Int {
        return R.layout.library_activity_view_pager_in
    }

    override fun initView() {

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
            object : ViewPageAdapter(supportFragmentManager, fragmentsList as List<Fragment>) {
                @Nullable
                override fun getPageTitle(position: Int): CharSequence {
                    return tabs[position]
                }
            }
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = tabs.size
        tabLayout.setupWithViewPager(view_pager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}