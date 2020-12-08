package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.TimerUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.LoginByCodeViewModel
import com.blankj.utilcode.util.ConvertUtils
import com.noober.background.drawable.DrawableCreator
import kotlinx.android.synthetic.main.activity_login_by_code.*
import org.greenrobot.eventbus.EventBus

/**
 * 验证码登录
 * */
class LoginByCodeActivity : BaseTitleActivity(), TextWatcher {
    private lateinit var viewModel: LoginByCodeViewModel
    private var timerUtil: TimerUtil? = null
    private lateinit var phoneVal: String

    override fun getLayoutId(): Int {
        return R.layout.activity_login_by_code
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this).get(LoginByCodeViewModel::class.java)

        titleText.text = "验证码登录"
        removeTitleBar()
        initCountDownTimer()
    }


    override fun initListener() {
        edt_phone.addTextChangedListener(this)
        edt_code.addTextChangedListener(this)
        //去注册
        tv_go_register.setOnClickListener {
            gotoActivity(RegisterActivity::class.java)
        }
        //密码登录
        tv_go_login_by_pwd.setOnClickListener {
            finish()
        }
        //忘记密码
        tv_go_forget_pwd.setOnClickListener {
            gotoActivity(ForgetPwdActivity::class.java)
        }
        iv_clear_phone.setOnClickListener {
            edt_phone.setText("")
        }
        //登录
        tv_submit.setOnClickListener {
            phoneVal = edt_phone.text.toString()
            viewModel.loginByCode(
                getContext(),
                phoneVal,
                edt_code.text.toString(),
                true
            )
        }
    }
    override fun initObserver() {
        viewModel.getCodeResponse.observe(this, Observer {
            showToast("验证码发送成功")
            timerUtil?.start()

        })

        viewModel.loginResponse.observe(this, Observer {
            MMKVUtil.putString(MMKVUtil.TICKET, it.data.ticket)
            //checkTicket
            viewModel.checkTicket(getContext(), true)
        })

        viewModel.checkTicketLiveData.observe(this, Observer {
            //店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝
            EventBus.getDefault().post(EventBean(EventID.LOGIN_SUCCESS))

            MMKVUtil.saveLoginInfo(it.data.store_id, it.data.status, it.data.store_type)
            UiUtil.goMain(getContext(), it.data.status, it.data.store_type)


        })

        viewModel.onErrorLiveData.observe(this, Observer {
            MMKVUtil.clearLoginInfo()
        })
    }
    override fun initData() {

    }

    override fun afterTextChanged(s: Editable?) {
        if (edt_phone.text.toString().length == 11 && edt_code.text.toString().length == 6) {
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
        tv_get_code.setOnClickListener {
            phoneVal = edt_phone.text.toString()
            if (phoneVal.length != 11) {
                showToast("请输入正确的手机号")
            } else {
                viewModel.getCode(getContext(), phoneVal, true)
            }

        }
    }

    override fun onEventMainThread(event: EventBean) {
        super.onEventMainThread(event)
        if (event.id == EventID.REGISTER_SUCCESS || event.id == EventID.LOGIN_SUCCESS) {
            finish()
        }
    }
}