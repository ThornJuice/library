package com.a360vrsh.pansmartcitystory.activity.common

import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.pansmartcitystory.R
import com.alibaba.android.arouter.facade.annotation.Route



@Route(path = ARouterConstant.ACTIVITY_QR_CODE)
class QrCoderActivity : BaseTitleActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_qr_coder
    }

    override fun initView() {
        titleText.text = "扫码"


    }


    override fun initListener() {
//        ivTorch.setSingleClick {
//
//            mCaptureHelper?.get
//        }
    }

    override fun initObserver() {

    }

    override fun initData() {
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }



}