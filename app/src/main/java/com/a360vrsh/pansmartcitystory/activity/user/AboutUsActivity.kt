package com.a360vrsh.pansmartcitystory.activity.user

import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.IntentUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.getContext
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_about_us.*

/**
 *关于我们
 * */
@Route(path = ARouterConstant.ACTIVITY_USER_ABOUT_US)
class AboutUsActivity : BaseTitleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_about_us
    }

    override fun initView() {
        titleText.text = "关于我们"
    }


    override fun initListener() {
        ll_update.setSingleClick {

        }
        ll_feed_back.setSingleClick {
            gotoActivity(FeedBackActivity::class.java)
        }
        ll_contact.setSingleClick {
            IntentUtil.callPhone(getContext(), "")
        }
    }

    override fun initObserver() {

    }

    override fun initData() {
    }

}