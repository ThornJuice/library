package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.viewmodel.user.LoginViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ConvertUtils
import com.noober.background.drawable.DrawableCreator
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.EventBus

/**
 * 账号密码登录
 * */
@Route(path = ARouterConstant.ACTIVITY_PERSON_LOGIN)
class LoginActivity : BaseTitleActivity(), TextWatcher {
    private val viewModel: LoginViewModel by lazy {
        initViewModel(LoginViewModel::class.java) as LoginViewModel
    }

    private var phoneVal: String? = null
    private var pwdVal: String? = null
    private var isRemember: Boolean = false//记住密码
    private var isOpen: Boolean = false//显示隐藏密码


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        removeTitleBar()

        edt_phone.setText(MMKVUtil.getPhone())
        isRemember = MMKVUtil.getBool(MMKVUtil.REMEMBER_PWD)
        if (isRemember) {//记住密码
            iv_remember_pwd.setImageResource(R.mipmap.icon_square_checked)
            edt_pwd.setText(MMKVUtil.getString(MMKVUtil.PWD))
            tv_submit.isEnabled = true
            tv_submit.setTextColor(ContextCompat.getColor(getContext(), R.color.library_white))
            tv_submit.background =
                DrawableCreator.Builder().setCornersRadius(ConvertUtils.dp2px(22.5f).toFloat())
                    .setPressedSolidColor(
                        ContextCompat.getColor(getContext(), R.color.mainColorDark),
                        ContextCompat.getColor(getContext(), R.color.mainColor)
                    )
                    .build()
        }
    }


    override fun initListener() {
        edt_phone.addTextChangedListener(this)
        edt_pwd.addTextChangedListener(this)
        //去注册
        tv_go_register.setSingleClick {
            gotoActivity(RegisterActivity::class.java)
        }
        //验证码登录
        tv_go_login_by_code.setSingleClick {
            gotoActivity(LoginByCodeActivity::class.java)
        }
        //忘记密码
        tv_go_forget_pwd.setSingleClick {
            gotoActivity(ForgetPwdActivity::class.java)
        }
        //记住密码
        ll_remember_pwd.setOnClickListener {

            if (isRemember) {
                isRemember = false
                iv_remember_pwd.setImageResource(R.mipmap.icon_square_unchecked)
            } else {
                isRemember = true
                iv_remember_pwd.setImageResource(R.mipmap.icon_square_checked)
            }
        }
        iv_clear_phone.setOnClickListener {
            edt_phone.setText("")
        }
        iv_open_pwd.setOnClickListener {

            if (isOpen) {
                isOpen = false
                edt_pwd.transformationMethod = PasswordTransformationMethod.getInstance()
                iv_open_pwd.setImageResource(R.mipmap.icon_eyes_close)
            } else {
                isOpen = true
                edt_pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                iv_open_pwd.setImageResource(R.mipmap.icon_eyes_open)
            }
        }
        //登录
        tv_submit.setSingleClick {
            phoneVal = edt_phone.text.toString()
            pwdVal = edt_pwd.text.toString()

            MMKVUtil.putString(MMKVUtil.PHONE, phoneVal)
            MMKVUtil.putString(MMKVUtil.PWD, pwdVal)
            MMKVUtil.putBool(MMKVUtil.REMEMBER_PWD, isRemember)

            viewModel.login(getContext(), phoneVal, pwdVal, true)
        }
    }

    override fun initObserver() {
        //登录成功回调
        viewModel.loginBean.observe(this, Observer {

            MMKVUtil.putString(MMKVUtil.TICKET, it.data.ticket)
            //checkTicket
            viewModel.checkTicket(getContext(), true)
        })
        viewModel.checkTicketLiveData.observe(this, Observer {
            //店铺状态:0=编辑中,1=待审核,2=审核通过,3=审核拒绝


            MMKVUtil.saveLoginInfo(it.data.store_id, it.data.status, it.data.store_type)
            UiUtil.goMain(getContext(), it.data.status, it.data.store_type)
            EventBus.getDefault().post(EventBean(EventID.LOGIN_SUCCESS))
        })

        viewModel.onErrorLiveData.observe(this, Observer {
            MMKVUtil.clearLoginInfo()
        })
    }

    override fun initData() {


    }

    override fun afterTextChanged(s: Editable?) {
        if (edt_phone.text.toString().length == 11 && edt_pwd.text.toString().length > 5) {
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

    override fun onEventMainThread(event: EventBean) {
        super.onEventMainThread(event)
        if (event.id == EventID.REGISTER_SUCCESS || event.id == EventID.LOGIN_SUCCESS) {
            finish()
        }
    }
}