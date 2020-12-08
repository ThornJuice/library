package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.TimerUtil
import com.a360vrsh.pansmartcitystory.MainActivity
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.store.AddBaseStoreInfoActivity
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.ForgetPwdViewModel
import com.blankj.utilcode.util.ConvertUtils
import com.noober.background.drawable.DrawableCreator
import kotlinx.android.synthetic.main.activity_forget_pwd.*

/**
 * 忘记密码
 * */
class ForgetPwdActivity : BaseTitleActivity(), TextWatcher {
    private lateinit var viewModel: ForgetPwdViewModel
    private lateinit var phoneVal: String
    private var timerUtil: TimerUtil? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_forget_pwd
    }

    override fun initView() {
        titleText.text = "忘记密码"

        viewModel = ViewModelProviders.of(this).get(ForgetPwdViewModel::class.java)

        initCountDownTimer()
    }


    override fun initListener() {
        edt_phone.addTextChangedListener(this)
        edt_pwd.addTextChangedListener(this)
        edt_code.addTextChangedListener(this)
        edt_repeat_pwd.addTextChangedListener(this)
        tv_submit.setOnClickListener {
            if (edt_pwd.text.toString() != edt_repeat_pwd.text.toString()) {
                showToast("两次密码输入不一致")
            } else {
                gotoActivity(AddBaseStoreInfoActivity::class.java)
            }

        }
        tv_get_code.setOnClickListener {
            phoneVal = edt_phone.text.toString()
            if (phoneVal.length != 11) {
                showToast("请输入正确的手机号")
            } else {
                viewModel.getCode(getContext(), phoneVal, true)
            }

        }
    }

    override fun initData() {


    }

    override fun initObserver() {
        viewModel.loginResponse.observe(this, Observer {
            MMKVUtil.putString("ticket", it.data.ticket)
            MMKVUtil.putString("phone", phoneVal)
            gotoActivity(MainActivity::class.java)
        })
        viewModel.getCodeResponse.observe(this, Observer {
            showToast("验证码发送成功")
            timerUtil?.start()

        })
    }

    override fun afterTextChanged(s: Editable?) {
        if (edt_phone.text.toString().length == 11 && edt_code.text.length == 6
            && edt_pwd.text.toString().length > 5 && edt_repeat_pwd.text.toString().length > 5
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

    private fun initCountDownTimer() {
        timerUtil = TimerUtil(1000 * 60, 1000)
        timerUtil?.setCountDownTimerListener(object : TimerUtil.CountDownTimerListener {
            override fun startCount(millsUtilFinished: Long) {
                tv_get_code.setText("剩余(" + millsUtilFinished / 1000 + "s)")
//                mTvTimer.setBackgroundResource(R.drawable.shape_gray_solid_corner_5)
                tv_get_code.setTextColor(
                    ContextCompat.getColor(
                        getContext(),
                        R.color.library_text_999
                    )
                )
                tv_get_code.isEnabled = false
            }

            override fun finishCount() {
                tv_get_code.text = "获取验证码"
//                tv_get_code.setBackgroundResource(R.drawable.shape_orange_solid_corner_5)
                tv_get_code.setTextColor(
                    ContextCompat.getColor(
                        getContext(),
                        R.color.mainColor
                    )
                )
                tv_get_code.isEnabled = true
            }
        })

    }
}