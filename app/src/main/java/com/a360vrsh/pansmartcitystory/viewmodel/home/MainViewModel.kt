package com.a360vrsh.pansmartcitystory.viewmodel.home

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description:
 */

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a360vrsh.library.util.ToastUtil
import com.a360vrsh.pansmartcitystory.bean.ArticleListBean
import com.a360vrsh.pansmartcitystory.bean.TravelLMMGoodsDetailBean
import rxhttp.RxHttp

class MainViewModel : ViewModel() {
    var singleBean = MutableLiveData<TravelLMMGoodsDetailBean>()
    var listBean = MutableLiveData<ArticleListBean>()
    fun getDetail() {
        val observable =
            RxHttp.get("http://mb.360vrsh.com/api/lmm/product/2598633?store_id=140961") //发送Get请求
                .asClass(TravelLMMGoodsDetailBean::class.java)

        observable.subscribe(
            { bean: TravelLMMGoodsDetailBean? ->

                singleBean.postValue(bean)
            }
        ) { throwable: Throwable? ->
            ToastUtil.show(throwable?.message)
        }
    }

    fun getArticleList() {
        val observable2 =
            RxHttp.get("http://gatewy.360vrsh.com/api/find/finding?type=1&area_id=2656&page=1&pageSize=10&user_id=0")
                .asClass(ArticleListBean::class.java)

        observable2.subscribe(
            { bean: ArticleListBean? ->
                listBean.postValue(bean)
            }
        ) { throwable: Throwable? ->
            ToastUtil.show(throwable?.message)
        }
    }
}