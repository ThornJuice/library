package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.TimerUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.AppUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus

/**
 * 注册
 * */
class RegisterActivity : BaseTitleActivity(), TextWatcher {
    private lateinit var viewModel: RegisterViewModel
    private var timerUtil: TimerUtil? = null

    private  var isChecked: Boolean = false//用户协议
    private lateinit var phoneVal: String

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        titleText.text = "注册"
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
                viewModel.register(
                    getContext(),
                    edt_phone.text.toString(),
                    edt_code.text.toString(),
                    edt_pwd.text.toString(),
                    edt_repeat_pwd.text.toString(),
                    true
                )

            }

        }

        iv_agreement.setOnClickListener {

            if (isChecked) {
                isChecked = false
                iv_agreement.setImageResource(R.mipmap.icon_round_unchecked)

                AppUtil.setSubmitUnable(getContext(), tv_submit)
            } else {
                isChecked = true
                iv_agreement.setImageResource(R.mipmap.icon_round_checked)
                if (edt_phone.text.toString().length == 11 && edt_code.text.length == 6
                    && edt_pwd.text.toString().length > 5 && edt_repeat_pwd.text.toString().length > 5 && isChecked
                ) {
                    AppUtil.setSubmitEnable(getContext(), tv_submit)
                }
            }
        }
        tv_agreement_url.setOnClickListener {

        }
    }

    override fun initData() {


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
        tv_get_code.setOnClickListener {
            phoneVal = edt_phone.text.toString()
            if (phoneVal.length != 11) {
                showToast("请输入正确的手机号")
            } else {
                viewModel.getCode(getContext(), phoneVal, true)
            }

        }
    }

    override fun initObserver() {
        viewModel.codeResponse.observe(this, Observer {
            showToast("验证码发送成功")
            timerUtil?.start()
        })
        viewModel.registerResponse.observe(this, Observer {
            showToast("注册成功")
            gotoActivity(LoginActivity::class.java, true)
            EventBus.getDefault().post(EventBean(EventID.REGISTER_SUCCESS))
        })
    }

    override fun afterTextChanged(s: Editable) {
        if (edt_phone.text.toString().length == 11 && edt_code.text.length == 6
            && edt_pwd.text.toString().length > 5 && edt_repeat_pwd.text.toString().length > 5 && isChecked
        ) {
            AppUtil.setSubmitEnable(getContext(), tv_submit)
        } else {
            AppUtil.setSubmitUnable(getContext(), tv_submit)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }


}