package com.a360vrsh.pansmartcitystory.activity.common

import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.bean.EventID
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.ToastUtil
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.PoiListAdapter
import com.a360vrsh.pansmartcitystory.bean.PoiEventBean
import com.a360vrsh.pansmartcitystory.util.showToast
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.search.core.PoiInfo
import com.baidu.mapapi.search.core.SearchResult
import com.baidu.mapapi.search.geocode.*
import com.baidu.mapapi.search.poi.*
import com.blankj.utilcode.util.KeyboardUtils
import kotlinx.android.synthetic.main.activity_poi_bai_du.*
import org.greenrobot.eventbus.EventBus


/**
 * 百度poi检索
 * */
class PoiBaiDuActivity : BaseTitleActivity(), OnGetPoiSearchResultListener {
    private var latitude: Double? = null//= 34.755101//维度
    private var longitude: Double? = null//= 113.665911//经度

    private var keyword: String? = null
    private var city: String? = null
    private var province: String? = null
    private var district: String? = null
    private val mPoiSearch: PoiSearch by lazy { PoiSearch.newInstance() }
    private val mGeoCoder: GeoCoder by lazy { GeoCoder.newInstance() }
    private var baiduMap: BaiduMap? = null
    private val poiListAdapter: PoiListAdapter by lazy { PoiListAdapter(null) }
    private val searchListAdapter: PoiListAdapter by lazy { PoiListAdapter(null) }
    private val poiEventBean: PoiEventBean by lazy { PoiEventBean(EventID.REVERSE_GEOCODE_SUCCESS) }
    private var isSearch = false

    override fun getLayoutId(): Int {
        return R.layout.activity_poi_bai_du
    }

    override fun initView() {
        intent.getStringExtra("lat")?.let {
            latitude = it.toDouble()
        }
        intent.getStringExtra("lng")?.let {
            longitude = it.toDouble()
        }
        city = intent.getStringExtra("city")
        district = intent.getStringExtra("district")

        titleText.text = "基本信息"

        baiduMap = textureMapView.map
        textureMapView.showZoomControls(false)
        RecyclerViewUtil.setVerticalManager(this@PoiBaiDuActivity, recyclerView)
        recyclerView.adapter = poiListAdapter
        RecyclerViewUtil.setVerticalManager(this@PoiBaiDuActivity, rv_search)
        rv_search.adapter = searchListAdapter
    }

    override fun initData() {
        if (latitude != null && longitude != null) {
            setMapStatus(latitude, longitude)
            searchNearBy(latitude, longitude)
        } else {
            if (!city.isNullOrEmpty() && !district.isNullOrEmpty()) {
                mGeoCoder.geocode(
                    GeoCodeOption()
                        .city(city)
                        .address(district)
                )
            }
        }
    }

