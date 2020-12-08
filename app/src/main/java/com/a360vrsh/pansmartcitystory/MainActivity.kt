package com.a360vrsh.pansmartcitystory

import android.view.KeyEvent
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.a360vrsh.library.base.BaseActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.ToastUtil
import com.a360vrsh.pansmartcitystory.activity.login.LoginActivity
import com.a360vrsh.pansmartcitystory.fragment.HomeFragment
import com.a360vrsh.pansmartcitystory.fragment.MarketingFragment
import com.a360vrsh.pansmartcitystory.fragment.OrderFragment
import com.a360vrsh.pansmartcitystory.fragment.StoreFragment
import com.a360vrsh.pansmartcitystory.viewmodel.home.MainViewModel
import com.mylhyl.circledialog.CircleDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var viewModel: MainViewModel
    private var fragmentManager: FragmentManager? = null
    private var start: Long = 0
    private var homeFragment: HomeFragment? = null
    private var orderFragment: OrderFragment? = null
//    private var discoverFragment: DiscoverFragment? = null
    private var marketingFragment: MarketingFragment? = null
    private var storeFragment: StoreFragment? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        fragmentManager = supportFragmentManager
        rg_tab_bar.setOnCheckedChangeListener(this)
        rb_home.isChecked = true
    }

    override fun initListener() {

    }


    override fun initData() {


    }

    private fun hideAllFragment(fragmentTransaction: FragmentTransaction?) {

        homeFragment?.apply {
            fragmentTransaction?.hide(this)
        }
        orderFragment?.apply {
            fragmentTransaction?.hide(this)
        }
//        discoverFragment?.apply {
//            fragmentTransaction?.hide(this)
//        }
        marketingFragment?.apply {
            fragmentTransaction?.hide(this)
        }
        storeFragment?.apply {
            fragmentTransaction?.hide(this)
        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val fTransaction = fragmentManager?.beginTransaction()
        hideAllFragment(fTransaction)
        when (checkedId) {
            R.id.rb_home -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance()
                    fTransaction?.add(R.id.fl_container, homeFragment!!)
                } else {
                    fTransaction?.show(homeFragment!!)
                }
                fTransaction?.commitAllowingStateLoss()
            }
            R.id.rb_order -> {
                if (orderFragment == null) {
                    orderFragment = OrderFragment.newInstance()
                    fTransaction?.add(R.id.fl_container, orderFragment!!)
                } else {
                    fTransaction?.show(orderFragment!!)
                }
                fTransaction?.commitAllowingStateLoss()
            }
//            R.id.rb_discover -> {
//                if (discoverFragment == null) {
//                    discoverFragment = DiscoverFragment.newInstance()
//                    fTransaction?.add(R.id.fl_container, discoverFragment!!)
//                } else {
//                    fTransaction?.show(discoverFragment!!)
//                }
//                fTransaction?.commitAllowingStateLoss()
//            }
            R.id.rb_marketing -> {
                if (marketingFragment == null) {
                    marketingFragment = MarketingFragment.newInstance()
                    fTransaction?.add(R.id.fl_container, marketingFragment!!)
                } else {
                    fTransaction?.show(marketingFragment!!)
                }
                fTransaction?.commitAllowingStateLoss()
            }
            R.id.rb_store -> {
                if (storeFragment == null) {
                    storeFragment = StoreFragment.newInstance()
                    fTransaction?.add(R.id.fl_container, storeFragment!!)
                } else {
                    fTransaction?.show(storeFragment!!)
                }
                fTransaction?.commitAllowingStateLoss()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - start > 2000) {
                ToastUtil.show("再次点击退出程序")
//                SnackbarHelper.showSnackbarForShort(this@MainActivity, "再次点击退出程序")
                start = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onEventMainThread(event: EventBean?) {
        if (event?.id == EventID.GO_TO_LOGIN) {
//            gotoActivity(LoginActivity::class.java)
//            showAlert()
        }
    }

    fun showAlert() {
        CircleDialog.Builder()
            .setTitle("温馨提示")
            .setWidth(0.7f)
            .setCancelable(false)
            .setText("登录已过期,请重新登录")
            .setPositive("确定") {
                gotoActivity(LoginActivity::class.java)
            }
            .configPositive { params -> params.height = 45 }
            .show(supportFragmentManager)
    }
    override fun initImmersionBar() {

    }
}