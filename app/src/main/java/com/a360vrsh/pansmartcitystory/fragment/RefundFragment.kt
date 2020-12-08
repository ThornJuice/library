package com.a360vrsh.pansmartcitystory.fragment

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.a360vrsh.library.adapter.ViewPageAdapter
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.pansmartcitystory.R
import kotlinx.android.synthetic.main.fragment_refund.*

//订单状态:all=全部,under_review=审核中,review_success=同意退款,review_fail=拒绝退款
class RefundFragment : BaseFragment() {
    private var fragmentsList = ArrayList<RefundListFragment>()

    private val mTabTitles = arrayListOf("待处理", "全部")
    private val mStatus = arrayListOf("under_review", "all")

    companion object {
        fun newInstance() = RefundFragment()
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_refund
    }

    override fun initView() {

    }

    override fun initObserver() {

    }

    override fun initListener() {

    }

    override fun initData() {
        setVpData(mTabTitles)
    }

    override fun initImmersionBar() {

    }

    private fun setVpData(list: List<String>) {
        val tabs = ArrayList<String>()
        for (i in list.indices) {
            tabs.add(list[i])
            val fragment = RefundListFragment.newInstance(mStatus[i])
            fragmentsList.add(fragment)
        }


        val adapter =
            object : ViewPageAdapter(childFragmentManager, fragmentsList as List<Fragment>) {
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