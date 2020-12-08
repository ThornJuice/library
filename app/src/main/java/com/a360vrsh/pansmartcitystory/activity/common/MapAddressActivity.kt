package com.a360vrsh.pansmartcitystory.activity.common

import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.AppUtil
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import kotlinx.android.synthetic.main.activity_map_address.*


class MapAddressActivity : BaseTitleActivity() {
    private var latitude: String? = null//= 34.755101//维度
    private var longitude: String? = null//= 113.665911//经度
    private var baiduMap: BaiduMap? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_map_address
    }

    override fun initView() {
        titleText.text = "查看地址"
        latitude = intent.getStringExtra("lat")
        longitude = intent.getStringExtra("lng")
        baiduMap = bmapView_mv.map

        if(latitude.isNullOrEmpty()||longitude.isNullOrEmpty()){
            return
        }else{
            setMapStatus(latitude!!.toDouble(), longitude!!.toDouble())
            tv_navigation.setSingleClick {
                AppUtil.gpThreeMap(this,latitude!!.toDouble(),longitude!!.toDouble())
            }
        }

    }

    /* 设置地图状态*/
    private fun setMapStatus(latitude: Double, longitude: Double) {
        addOverlay(LatLng(latitude, longitude))
        val mMapStatus = MapStatus.Builder()
            .target(LatLng(latitude, longitude))
            .zoom(16f)
            .build()
        val mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus)
        //改变地图状态
        baiduMap?.setMapStatus(mMapStatusUpdate)

    }

    override fun initListener() {

    }

    override fun initObserver() {

    }

    override fun initData() {
    }

    //显示marker
    private fun addOverlay(point: LatLng) {
        //清空地图
        baiduMap?.clear()
        //创建marker的显示图标
        val bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.dkredjt)
        val latLng: LatLng? = null
        val marker: Marker
        val options: OverlayOptions


        //设置marker
        options = MarkerOptions()
            .position(point) //设置位置
            .icon(bitmap) //设置图标样式
            .zIndex(9) // 设置marker所在层级
            .draggable(true) // 设置手势拖拽;
        //添加marker
        marker = baiduMap?.addOverlay(options) as Marker


        //将地图显示在最后一个marker的位置
        val msu = MapStatusUpdateFactory.newLatLng(latLng)
        baiduMap?.setMapStatus(msu)
        //创建InfoWindow展示的view
//        val view =
//            View.inflate(getContext(), R.layout.bdmarker_lay, null)
//        // 填充数据
//        val nameView = view.findViewById<View>(R.id.bdmarket_tv) as TextView
//        nameView.text = "  $title  "


//定义用于显示该InfoWindow的坐标点


//创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
//        val mInfoWindow = InfoWindow(view, point, -77)

//显示InfoWindow
//        baiduMap!!.showInfoWindow(mInfoWindow)
    }
}