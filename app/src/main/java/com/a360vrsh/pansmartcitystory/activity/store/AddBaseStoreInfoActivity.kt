package com.a360vrsh.pansmartcitystory.activity.store

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.*
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.activity.common.PoiBaiDuActivity
import com.a360vrsh.pansmartcitystory.bean.*
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.store.AddBaseStoreInfoViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.view.OptionsPickerView
import com.contrarywind.interfaces.IPickerViewData
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.style.PictureParameterStyle
import kotlinx.android.synthetic.main.activity_add_base_store_info.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * 注册完进行店铺基本信息设置
 * */
@Route(path = ARouterConstant.ACTIVITY_ADD_BASE_STORE_INFO)
class AddBaseStoreInfoActivity : BaseTitleActivity() {
    private lateinit var viewModel: AddBaseStoreInfoViewModel

    private var options1Items: MutableList<AreaBean> = ArrayList()//省
    private var options2Items: MutableList<MutableList<AreaBean.CityBean>> = ArrayList()//市
    private var options3Items: MutableList<MutableList<MutableList<AreaBean.CityBean.DistrictBean>>> =
        ArrayList()//区

    private var proposition = HashMap<String, Int>()//省position
    private var cityposition = HashMap<String, Int>()//市position
    private var regionposition = HashMap<String, Int>()//区position
    private var typeposition = HashMap<String, Int>()//店铺行业position
    private var classPosition = HashMap<String, Int>()//店铺分类position
    private var classChildPosition = HashMap<String, Int>()//店铺子分类position


    private var storeTypeItems: MutableList<ShopTypePickerBean> = ArrayList()//行业
    private var storeClassItems: MutableList<ShopChildTypeBean> = ArrayList()//分类
    private var storeClassChildItems: MutableList<MutableList<ShopChildTypeBean.ChildrenBean>> =
        ArrayList()//子分类

    private var provinceId = "16" //省份Id  //河南16郑州240金水区2664
    private var cityId = "240" //城市Id
    private var regionId = "2664" //区域Id
    private var storeType = "" //店铺行业
    private var storeTypeId = "" //店铺行业id
    private var storeClassId = "" //店铺分类id
    private var storeChildClassId = "" //店铺子分类id
    private var hasChildClass = false //店铺分类是否有二级
    private var lat: String? = null//纬度
    private var lng: String? = null//经度
    private var imagePath = ""//店铺logo url
    private var storeName = ""//店铺名称
    private var storeContact = ""//联系方式
    private var storeAddress: String? = null //详细地址
    private var province: String? = null //省名称
    private var city: String? = null //城市名称
    private var district: String? = null//地区名称

    override fun getLayoutId(): Int {
        return R.layout.activity_add_base_store_info
    }

    override fun initView() {
        viewModel =
            initViewModel(AddBaseStoreInfoViewModel::class.java) as AddBaseStoreInfoViewModel

        titleText.text = "基本信息"
        tvRight.text = "保存"

        edt_store_name.clearFocus()
        edt_contact.clearFocus()
        edt_address.clearFocus()
    }


