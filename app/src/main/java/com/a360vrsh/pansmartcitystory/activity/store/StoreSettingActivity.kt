package com.a360vrsh.pansmartcitystory.activity.store


import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.fragment.FoodStoreSettingFragment
import com.a360vrsh.pansmartcitystory.fragment.OtherStoreSettingFragment
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *店铺设置
 * */
@Route(path = ARouterConstant.ACTIVITY_STORE_SETTING)
class StoreSettingActivity : BaseTitleActivity() {
    private var type: String? = "1"//1美食 3旅游   else其他
    private var foodStoreSettingFragment: FoodStoreSettingFragment? = null
    private var otherStoreSettingFragment: OtherStoreSettingFragment? = null
    override fun getLayoutId(): Int {
        return R.layout.layout_activity_store_setting
    }

    override fun initView() {
        titleText.text = "店铺设置"
        tvRight.text = "保存"
        tvRight.setTxtColor(this@StoreSettingActivity, R.color.mainColor)

        type = intent?.getStringExtra("type")
        when (type) {
            "1" -> {
                setFood()
            }

            else -> {
                setOther()
            }
        }

    }

    override fun initObserver() {

    }

    private fun setOther() {
        val fTransaction = supportFragmentManager.beginTransaction()
        if (otherStoreSettingFragment == null) {
            otherStoreSettingFragment = OtherStoreSettingFragment.newInstance()
            fTransaction.add(R.id.fl_container, otherStoreSettingFragment!!)
        } else {
            fTransaction.show(otherStoreSettingFragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }


    private fun setFood() {
        val fTransaction = supportFragmentManager.beginTransaction()
        if (foodStoreSettingFragment == null) {
            foodStoreSettingFragment = FoodStoreSettingFragment.newInstance()
            fTransaction.add(R.id.fl_container, foodStoreSettingFragment!!)
        } else {
            fTransaction.show(foodStoreSettingFragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }


    override fun initListener() {
        tvRight.setOnClickListener {
            if (type == "1") {
                foodStoreSettingFragment?.save()
            } else {
                otherStoreSettingFragment?.save()
            }

        }
    }

    override fun initData() {
    }

}