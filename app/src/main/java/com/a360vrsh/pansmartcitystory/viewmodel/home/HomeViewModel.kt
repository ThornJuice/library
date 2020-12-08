package com.a360vrsh.pansmartcitystory.viewmodel.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.ErrorInfo
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.http.OnError
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.*
import com.google.gson.Gson
import com.rxjava.rxlife.lifeOnMain
import io.reactivex.rxjava3.functions.Consumer
import rxhttp.RxHttp

class HomeViewModel(application: Application) : BaseViewModel(application) {
    var singleBean = MutableLiveData<TravelLMMGoodsDetailBean>()
    var articleListLiveData = MutableLiveData<ArticleListBean>()
    var articleDetailLiveData = MutableLiveData<ArticleDetailBean>()
    var areaCheckLiveData = MutableLiveData<AreaCheckBean>()
    var changeStoreStatusLiveData = MutableLiveData<PublicSuccessBean>()

    fun getDetail() {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = "140960"
        RxHttp.get("http://mb.360vrsh.com/api/lmm/product/2598633") //发送Get请求
            .addAll(paramMap)
            .asClass(TravelLMMGoodsDetailBean::class.java)
            .lifeOnMain(this)
            .subscribe(
                Consumer { bean: TravelLMMGoodsDetailBean? ->
                    singleBean.value = bean
                    LogUtil.e("RxHttpResponse", "response" + bean.toString())
                },
                OnError { errorInfo: ErrorInfo ->
                    LogUtil.e(
                        "RxHttpResponse",
                        "errorCoe:" + errorInfo.errorCode + "errorMsg:" + errorInfo.errorMsg
                    )
                })
    }



    fun getDetail2(context: Context, storeId: String, isShowLoading: Boolean) {
        val url = "http://mb.360vrsh.com/api/lmm/product/2598633"
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = storeId
        HttpUtil.get(context, url, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: TravelLMMGoodsDetailBean =
                    Gson().fromJson(response, TravelLMMGoodsDetailBean::class.java)
                singleBean.value = bean
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 推荐资讯
     * */
    fun getArticle(context: Context, isShowLoading: Boolean) {

        val paramMap = HashMap<String, String>()
        paramMap["pageSize"] = "5"
        HttpUtil.get(context, UrlConstant.RECOMMEND_ARTICLE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: ArticleListBean =
                    Gson().fromJson(response, ArticleListBean::class.java)
                articleListLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 推荐资讯详情
     * */
    fun getArticleDetail(context: Context, id: String, isShowLoading: Boolean) {

        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context,
            UrlConstant.RECOMMEND_ARTICLE_DETAIL + id,
            paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: ArticleDetailBean =
                        Gson().fromJson(response, ArticleDetailBean::class.java)
                    articleDetailLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 通过省市区id查找省市区名称
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
     * 打开/关闭店铺
     * type : is_open=开门营业,is_rest=关门休息,apply_audit=申请审核,apply_verify=申请认证
     * */
    fun changeStoreStatus(context: Context, storeId: String, type: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["id"] = storeId
        paramMap["type"] = type
        HttpUtil.put(
            context, UrlConstant.STORE_OPERATION + storeId + "/operation", paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    changeStoreStatusLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
    fun closeStore(context: Context, storeId: String){
        changeStoreStatus(context,storeId,"is_rest",true)
    }
    fun openStore(context: Context, storeId: String){
        changeStoreStatus(context,storeId,"is_open",true)
    }
}