package com.a360vrsh.pansmartcitystory.activity.user

import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.login.UpdatePassWordActivity
import com.a360vrsh.pansmartcitystory.activity.login.UpdatePhoneActivity
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_account_safe.*

/**
 *账户安全
 * */
@Route(path = ARouterConstant.ACTIVITY_USER_ACCOUNT_SAFE)
class AccountSafeActivity : BaseTitleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_account_safe
    }

    override fun initView() {
        titleText.text = "账户安全"
    }


    override fun initListener() {
        ll_update_pwd.setSingleClick {

            gotoActivity(UpdatePassWordActivity::class.java)

        }
        ll_update_phone.setSingleClick {

            gotoActivity(UpdatePhoneActivity::class.java)

        }
    }

    override fun initObserver() {

    }

    override fun initData() {
    }

}