    override fun initListener() {
        tvRight.setOnClickListener {
            showToast("")
            finish()
        }
        mPoiSearch.setOnGetPoiSearchResultListener(this)//设置搜索监听事件
        mGeoCoder.setOnGetGeoCodeResultListener(geoCoderResultListener) //设置地理编码回调监听

        poiListAdapter.setOnItemClickListener { _, _, position ->
            poiListAdapter.position = position
            val item = poiListAdapter.getItem(position)
            item?.let {
                val reverseGeoCodeOption = ReverseGeoCodeOption()
                reverseGeoCodeOption.location(
                    LatLng(
                        it.location.latitude,
                        it.location.longitude
                    )
                )

                poiEventBean.address = it.address
                poiEventBean.lat = "" + it.location.latitude
                poiEventBean.lng = "" + it.location.longitude

                mGeoCoder.reverseGeoCode(reverseGeoCodeOption) //将坐标点转换为地址信息 反向地理编码

            }

        }
        searchListAdapter.setOnItemClickListener { _, _, position ->
            searchListAdapter.position = position
            val item = searchListAdapter.getItem(position)
            item?.let {
                val reverseGeoCodeOption = ReverseGeoCodeOption()
                reverseGeoCodeOption.location(
                    LatLng(
                        it.location.latitude,
                        it.location.longitude
                    )
                )

                poiEventBean.address = it.address
                poiEventBean.lat = "" + it.location.latitude
                poiEventBean.lng = "" + it.location.longitude

                mGeoCoder.reverseGeoCode(reverseGeoCodeOption) //将坐标点转换为地址信息 反向地理编码

            }
        }
        //搜索
        ll_go_search.setOnClickListener {
            ll_map_group.visibility = View.GONE
            ll_search_group.visibility = View.VISIBLE
            edt_search.requestFocus()
            KeyboardUtils.showSoftInput(this@PoiBaiDuActivity)
        }
        //取消搜索
        tv_cancel.setOnClickListener {
            ll_map_group.visibility = View.VISIBLE
            ll_search_group.visibility = View.GONE
            KeyboardUtils.hideSoftInput(this@PoiBaiDuActivity)
        }
        //清除搜索内容
        iv_clear.setOnClickListener { edt_search.setText("") }
        edt_search.setOnEditorActionListener(TextView.OnEditorActionListener { v: TextView?, actionId: Int, event: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                keyword = edt_search.text.toString().trim()

                if (keyword.isNullOrEmpty()) {

                    ToastUtil.show("请输入搜索内容")

                } else {
                    searchNearBy(latitude, longitude)
                }

                return@OnEditorActionListener true

            }

            false

        })
        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                keyword = s.toString()
                if (!keyword.isNullOrEmpty()) {
                    iv_clear.visibility = View.VISIBLE

                    isSearch = true
                    searchNearBy(latitude, longitude)
                } else {
                    iv_clear.visibility = View.GONE
                }
            }
        })
        baiduMap?.setOnMapStatusChangeListener(object : OnMapStatusChangeListener {
            override fun onMapStatusChangeStart(mapStatus: MapStatus) {}
            override fun onMapStatusChangeStart(mapStatus: MapStatus, i: Int) {}
            override fun onMapStatusChangeFinish(mapStatus: MapStatus) {
                latitude = mapStatus.target.latitude
                longitude = mapStatus.target.longitude

                isSearch = false
                searchNearBy(latitude, longitude)
            }

            override fun onMapStatusChange(mapStatus: MapStatus) {}
        })
    }


    /* 设置地图状态*/
    private fun setMapStatus(latitude: Double?, longitude: Double?) {
        if (latitude == null || longitude == null) {
            return
        }
        //定义地图状态
        val mMapStatus = MapStatus.Builder()
            .target(LatLng(latitude, longitude))
            .zoom(18f)
            .build()
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        val mMapStatusUpdate = MapStatusUpdateFactory
            .newMapStatus(mMapStatus)
        //改变地图状态
        baiduMap?.setMapStatus(mMapStatusUpdate)
        baiduMap?.animateMapStatus(mMapStatusUpdate)
    }

    private fun searchNearBy(
        latitude: Double?,
        longitude: Double?
    ) {
        if (latitude == null || longitude == null) {
            return
        }
        val option = PoiNearbySearchOption()
        option.sortType(PoiSortType.distance_from_near_to_far)
        option.location(LatLng(latitude, longitude))
        option.radius(2000)
        option.pageCapacity(30)
        if (keyword.isNullOrBlank()) {
            keyword = "写字楼,小区"
        }
        option.keyword(keyword)
        mPoiSearch.searchNearby(option)

        KeyboardUtils.hideSoftInput(this@PoiBaiDuActivity)
    }

    override fun onGetPoiIndoorResult(p0: PoiIndoorResult?) {
    }

    /**
     * 检索结果
     * */
    override fun onGetPoiResult(poiResult: PoiResult?) {
        poiResult?.allPoi?.apply {
            val nearList = ArrayList<PoiInfo>()
            this.forEach {
                if (it.location != null) {
                    nearList.add(it)
                }
            }
//            ToastUtil.show("size" + nearList.size)

            if (isSearch) {
                searchListAdapter.setNewData(nearList)
                ll_map_group.visibility = View.GONE
                ll_search_group.visibility = View.VISIBLE
            } else {
                poiListAdapter.setNewData(nearList)
                ll_map_group.visibility = View.VISIBLE
                ll_search_group.visibility = View.GONE
            }
        }
    }

    override fun onGetPoiDetailResult(p0: PoiDetailResult?) {

    }

    private var geoCoderResultListener: OnGetGeoCoderResultListener =
        object : OnGetGeoCoderResultListener {
            override fun onGetGeoCodeResult(geoCodeResult: GeoCodeResult?) {
                //正向地理编码回调，注意geoCodeResult中错误码的处理

                geoCodeResult?.let {
                    if (it.error !== SearchResult.ERRORNO.NO_ERROR) {
                        //没有检索到结果
                        LogUtil.e("PoiBaiDuActivity", "没有检测到结果")
                    } else {
                        val latitude = it.location.latitude
                        val longitude = it.location.longitude

                        searchNearBy(latitude, longitude)
                        setMapStatus(latitude, longitude)
                        LogUtil.e(
                            "PoiBaiDuActivity",
                            "onGetGeoCodeResult" + "latitude" + latitude + "longitude" + longitude
                        )
                    }
                }

            }

            override fun onGetReverseGeoCodeResult(reverseGeoCodeResult: ReverseGeoCodeResult?) {
                //反向地理编码回调 坐标转换成地址
                if (reverseGeoCodeResult == null
                    || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR
                ) {
                    // 没有检测到结果
                    LogUtil.e("PoiBaiDuActivity", "没有检测到结果")
                } else {
                    city = reverseGeoCodeResult.addressDetail.city //层次化地址信息
                    province = reverseGeoCodeResult.addressDetail.province
                    district = reverseGeoCodeResult.addressDetail.district

                    poiEventBean.province = province
                    poiEventBean.city = city
                    poiEventBean.district = district
                    EventBus.getDefault().post(poiEventBean)

                    LogUtil.e(
                        "PoiBaiDuActivity", "onGetReverseGeoCodeResult" +
                                "city" + city + "province" + province + "district" + district
                    )
                    finish()
                }
            }
        }

    override fun initObserver() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mPoiSearch.destroy()
    }
}