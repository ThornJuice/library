package com.a360vrsh.pansmartcitystory.activity.login

import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.UpdatePwdViewModel
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.noober.background.drawable.DrawableCreator
import kotlinx.android.synthetic.main.activity_update_pwd.*

/**
 * 修改密码
 * */
class UpdatePassWordActivity : BaseTitleActivity(), TextWatcher {
    private val viewModel: UpdatePwdViewModel by lazy {
        initViewModel(UpdatePwdViewModel::class.java) as UpdatePwdViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_update_pwd
    }

    override fun initView() {
        titleText.text = "修改密码"
    }


    override fun initListener() {
        edt_pwd.addTextChangedListener(this)
        edt_pwd.addTextChangedListener(this)
        edt_new_pwd.addTextChangedListener(this)
        edt_repeat_new_pwd.addTextChangedListener(this)
        tv_submit.setSingleClick {

            KeyboardUtils.hideSoftInput(this@UpdatePassWordActivity)
            if (edt_new_pwd.text.toString() != edt_repeat_new_pwd.text.toString()) {
                showToast("两次密码输入不一致")
            } else {
                viewModel.submit(
                    getContext(),
                    edt_pwd.text.toString().trim(),
                    edt_new_pwd.text.toString().trim(),
                    edt_repeat_new_pwd.text.toString().trim(), true
                )
            }

        }
        tv_go_forget_pwd.setSingleClick {

            gotoActivity(ForgetPwdActivity::class.java)

        }
    }

    override fun initData() {


    }

    override fun initObserver() {

        viewModel.updateSuccessLiveData.observe(this, Observer {
            showToast("修改成功")
            UiUtil.goLogin(getContext())
        })

    }

    override fun afterTextChanged(s: Editable?) {
        if (edt_pwd.text.toString().length > 5 &&
            edt_new_pwd.text.toString().length > 5 &&
            edt_repeat_new_pwd.text.toString().length > 5
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

}