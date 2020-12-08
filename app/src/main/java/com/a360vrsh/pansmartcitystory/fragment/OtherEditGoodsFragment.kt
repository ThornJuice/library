package com.a360vrsh.pansmartcitystory.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.a360vrsh.library.base.BaseFragment
import com.a360vrsh.library.bean.EventBean
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.*
import com.a360vrsh.library.widget.FullyGridLayoutManager
import com.a360vrsh.library.widget.GridSpacingItemDecoration
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.goods.AddGoodsClassActivity
import com.a360vrsh.pansmartcitystory.adapter.EditGoodsUpLoadImageAdapter
import com.a360vrsh.pansmartcitystory.bean.GoodsClassPickerBean
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.goods.EditGoodsViewModel
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.view.OptionsPickerView
import com.contrarywind.interfaces.IPickerViewData
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import com.luck.picture.lib.permissions.PermissionChecker
import com.luck.picture.lib.tools.PictureFileUtils
import kotlinx.android.synthetic.main.fragment_other_edit_goods.*
import org.greenrobot.eventbus.EventBus
import java.io.File


/**
 * 其他行业商品编辑添加
 */
class OtherEditGoodsFragment : BaseFragment(), OnResultCallbackListener<LocalMedia> {
    private val viewModel: EditGoodsViewModel by lazy {
        initViewModel(EditGoodsViewModel::class.java) as EditGoodsViewModel
    }

    private var goodsClassItems: MutableList<GoodsClassPickerBean> = ArrayList()//商品分类
    private var goodsClassPosition = HashMap<String, Int>()//商品分类pickerview position
    private var goodsId: String? = null//商品id
    private var classId: String? = null//分类id

    private val mAdapter: EditGoodsUpLoadImageAdapter by lazy {
        EditGoodsUpLoadImageAdapter(requireContext(), onAddPicClickListener)
    }
    private var onAddPicClickListener: EditGoodsUpLoadImageAdapter.onAddPicClickListener? = null

    companion object {
        @JvmStatic
        fun newInstance(goodsId: String?) =
            OtherEditGoodsFragment().apply {
                arguments = Bundle().apply {
                    putString("id", goodsId)
                }
            }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_other_edit_goods
    }

    override fun initView() {


        val manager = FullyGridLayoutManager(
            requireContext(),
            3, GridLayoutManager.VERTICAL, false
        )
        rv_images.layoutManager = manager

        rv_images.addItemDecoration(
            GridSpacingItemDecoration(
                3,
                ScreenUtil.dip2px(requireContext(), 8f), false
            )
        )

        onAddPicClickListener = EditGoodsUpLoadImageAdapter.onAddPicClickListener {
            PictureSelector.create(requireActivity())
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
//                .minSelectNum(1)
//                .maxSelectNum(6)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.SINGLE)
//                .selectionData(mAdapter?.data)// 是否传入已选图片
                .forResult(this)
        }

        mAdapter.setSelectMax(5)
        rv_images.adapter = mAdapter


    }


    override fun initListener() {
        edt_sale_price.filters = EditTextUtil.inputTwoDecimal()
        edt_price_origin.filters = EditTextUtil.inputTwoDecimal()
        edt_price_cost.filters = EditTextUtil.inputTwoDecimal()
        tv_choose_goods_class.setSingleClick {
            tv_choose_goods_class.requestFocus()
            //获取商品分类
            viewModel.getGoodsClass(requireContext(), MMKVUtil.getStoreId(), true)
        }
        tv_submit.setSingleClick {
            save()
        }

    }

    override fun initData() {
        arguments?.let {
            goodsId = it.getString("id")
        }

        //获取商品详情
        goodsId?.let {
            viewModel.getGoodsDetail(requireContext(), it, MMKVUtil.getStoreId(), true)
        }
    }

    override fun initObserver() {
        viewModel.goodsClassLiveData.observe(this, Observer { goodsClassBean ->


            goodsClassBean.data?.apply {
                if (size == 0) {
                    gotoActivity(AddGoodsClassActivity::class.java)
                } else {
                    val pickerViewData = ArrayList<GoodsClassPickerBean>()
                    forEach { item ->
                        val bean = GoodsClassPickerBean()
                        bean.id = item.id
                        bean.name = item.name
                        bean.weight = item.weight
                        pickerViewData.add(bean)
                    }
                    setGoodsClassData(pickerViewData)
                }
            }

        })
        viewModel.goodsDetailLiveData.observe(this, Observer {

            setUiData(it.data)

        })
        viewModel.upLoadSuccessLiveData.observe(this, Observer {

//            showToast("上传成功")
            mAdapter.addUpLoadImagePath(it.data.path)
            mAdapter.addData(localMedia)

        })
        viewModel.editSuccessLiveData.observe(this, Observer {

            showToast("操作成功")
            EventBus.getDefault().post(EventBean(EventID.GOODS_EDIT_SUCCESS))
            activity?.finish()
        })
    }


