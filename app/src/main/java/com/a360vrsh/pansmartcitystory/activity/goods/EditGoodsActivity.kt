package com.a360vrsh.pansmartcitystory.activity.goods

import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.fragment.FoodEditGoodsFragment
import com.a360vrsh.pansmartcitystory.fragment.OtherEditGoodsFragment
import com.a360vrsh.pansmartcitystory.fragment.TravelEditGoodsFragment
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor

class EditGoodsActivity : BaseTitleActivity() {
    private var type: String? = null//1美食 3旅游   else其他
    private var goodsId: String? = null
    private var foodEditGoodsFragment: FoodEditGoodsFragment? = null
    private var travelEditGoodsFragment: TravelEditGoodsFragment? = null
    private var otherEditGoodsFragment: OtherEditGoodsFragment? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_edit_goods
    }

    override fun initView() {

        tvRight.text = "添加分类"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

        goodsId = intent.getStringExtra("id")
        if (goodsId.isNullOrEmpty()) {
            titleText.text = "添加商品"
        } else {
            titleText.text = "编辑商品"
        }

        type = intent?.getStringExtra("type")

        when (type) {
            "1" -> {
                setFood()
            }
            "3" -> {
                setTravel()
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
        if (otherEditGoodsFragment == null) {
            otherEditGoodsFragment = OtherEditGoodsFragment.newInstance(goodsId)
            fTransaction.add(R.id.fl_container, otherEditGoodsFragment!!)
        } else {
            fTransaction.show(otherEditGoodsFragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }


    private fun setFood() {
        val fTransaction = supportFragmentManager.beginTransaction()
        if (foodEditGoodsFragment == null) {
            foodEditGoodsFragment = FoodEditGoodsFragment.newInstance(goodsId)
            fTransaction.add(R.id.fl_container, foodEditGoodsFragment!!)
        } else {
            fTransaction.show(foodEditGoodsFragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }

    private fun setTravel() {
        val fTransaction = supportFragmentManager.beginTransaction()
        if (travelEditGoodsFragment == null) {
            travelEditGoodsFragment =
                TravelEditGoodsFragment.newInstance(goodsId)
            fTransaction.add(R.id.fl_container, travelEditGoodsFragment!!)
        } else {
            fTransaction.show(travelEditGoodsFragment!!)
        }
        fTransaction.commitAllowingStateLoss()
    }

    override fun initListener() {
        llRight.setOnClickListener {
            gotoActivity(AddGoodsClassActivity::class.java)
        }
    }

    override fun initData() {
    }
}