    override fun initListener() {
        llRight.setOnClickListener {

            storeName = edt_store_name.text.toString().trim()
            storeContact = edt_contact.text.toString().trim()
            storeAddress = edt_address.text.toString().trim()
            if (storeType.isEmpty()) {
                showToast("请选择所属行业")
                return@setOnClickListener
            } else if (storeName.isEmpty()) {
                showToast("请输入店铺名称")
                return@setOnClickListener
            } else if (storeClassId.isEmpty() && storeChildClassId.isEmpty()) {
                showToast("请选择店铺分类")
                return@setOnClickListener
            } else if (storeContact.isEmpty()) {
                showToast("请输入联系方式")
                return@setOnClickListener
            } else if (imagePath.isEmpty()) {
                showToast("请上传店铺封面")
                return@setOnClickListener
            } else if (provinceId.isEmpty() || cityId.isEmpty() || regionId.isEmpty()) {
                showToast("请选择所在区域")
                return@setOnClickListener
            } else if (lat.isNullOrEmpty() || lng.isNullOrEmpty()) {
                showToast("地图标注不能为空")
                return@setOnClickListener
            } else if (storeAddress.isNullOrEmpty()) {
                showToast("请输入详细地址")
                return@setOnClickListener
            }
            val params = HashMap<String, String?>()
            val classId = if (hasChildClass) {
                storeChildClassId
            } else {
                storeClassId
            }
            params["name"] = storeName
            params["contact"] = storeContact
            params["address"] = storeAddress
            params["province_id"] = provinceId
            params["city_id"] = cityId
            params["region_id"] = regionId
            params["logo"] = imagePath
            params["lng"] = lng
            params["lat"] = lat
            params["class"] = classId
            viewModel.saveBasic(getContext(), MMKVUtil.getString(MMKVUtil.STORE_ID), params, true)

        }
        //城市选择
        tv_choose_area.setOnClickListener {
            if (provinceId != "" && provinceId != "0") {
                if (regionposition.containsKey(regionId)) {
                    showAreaPicker(
                        proposition[provinceId],
                        cityposition[cityId],
                        regionposition[regionId]
                    )
                } else {
                    showAreaPicker(proposition[provinceId], cityposition[cityId], 0)
                }
            } else {
                showAreaPicker(0, 0, 0)
            }
        }
        //行业选择
        tv_choose_store_type.setOnClickListener {
            if (typeposition.containsKey(storeType)) {
                showShopTypePicker(storeTypeItems, typeposition[storeType]!!)
            } else {
                showShopTypePicker(storeTypeItems, 0)
            }
        }
        //分类选择
        tv_choose_store_class.setOnClickListener {
            if (storeType.isEmpty()) {
                showToast("您还未选择行业")
            } else {
                if (classPosition.containsKey(storeClassId)) {
                    if (classChildPosition.containsKey(storeChildClassId)) {
                        showShopClassPicker(
                            hasChildClass,
                            classPosition[storeClassId]!!,
                            classChildPosition[storeChildClassId]!!
                        )
                    } else {
                        showShopClassPicker(hasChildClass, classPosition[storeClassId]!!, 0)
                    }

                } else {
                    showShopClassPicker(hasChildClass, 0, 0)
                }

            }
        }
        //店铺封面
        iv_store_logo.setSingleClick {
            val mPictureParameterStyle = PictureParameterStyle()
            // 相册状态栏背景色
            mPictureParameterStyle.pictureStatusBarColor = Color.parseColor("#12B7F5");
            // 相册列表标题栏背景色
            mPictureParameterStyle.pictureTitleBarBackgroundColor = Color.parseColor("#12B7F5");
            PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
//                .setPictureStyle(mPictureParameterStyle)
                .imageEngine(GlideEngine.createGlideEngine())
                .forResult(PictureConfig.CHOOSE_REQUEST);
        }
        //地图标注-未标注
        ll_has_not_mark.setOnClickListener {
            if (city.isNullOrEmpty() || district.isNullOrEmpty()) {
                showToast("请选择区域")
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putString("city", city)
            bundle.putString("district", district)
            gotoActivity(PoiBaiDuActivity::class.java, bundle)
        }
        //地图标注-已标注
        ll_has_mark.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("lat", lat)
            bundle.putString("lng", lng)
            gotoActivity(PoiBaiDuActivity::class.java, bundle)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                // 图片选择结果回调
                val selectList: List<LocalMedia> = PictureSelector.obtainMultipleResult(data);
                if (selectList.isNullOrEmpty()) return
                // 例如 LocalMedia 里面返回五种path
                // 1.media.getPath(); 原图path
                // 2.media.getCutPath();裁剪后path，需判断media.isCut();切勿直接使用
                // 3.media.getCompressPath();压缩后path，需判断media.isCompressed();切勿直接使用
                // 4.media.getOriginalPath()); media.isOriginal());为true时此字段才有值
                // 5.media.getAndroidQToPath();Android Q版本特有返回的字段，但如果开启了压缩或裁剪还是取裁剪或压缩路径；注意：.isAndroidQTransform 为false 此字段将返回空
                // 如果同时开启裁剪和压缩，则取压缩路径为准因为是先裁剪后压缩
                LogUtil.i(TAG, "图片数量:" + selectList.size)
                selectList.forEach { media ->
                    LogUtil.i(TAG, "是否压缩:" + media.isCompressed)
                    LogUtil.i(TAG, "压缩:" + media.compressPath)
                    LogUtil.i(TAG, "原图Uri:" + media.path)
                    LogUtil.i(TAG, "原图Path:" + media.realPath)
                    LogUtil.i(TAG, "是否裁剪:" + media.isCut)
                    LogUtil.i(TAG, "裁剪:" + media.cutPath)
                    LogUtil.i(TAG, "是否开启原图:" + media.isOriginal)
                    LogUtil.i(TAG, "原图路径:" + media.originalPath)
                    LogUtil.i(TAG, "Android Q 特有Path:" + media.androidQToPath)
                    LogUtil.i(TAG, "宽高: " + media.width + "x" + media.height)
                    LogUtil.i(TAG, "Size: " + media.size)
                }

                ImageLoaderUtil.displayImage(getContext(), selectList[0].path, iv_store_logo)
            }
        }
    }

    override fun initObserver() {
        viewModel.storeInfoLiveData.observe(this, Observer {
            setUiData(it)
        })

        viewModel.areaCheckLiveData.observe(this, Observer {
            val address = it.data?.address
            tv_choose_area.text = address?.replace("-", " ")
            val array = address?.split("-")
            array?.apply {
                if (this.size > 2) {
                    city = this[1]
                    district = this[2]
                }
            }

        })
        viewModel.areaIdsLiveData.observe(this, Observer {
            provinceId = it.data.province_id
            cityId = it.data.city_id
            regionId = it.data.region_id
            //获取省市区id后才算标注成功
            province = poiEventBean?.province
            city = poiEventBean?.city
            district = poiEventBean?.district
            lat = poiEventBean?.lat
            lng = poiEventBean?.lng
            storeAddress = poiEventBean?.address
            edt_address.setText(storeAddress)
            ll_has_mark.visibility = View.VISIBLE
            ll_has_not_mark.visibility = View.GONE
            LogUtil.e(
                "PoiBaiDuActivity",
                "provinceId" + provinceId + "cityId" + cityId + "regionId" + regionId
            )
        })
        viewModel.areaLiveData.observe(this, Observer {

            setAreaData(it)
        })

        viewModel.storeTypeLiveData.observe(this, Observer {

            setStoreTypeData(it)
        })

        viewModel.storeClassLiveData.observe(this, Observer {

            setStoreClassData(it)
        })

    }

    private fun setUiData(storeInfoBean: StoreInfoBean?) {//todo
        storeInfoBean?.data?.let {
            storeType = it.type
            hasChildClass = storeType == "food"

            provinceId = it.province_id
            cityId = it.city_id
            regionId = it.region_id
            imagePath = it.logo.path
            storeName = it.name
            storeContact = it.contact
            storeAddress = it.address

            it.classX?.run {
                if (size == 1) {
                    storeClassId = this[0].id
                } else if (size == 2) {
                    storeClassId = this[0].id
                    storeChildClassId = this[1].id
                }
            }
            lat = it.lat
            lng = it.lng
            if (lat != null && lng != null) {
                ll_has_mark.visibility = View.VISIBLE
                ll_has_not_mark.visibility = View.GONE
            }
            //获取店铺行业类型
            viewModel.getStoreType(getContext(), true)
            //获取店铺分类
            viewModel.getStoreClass(getContext(), storeType, true)

            tv_choose_store_class.text = it.classX[0].name
            edt_store_name.setText(it.name)
            edt_contact.setText(it.contact)
            edt_address.setText(it.address)
            ImageLoaderUtil.displayImage(getContext(), it.logo?.url, iv_store_logo)

            viewModel.areaCheck(getContext(), it.province_id, it.city_id, it.region_id, true)

        }
    }

    override fun initData() {

        if (MMKVUtil.getString(MMKVUtil.STORE_ID).isNullOrEmpty()) {//未进行过基本信息设置
            //获取店铺行业类型
            viewModel.getStoreType(getContext(), true)
        } else {
            //获取店铺信息
            viewModel.getStoreInfo(getContext(), MMKVUtil.getString(MMKVUtil.STORE_ID), true)
        }

        //获取城市列表
        val cityJson = MMKVUtil.getString("cityJson")
        if (cityJson.isNullOrEmpty()) {//本地无缓存，从服务器获取
            viewModel.getAllArea(getContext(), true)
        } else {
            viewModel.getLocalAllArea(cityJson)
        }


    }

    /**
     * 设置店铺行业数据
     * */
    private fun setStoreTypeData(itemsBean: List<ShopTypePickerBean>) {

        storeTypeItems.clear()
        storeTypeItems.addAll(itemsBean)

        for (i in itemsBean.indices) {
            typeposition[itemsBean[i].label] = i

            if (itemsBean[i].label == storeType) {//设置店铺行业-之前设置过
                tv_choose_store_type.text = itemsBean[i].name
            }
        }

    }

    /**
     * 设置店铺分类数据
     * */
    private fun setStoreClassData(itemsBean: List<ShopChildTypeBean>) {

        storeClassItems.clear()
        storeClassItems.addAll(itemsBean)

        if (hasChildClass) {

            for (i in itemsBean.indices) {
                storeClassChildItems.add(itemsBean[i].children)
                classPosition[itemsBean[i].id.toString() + ""] = i
                for (j in itemsBean[i].children.indices) {
                    classChildPosition[itemsBean[i].children[j].id.toString() + ""] = j
                }
            }
        } else {
            for (i in itemsBean.indices) {
                classPosition[itemsBean[i].id.toString() + ""] = i
            }
            storeClassChildItems.clear()
        }

    }

    /**
     * 设置城市选择数据
     * */
    private fun setAreaData(jsonBean: List<AreaBean>) {
        options1Items.clear()
        options1Items.addAll(jsonBean)

        for (i in jsonBean.indices) { //遍历省份
            proposition[jsonBean[i].id.toString() + ""] = i
            val cityList: MutableList<AreaBean.CityBean> = ArrayList() //该省的城市列表（第二级）
            val districtList: MutableList<MutableList<AreaBean.CityBean.DistrictBean>> =
                ArrayList() //该省的所有地区列表（第三级）
            for (c in 0 until jsonBean[i].children.size) { //遍历该省份的所有城市
                cityposition[jsonBean[i].children[c].id.toString() + ""] = c
                val CityName: AreaBean.CityBean = jsonBean[i].children.get(c)
                cityList.add(CityName) //添加城市
                val tempDistrictList: ArrayList<AreaBean.CityBean.DistrictBean> =
                    ArrayList() //该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean[i].children[c].children.isNullOrEmpty()) {
                    tempDistrictList.add(AreaBean.CityBean.DistrictBean("", ""))
                } else {
                    for (d in 0 until jsonBean[i].children[c].children.size) { //该城市对应地区所有数据
                        regionposition[jsonBean[i].children[c].children[d].id
                            .toString() + ""] = d
                        val areaName: AreaBean.CityBean.DistrictBean =
                            jsonBean[i].children[c].children[d]
                        tempDistrictList.add(areaName) //添加该城市所有地区数据
                    }
                }
                districtList.add(tempDistrictList) //添加该省所有地区数据
            }
            /**
             * 添加城市数据
             */
            options2Items.add(cityList)
            /**
             * 添加地区数据
             */
            options3Items.add(districtList)
        }
    }


    /**
     * 省市区选择框
     */
    @SuppressLint("SetTextI18n")
    private fun showAreaPicker(item1: Int?, item2: Int?, item3: Int?) {
        if (options1Items.isNullOrEmpty()) return
        var areaPickerView: OptionsPickerView<in IPickerViewData> =
            OptionsPickerBuilder(this,
                OnOptionsSelectListener { options1, option2, options3, v -> //返回的分别是三个级别的选中位置
                    provinceId = "" + options1Items[options1].id
                    cityId = "" + options2Items[options1][option2].id
                    regionId = "" + options3Items[options1][option2][options3].id

                    province = options1Items[options1].name
                    city = options2Items[options1][option2].name
                    district = options3Items[options1][option2][options3].name

                    tv_choose_area.text = province + "  " +
                            city + "  " +
                            district
                    //清除标注数据
                    ll_has_mark.visibility = View.GONE
                    ll_has_not_mark.visibility = View.VISIBLE
                    lat = ""
                    lng = ""
                    storeAddress = ""
                    edt_address.setText("")

                    LogUtil.e(
                        TAG,
                        "provinceId:" + provinceId + "cityId:" + cityId + "regionId:" + regionId
                    )
                })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setSubmitColor(ContextCompat.getColor(getContext(), R.color.mainColor))//确定按钮文字颜色
                .setCancelColor(ContextCompat.getColor(getContext(), R.color.library_text_666))//取消按钮文字颜色
                .setContentTextSize(20)
                .build();

        if (item3 != 0) {
            areaPickerView.setSelectOptions(item1!!, item2!!, item3!!)
        } else {
            areaPickerView.setSelectOptions(item1!!, item2!!)
        }
        areaPickerView.setPicker(options1Items, options2Items, options3Items)
        areaPickerView.show()
    }

    /**
     * 店铺行业选择框
     */
    private fun showShopTypePicker(itemBeans: List<ShopTypePickerBean>, item1: Int) {
        val shopTypePickerView: OptionsPickerView<in IPickerViewData> =
            OptionsPickerBuilder(
                this,
                OnOptionsSelectListener { options1, option2, options3, v ->

                    tv_choose_store_type.text = itemBeans[options1].name
                    if (storeType != itemBeans[options1].label) {
                        //获取店铺分类
                        viewModel.getStoreClass(getContext(), itemBeans[options1].label, true)

                        storeClassId = ""
                        storeChildClassId = ""
                        tv_choose_store_class.text = "请选择"

                    }

                    storeType = itemBeans[options1].label
                    LogUtil.e(TAG, "storeType:" + storeType)
                    hasChildClass = storeType == "food" //美食有子分类

                }).build()
        shopTypePickerView.setPicker(itemBeans)
        shopTypePickerView.setSelectOptions(item1)
        shopTypePickerView.show()
    }

    /**
     * 店铺分类选择框
     */
    @SuppressLint("SetTextI18n")
    private fun showShopClassPicker(hasChildClass: Boolean, item1: Int, item2: Int) {
        val shopChildTypePickerView: OptionsPickerView<in IPickerViewData> =
            OptionsPickerBuilder(this,
                OnOptionsSelectListener { options1, option2, options3, v ->
                    if (hasChildClass) {//有子分类
                        storeClassId = "" + storeClassItems[options1].id
                        storeChildClassId = "" + storeClassChildItems[options1][option2].id
                        tv_choose_store_class.text =
                            storeClassItems[options1].name + "/" + storeClassChildItems[options1][option2].name
                    } else {
                        storeClassId = "" + storeClassItems[options1].id
                        tv_choose_store_class.text =
                            storeClassItems[options1].name
                    }


                }).build()
        if (hasChildClass && storeClassChildItems.size > 0) {

            shopChildTypePickerView.setPicker(storeClassItems, storeClassChildItems)
            shopChildTypePickerView.setSelectOptions(item1, item2)

        } else {

            shopChildTypePickerView.setPicker(storeClassItems)
            shopChildTypePickerView.setSelectOptions(item1)
        }

        shopChildTypePickerView.show()
    }


    var poiEventBean: PoiEventBean? = null

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: PoiEventBean) {
        if (event.id == EventID.REVERSE_GEOCODE_SUCCESS) {
            poiEventBean = event
            viewModel.getAreaId(
                getContext(),
                event.lat,
                event.lng,
                event.province,
                event.city,
                event.district,
                false
            )
        }
    }
}