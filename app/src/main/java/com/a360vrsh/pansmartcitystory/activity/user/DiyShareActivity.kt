package com.a360vrsh.pansmartcitystory.activity.user

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.GlideEngine
import com.a360vrsh.library.util.ImageLoaderUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.bean.DiyShareBean
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.user.DiyShareViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import kotlinx.android.synthetic.main.activity_diy_share.*
import java.io.File

/**
 *自定义分享
 * */
@Route(path = ARouterConstant.ACTIVITY_USER_DIY_SHARE)
class DiyShareActivity : BaseTitleActivity() {
    private var imagePath: String? = null
    private val viewModel: DiyShareViewModel by lazy {
        initViewModel(DiyShareViewModel::class.java) as DiyShareViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_diy_share
    }

    override fun initView() {
        titleText.text = "自定义分享"
        tvRight.text = "保存"
        tvRight.setTxtColor(getContext(), R.color.mainColor)

    }


    override fun initListener() {
        llRight.setSingleClick {
            val titleVal = edt_title.text.toString().trim()
            val contentVal = edt_content.text.toString().trim()

            when {
                titleVal.isEmpty() -> {
                    showToast("请输入分享标题")
                }
                contentVal.isEmpty() -> {
                    showToast("请输入分享内容")
                }
                imagePath.isNullOrEmpty() -> {
                    showToast("请选择分享图片")
                }
                else -> {
                    viewModel.submit(
                        getContext(),
                        MMKVUtil.getStoreId(),
                        titleVal,
                        contentVal,
                        imagePath!!,
                        true
                    )
                }
            }
        }
        iv_image.setSingleClick {
            PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    override fun initObserver() {
        viewModel.diyShareLiveData.observe(this, Observer {
            setUiData(it.data)
        })
        viewModel.upLoadSuccessLiveData.observe(this, Observer {
            it.data?.apply {
                // showToast("上传成功")
                imagePath = this.path
                ImageLoaderUtil.displayImage(getContext(), this.url, iv_image)
            }

        })
        viewModel.saveSuccessLiveData.observe(this, Observer {
            showToast("保存成功")
            finish()
        })
    }

    private fun setUiData(data: DiyShareBean.DataBean?) {
        data?.apply {
            edt_title.setText(this.title)
            edt_content.setText(this.content)
            imagePath = this.image?.path
            ImageLoaderUtil.displayImage(getContext(), this.image?.url, iv_image)
        }
    }

    override fun initData() {
        viewModel.getData(getContext(), MMKVUtil.getStoreId(), true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                // 图片选择结果回调
                val selectList: List<LocalMedia> = PictureSelector.obtainMultipleResult(data);
                if (selectList.isNullOrEmpty()) return
//                ImageLoaderUtil.displayImage(getContext(), selectList[0].path, iv_image)
                val file = File(selectList[0].realPath)
                upLoadImage(file)
            }
        }
    }

    private fun upLoadImage(file: File) {
        viewModel.upLoadImage(getContext(), file, true)
    }
}