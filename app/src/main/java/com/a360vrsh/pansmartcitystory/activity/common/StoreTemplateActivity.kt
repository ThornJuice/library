package com.a360vrsh.pansmartcitystory.activity.common

import androidx.lifecycle.Observer
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.StoreTemplateAdapter
import com.a360vrsh.pansmartcitystory.util.*
import com.a360vrsh.pansmartcitystory.viewmodel.store.StoreTemplateViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_store_template.*

@Route(path = ARouterConstant.ACTIVITY_STORE_TEMPLATE)
class StoreTemplateActivity : BaseTitleActivity() {
    private val viewModel: StoreTemplateViewModel by lazy {
        initViewModel(StoreTemplateViewModel::class.java) as StoreTemplateViewModel
    }

    private var mAdapter: StoreTemplateAdapter? = null
    private var currentTemplate: String? = null//当前模板
    private var currentTemplateName: String? = null//当前模板名称
    override fun getLayoutId(): Int {
        return R.layout.activity_store_template
    }

    override fun initView() {
        titleText.text = "店铺模板"
        tvRight.text = "保存"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

        mAdapter = StoreTemplateAdapter(DataUtils.getStoreTemplateData(getContext()))
        RecyclerViewUtil.setVerticalManager(getContext(), recyclerView)
        recyclerView.adapter = mAdapter

    }


    override fun initListener() {
        llRight.setOnClickListener {

            UiUtil.getDialog(this@StoreTemplateActivity, "提示", "将店铺模板更改为$currentTemplateName?")
                .setPositive("确定") { v ->
                    currentTemplate?.let {
                        viewModel.chooseStoreTemplate(getContext(), it, true)
                    }
                }
                .setNegative("取消") { v -> }
                .show(supportFragmentManager)
        }

        mAdapter?.apply {
            this.setOnItemChildClickListener { _, view, position ->
                if (view.id == R.id.ll_check) {
                    this.setSelectTemplate(this.getItem(position)?.template)
                    currentTemplate = this.getItem(position)?.template
                    currentTemplateName = this.getItem(position)?.name
                }
            }
        }
    }

    override fun initObserver() {
        viewModel.currentTemplateBeanLiveData.observe(this, Observer {
            currentTemplate = it.data?.template

            currentTemplateName = mAdapter?.getTemplateName(currentTemplate)
            tv_current_template.text = currentTemplateName
            mAdapter?.setSelectTemplate(currentTemplate)

        })
        viewModel.successLiveData.observe(this, Observer {
            showToast("操作成功")
            viewModel.getCurrentStoreTemplate(getContext(), true)
        })
    }

    override fun initData() {
        viewModel.getCurrentStoreTemplate(getContext(), true)
    }
}