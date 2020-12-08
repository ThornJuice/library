package com.a360vrsh.pansmartcitystory.activity.pano

import android.os.Bundle
import androidx.lifecycle.Observer
import com.a360vrsh.library.activity.WebViewActivity
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.ImageLoaderUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.MyPanoImageAdapter
import com.a360vrsh.pansmartcitystory.bean.PanoListBean
import com.a360vrsh.pansmartcitystory.util.AppUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setGone
import com.a360vrsh.pansmartcitystory.util.setVisible
import com.a360vrsh.pansmartcitystory.viewmodel.pano.MyPanoViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_my_pano.*

@Route(path = ARouterConstant.ACTIVITY_MY_PANO)
class MyPanoActivity : BaseTitleActivity() {

    private val viewModel: MyPanoViewModel by lazy {
        initViewModel(MyPanoViewModel::class.java) as MyPanoViewModel
    }
    private val mImageAdapter: MyPanoImageAdapter by lazy { MyPanoImageAdapter(null) }

    var dataBean: PanoListBean.DataBean? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_my_pano
    }

    override fun initView() {
        titleText.text = "我的全景"
        ivRight.setImageResource(R.mipmap.ic_share)

        RecyclerViewUtil.setGridManager(getContext(), rv_images, 3)
        rv_images.adapter = mImageAdapter
    }


    override fun initListener() {

        llRight.setOnClickListener {
            AppUtil.share(getContext(), "", "", "", "")
        }

        iv_image.setOnClickListener {

            dataBean?.type?.pano_id.let {
                val bundle = Bundle()
                bundle.putString("url", UrlConstant.PANO_URL + it)
                gotoActivity(WebViewActivity::class.java, bundle)
            }

        }
    }

    override fun initObserver() {
        viewModel.panoBeanLiveData.observe(this@MyPanoActivity, Observer { panoListBean ->
            panoListBean.data?.forEach { item ->
                if (item.is_default == "1") {//展示默认全景
                    dataBean = item
                }
            }
            if (dataBean == null) {
                ll_empty_pano.setVisible()
                llRight.setGone()
            } else {
                llRight.setVisible()
                ll_empty_pano.setGone()
                dataBean?.apply {
                    tv_create_date.text = this.created_at
                    tv_title.text = this.title
                    tv_pano_type.text = this.type?.label
                    tv_status.text = this.status?.label
                    ImageLoaderUtil.displayImage(getContext(), this.thumb, iv_image)
                    this.status?.let {
                        if (it.value == "-1") {
                            tv_reason.setVisible()
                            tv_reason.text = this.reason
                            mImageAdapter.setNewData(evidence)
                        }
                    }
                }

            }

        })
    }

    override fun initData() {
        viewModel.getPano(getContext(), true)
    }

}