    private fun setUiData(data: GoodsDetailBean.DataBean?) {
        data?.apply {
            edt_goods_name.setText(this.title)
            edt_goods_num.setText(this.gs1_code)
            edt_share_describe.setText(this.describe)

            classId = this.class_id
            tv_choose_goods_class.text = this.class_name


            val localMediaList = ArrayList<LocalMedia>()
            this.images?.forEach {
                val localMedia = LocalMedia()
                localMedia.path = it.url
                localMediaList.add(localMedia)
                mAdapter.addUpLoadImagePath(it.path)
            }
            mAdapter.setList(localMediaList)
        }
    }

    override fun initImmersionBar() {

    }


    /**
     * 设置商品分类
     * */
    private fun setGoodsClassData(itemsBean: List<GoodsClassPickerBean>) {

        goodsClassItems.clear()
        goodsClassItems.addAll(itemsBean)

        for (i in itemsBean.indices) {
            goodsClassPosition[itemsBean[i].id] = i
        }
        if (goodsClassPosition.containsKey(classId)) {
            showGoodsClassPicker(itemsBean, goodsClassPosition[classId]!!)
        } else {
            showGoodsClassPicker(itemsBean, 0)
        }

    }

    /**
     * 商品分类选择框
     */
    private fun showGoodsClassPicker(itemBeans: List<GoodsClassPickerBean>, item1: Int) {
        val shopTypePickerView: OptionsPickerView<in IPickerViewData> =
            OptionsPickerBuilder(
                requireContext(),
                OnOptionsSelectListener { options1, _, _, v ->

                    classId = itemBeans[options1].id
                    tv_choose_goods_class.text = itemBeans[options1].name

                }).build()
        shopTypePickerView.setPicker(itemBeans)
        shopTypePickerView.setSelectOptions(item1)
        shopTypePickerView.show()
    }


    /**
     * 清空缓存包括裁剪、压缩、AndroidQToPath所生成的文件，注意调用时机必须是处理完本身的业务逻辑后调用；非强制性
     */
    private fun clearCache() {
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        if (PermissionChecker.checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            //PictureFileUtils.deleteCacheDirFile(this, PictureMimeType.ofImage());
            PictureFileUtils.deleteAllCacheDirFile(requireContext())
        } else {
            PermissionChecker.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PictureConfig.APPLY_STORAGE_PERMISSIONS_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PictureConfig.APPLY_STORAGE_PERMISSIONS_CODE ->                 // 存储权限
            {
                var i = 0
                while (i < grantResults.size) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        PictureFileUtils.deleteCacheDirFile(getContext(), PictureMimeType.ofImage())
                    } else {
                        ToastUtil.show(getString(R.string.picture_jurisdiction))
                    }
                    i++
                }
            }
        }
    }

    /**
     *提交表单
     * */
    private fun save() {
        val title = edt_goods_name.text.toString().trim()
        val gs1_code = edt_goods_num.text.toString().trim()
        val describe = edt_share_describe.text.toString().trim()
        val price = edt_sale_price.text.toString().trim()
        val imagePathList = mAdapter.upLoadImagePaths

        if (title.isEmpty()) {
            showToast("请填写商品名称")
            return
        } else if (gs1_code.isEmpty()) {
            showToast("请填写商品编码")
            return
        } else if (classId.isNullOrEmpty()) {
            showToast("请选择商品分类")
            return
        } else if (describe.isEmpty()) {
            showToast("请填写分享描述")
            return
        } else if (imagePathList.isNullOrEmpty()) {
            showToast("请选择商品图片")
            return
        } else if (price.isEmpty()) {
            showToast("请填写销售价格")
            return
        }

        val paramMap = HashMap<String, String?>()
        paramMap["store_id"] = MMKVUtil.getStoreId()
        paramMap["class_id"] = classId
        paramMap["title"] = title
        paramMap["gs1_code"] = gs1_code
        paramMap["describe"] = describe
        paramMap["price"] = price
        paramMap["price_cost"] = price
        paramMap["price_origin"] = price
        paramMap["shelf_auto"] = "0"

        //图片
        for (i in imagePathList.indices) {
            paramMap["image[$i]"] = imagePathList[i]
        }
        if (goodsId.isNullOrEmpty()) {//添加
            viewModel.addGoods(
                requireContext(),
                paramMap,
                true
            )
        } else {//编辑
            goodsId?.let {
                viewModel.editGoods(
                    requireContext(),
                    it,
                    paramMap,
                    true
                )
            }
        }

    }

    private fun upLoadImage(file: File) {
        viewModel.upLoadImage(requireContext(), file, true)
    }

    override fun onDestroy() {
        super.onDestroy()
        clearCache()
    }

    /**
     * 图片选择回调 选择一张图片调一次上传接口
     * */
    private var localMedia: LocalMedia? = null//上传的图片LocalMedia
    override fun onResult(result: MutableList<LocalMedia>?) {
        result?.let {
            if (it.size > 0) {
                localMedia = it[0]
                val file = File(it[0].realPath)
                upLoadImage(file)
            }
        }
    }

    /**
     * 图片选择取消
     * */
    override fun onCancel() {
        LogUtil.i("PictureSelector", "PictureSelector Cancel")
    }

}