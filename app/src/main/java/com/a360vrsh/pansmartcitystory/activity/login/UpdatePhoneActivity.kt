package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.TimerUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.UpdatePhoneViewModel
import com.blankj.utilcode.util.ConvertUtils
import com.noober.background.drawable.DrawableCreator
import kotlinx.android.synthetic.main.activity_update_phone.*

/**
 * 修改登录手机号
 * */
class UpdatePhoneActivity : BaseTitleActivity(), TextWatcher {
    private val viewModel: UpdatePhoneViewModel by lazy {
        initViewModel(UpdatePhoneViewModel::class.java) as UpdatePhoneViewModel
    }
    private var phone: String? = null
    private val timerUtil: TimerUtil by lazy {
        TimerUtil(1000 * 60, 1000)
    }
    private val newTimerUtil: TimerUtil by lazy {
        TimerUtil(1000 * 60, 1000)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_update_phone
    }

    override fun initView() {
        titleText.text = "修改手机号"
        phone = MMKVUtil.getPhone()
        tv_phone.text = phone
        initCountDownTimer(timerUtil, tv_get_code)
        initCountDownTimer(newTimerUtil, tv_get_new_code)
    }


    override fun initListener() {
        edt_new_phone.addTextChangedListener(this)
        edt_code.addTextChangedListener(this)
        edt_new_code.addTextChangedListener(this)
        tv_submit.setSingleClick {
            viewModel.submit(
                getContext(),
                edt_new_phone.text.toString().trim(),
                edt_code.text.toString().trim(),
                edt_new_code.text.toString().trim(),
                true
            )
        }
        tv_get_code.setSingleClick {

            phone?.let {
                viewModel.getCode(getContext(), it, true)
            }

        }
        tv_get_new_code.setSingleClick {

            val newPhoneVal = edt_new_phone.text.toString()
            if (newPhoneVal.length != 11) {
                showToast("请输入正确的手机号")
            } else {
                viewModel.getNewCode(getContext(), newPhoneVal, true)
            }

        }
    }

    override fun initData() {


    }

    override fun initObserver() {
        viewModel.updateSuccessLiveData.observe(this, Observer {
            showToast("修改成功")
            UiUtil.goLogin(getContext())
        })
        viewModel.codeLiveData.observe(this, Observer {
            showToast("验证码发送成功")
            timerUtil.start()

        })
        viewModel.newCodeLiveData.observe(this, Observer {
            showToast("验证码发送成功")
            newTimerUtil.start()

        })
    }

    override fun afterTextChanged(s: Editable?) {
        if (edt_code.text.length == 6 &&
            edt_new_code.text.toString().length == 6 &&
            edt_new_phone.text.toString().length == 11
        ) {
            tv_submit.isEnabled = true
            tv_submit.setTextColor(ContextCompat.getColor(getContext(), R.color.library_white))
            tv_submit.background =
                DrawableCreator.Builder().setCornersRadius(ConvertUtils.dp2px(22.5f).toFloat())
                    .setPressedSolidColor(
                        ContextCompat.getColor(getContext(), R.color.mainColorDark),
                        ContextCompat.getColor(getContext(), R.color.mainColor)
                    )
                    .build()
        } else {
            tv_submit.isEnabled = false
            tv_submit.setTextColor(ContextCompat.getColor(getContext(), R.color.library_text_999))
            tv_submit.background =
                DrawableCreator.Builder().setCornersRadius(ConvertUtils.dp2px(22.5f).toFloat())
                    .setSolidColor(ContextCompat.getColor(getContext(), R.color.unable_gray))
                    .build()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    private fun initCountDownTimer(timerUtil: TimerUtil, textView: TextView) {
        timerUtil.setCountDownTimerListener(object : TimerUtil.CountDownTimerListener {
            override fun startCount(millsUtilFinished: Long) {
                textView.setText("剩余(" + millsUtilFinished / 1000 + "s)")
//                mTvTimer.setBackgroundResource(R.drawable.shape_gray_solid_corner_5)
                textView.setTextColor(
                    ContextCompat.getColor(
                        getContext(),
                        R.color.library_text_999
                    )
                )
                textView.isEnabled = false
            }

            override fun finishCount() {
                textView.text = "获取验证码"
//                tv_get_code.setBackgroundResource(R.drawable.shape_orange_solid_corner_5)
                textView.setTextColor(
                    ContextCompat.getColor(
                        getContext(),
                        R.color.mainColor
                    )
                )
                textView.isEnabled = true
            }
        })
    }
}