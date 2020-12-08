package com.a360vrsh.pansmartcitystory.activity.login

import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.ToastUtil
import com.github.ihsg.patternlocker.OnPatternChangeListener
import com.github.ihsg.patternlocker.PatternLockerView
import com.tencent.mmkv.MMKV
import kotlinx.android.synthetic.main.activity_pattern_lock.*

/**
 * 手势解锁
 * */
class PatternLockActivity : BaseTitleActivity() {
    override fun initView() {
        patternLockerView.setOnPatternChangedListener(object : OnPatternChangeListener {
            override fun onChange(view: PatternLockerView, hitIndexList: List<Int>) {
                LogUtil.e("PatternLockActivity", "onChange....size:" + hitIndexList.size)
            }

            override fun onClear(view: PatternLockerView) {
                LogUtil.e("PatternLockActivity", "onClear:")
            }

            override fun onComplete(view: PatternLockerView, hitIndexList: List<Int>) {

//                hitIndexList?.forEach {
//
//                    Logger.e("PatternLockActivity", "onComplete..." + it)
//                }
                val result = hitIndexList.joinToString(",")
                LogUtil.e("PatternLockActivity", "result..." + result)
                val old = MMKV.defaultMMKV().decodeString("userId")
                LogUtil.e("PatternLockActivity", "old..." + old)
                if (old == result) {
                    ToastUtil.show("success")
                } else {
                    ToastUtil.show("error")
                }
//                MMKV.defaultMMKV().encode("userId", result)

            }

            override fun onStart(view: PatternLockerView) {
                LogUtil.e("PatternLockActivity", "onStart")
            }

        })
    }
    override fun initObserver() {

    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_pattern_lock
    }

}