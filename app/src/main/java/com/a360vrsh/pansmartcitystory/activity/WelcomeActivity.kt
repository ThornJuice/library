package com.a360vrsh.pansmartcitystory.activity

import android.Manifest
import android.os.Handler
import com.a360vrsh.library.base.BaseActivity
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.login.LoginActivity
import com.a360vrsh.pansmartcitystory.util.ConstantUtil
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.alibaba.android.arouter.facade.annotation.Route
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

@Route(path = "/app/WelcomeActivity")
class WelcomeActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {
    override fun initView() {

    }

    override fun initListener() {
    }

    override fun initData() {
        startPermissionsTask()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }


    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        showToast("权限被拒绝，将会影响您的使用体验！")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        showToast("权限已申请")

        Handler().postDelayed({
            gotoActivity(LoginActivity::class.java, true)
        }, 300)

//        gotoActivity(UpLoadImageActivity::class.java)
    }


    val LOCATION_AND_CONTACTS = arrayOf(
        Manifest.permission.CALL_PHONE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @AfterPermissionGranted(ConstantUtil.RC_LOCATION_CONTACTS_PERM)
    private fun startPermissionsTask() {
        //检查是否获取该权限
        if (hasPermissions()) {
            //具备权限 直接进行操作
            Handler().postDelayed({
                if (MMKVUtil.getString("ticket").isNullOrEmpty()) {
                    gotoActivity(LoginActivity::class.java, true)
                } else {

                    UiUtil.goMain(
                        getContext(),
                        MMKVUtil.getString("status", "2"),
                        MMKVUtil.getString("store_type", "0")
                    )

                    this.finish()

                }

            }, 300)

        } else {
            //权限拒绝 申请权限
            //第二个参数是被拒绝后再次申请该权限的解释
            //第三个参数是请求码
            //第四个参数是要申请的权限
            EasyPermissions.requestPermissions(
                this,
                "为了不影响您的使用体验，我们将申请部分权限",
                ConstantUtil.RC_LOCATION_CONTACTS_PERM,
                *LOCATION_AND_CONTACTS
            )
        }
    }

    /**
     * 判断是否添加了权限
     * @return true
     */
    private fun hasPermissions(): Boolean {
        return EasyPermissions.hasPermissions(this, *LOCATION_AND_CONTACTS)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // 将结果转发到EasyPermissions
        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions, grantResults, this@WelcomeActivity
        )
    }
}