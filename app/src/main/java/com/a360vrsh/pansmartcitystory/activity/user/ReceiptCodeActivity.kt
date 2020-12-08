package com.a360vrsh.pansmartcitystory.activity.user

import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.a360vrsh.pansmartcitystory.util.showToast

/**
 *我的收款码
 * */
class ReceiptCodeActivity : BaseTitleActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_receipt_code
    }

    override fun initView() {
        titleText.text = "我的收款码"
        tvRight.text = "保存到手机"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

    }


    override fun initListener() {
        llRight.setSingleClick {
            showToast("save")
        }
    }

    override fun initObserver() {

    }

    override fun initData() {
    }

}