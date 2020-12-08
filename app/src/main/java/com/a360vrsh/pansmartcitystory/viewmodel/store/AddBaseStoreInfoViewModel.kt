package com.a360vrsh.pansmartcitystory.viewmodel.store

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.Type


/**
 * 添加店铺基本信息ViewModel
 * */
class AddBaseStoreInfoViewModel(application: Application) : BaseViewModel(application) {
    var areaLiveData = MutableLiveData<List<AreaBean>>()
    var areaCheckLiveData = MutableLiveData<AreaCheckBean>()
    var areaIdsLiveData = MutableLiveData<AreaCheckBean>()
    var storeTypeLiveData = MutableLiveData<List<ShopTypePickerBean>>()
    var storeClassLiveData = MutableLiveData<List<ShopChildTypeBean>>()
    var saveSuccessLiveData = MutableLiveData<PublicSuccessBean>()
    /**
     * 服务器获取城市列表
     * */
    fun getAllArea(context: Context, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()

        HttpUtil.get(context, UrlConstant.AREA_LIST, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {

                var jsonObject: JSONObject? = null
                try {
                    jsonObject = JSONObject(response)
                    val cityJson = jsonObject.optString("data")
                    MMKVUtil.putString("cityJson", cityJson)

                    val type: Type =
                        object : TypeToken<List<AreaBean>>() {}.type
                    val list: List<AreaBean> = Gson().fromJson(cityJson, type)
                    areaLiveData.value = list
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }

    /**
     * 本地获取城市列表
     * */
    fun getLocalAllArea(cityJson: String) {
        val type: Type =
            object : TypeToken<List<AreaBean>>() {}.type
        val list: List<AreaBean> = Gson().fromJson(cityJson, type)
        areaLiveData.value = list

    }

    /**
     * 店铺行业
     * */
    fun getStoreType(context: Context, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()

        HttpUtil.get(context, UrlConstant.STORE_TYPE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {

                var jsonObject: JSONObject? = null
                try {
                    jsonObject = JSONObject(response)
                    val cityJson = jsonObject.optString("data")

                    val type: Type =
                        object : TypeToken<List<ShopTypePickerBean>>() {}.type
                    val list: List<ShopTypePickerBean> = Gson().fromJson(cityJson, type)

                    storeTypeLiveData.value = list

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 店铺分类
     * */
    fun getStoreClass(context: Context, type: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["type"] = type
        HttpUtil.get(context, UrlConstant.STORE_TYPE_CHILD, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {

                var jsonObject: JSONObject? = null
                try {
                    jsonObject = JSONObject(response)
                    val cityJson = jsonObject.optString("data")
                    val type1: Type =
                        object : TypeToken<List<ShopChildTypeBean>>() {}.type
                    val list: List<ShopChildTypeBean> = Gson().fromJson(cityJson, type1)
                    storeClassLiveData.value = list
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 通过id查找省市区名称
     * */
    fun areaCheck(
        context: Context,
        province_id: String,
        city_id: String,
        region_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["province_id"] = province_id
        paramMap["city_id"] = city_id
        paramMap["region_id"] = region_id
        HttpUtil.get(
            context, UrlConstant.AREA_CHECK, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: AreaCheckBean =
                        Gson().fromJson(response, AreaCheckBean::class.java)
                    areaCheckLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            }, isShowLoading
        )
    }

    /**
     * 通过省市区名称查找id
     * */
    fun getAreaId(
        context: Context,
        lat: String?,
        lng: String?,
        province: String,
        city: String,
        region: String,
        isShowLoading: Boolean
    ) {
        if (lat == null || lng == null) {
            return
        }
        val paramMap = HashMap<String, String>()
        paramMap["lat"] = lat
        paramMap["lng"] = lng
        paramMap["province"] = province
        paramMap["city"] = city
        paramMap["district"] = region
        HttpUtil.get(
            context, UrlConstant.GEOCODER_REVERSE, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: AreaCheckBean =
                        Gson().fromJson(response, AreaCheckBean::class.java)
                    areaIdsLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            }, isShowLoading
        )
    }

    /**
     * 保存基本信息
     * */
    fun saveBasic(
        context: Context,
        storeId: String,
        paramMap: HashMap<String, String?>,
        isShowLoading: Boolean
    ) {
        HttpUtil.put(
            context,
            UrlConstant.SAVE_BASIC + storeId + "/basic",
            paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    saveSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
}