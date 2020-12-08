package com.a360vrsh.library.util;

import rxhttp.wrapper.annotation.DefaultDomain;

/**
 * @author: wxj
 * @date: 2020/8/13
 * @description:
 */
public class UrlConstant {
    @DefaultDomain //设置为默认域名
    public static String BASE_URL = "http://gatewy.test.360vrsh.com";

    //全景预览pano_id=22397
    public static String PANO_URL = "http://sjm.test.360vrsh.com/preview?pano_id=";
    //图片上传
    public static String UPLOAD = BASE_URL + "/api/cmm/upload";
    //批量图片上传
    public static String UPLOADS = BASE_URL + "/api/cmm/uploads";
    //通过省市区地址查找对应的id
    public static String GEOCODER_REVERSE = BASE_URL + "/api/cmm/geocoder/reverse";
    //首页推荐文章列表
    public static String RECOMMEND_ARTICLE = BASE_URL + "/api/find/article/lists";
    //首页推荐文章详情
    public static String RECOMMEND_ARTICLE_DETAIL = BASE_URL + "/api/find/article/";
    //CHECK_TICKET
    public static String CHECK_TICKET = BASE_URL + "/api/scenter/checkTicket";
    //获取验证码-注册、忘记密码 修改手机号使用
    public static String REGISTER_GET_CODE = BASE_URL + "/api/scenter/sms";
    //注册
    public static String REGISTER = BASE_URL + "/api/scenter/register";
    //账号密码登录
    public static String LOGIN_BY_PWD = BASE_URL + "/api/cas/login/store/account";
    //获取验证码-登录使用
    public static String GET_CODE = BASE_URL + "/api/cas/sms";
    //验证码登录
    public static String LOGIN_BY_CODE = BASE_URL + "/api/cas/login/store/phone";
    //验证码登录
    public static String LOGIN_OUT = BASE_URL + "/api/cas/logout";
    //当前账号信息
    public static String CURRENT_USER = BASE_URL + "/api/scenter/currentUser";
    //城市列表
    public static String AREA_LIST = BASE_URL + "/api/cmm/area/all";
    //根据id返回省市区名称  /cmm/api/area/check?province_id=16&city_id=240&region_id=2664
    public static String AREA_CHECK = BASE_URL + "/api/cmm/area/check";

    //店铺行业-一级
    public static String STORE_TYPE = BASE_URL + "/api/scenter/manage/store/type";
    //店铺分类-二级
    public static String STORE_TYPE_CHILD = BASE_URL + "/api/scenter/manage/store/class/list";
    //店铺信息
    public static String STORE_INFO = BASE_URL + "/api/scenter/manage/store/";
    //保存店铺基本信息 /api/scenter/manage/store/14260/basic
    public static String SAVE_BASIC = BASE_URL + "/api/scenter/manage/store/";
    //保存行业信息 /api/scenter/manage/store/14211/industry
    public static String SAVE_INDUSTRY = BASE_URL + "/api/scenter/manage/store/";
    //店铺操作 /manage/store/{id}/operation
    public static String STORE_OPERATION = BASE_URL + "/api/scenter/manage/store/";
    //商品分类列表
    public static String GOODS_CLASS = BASE_URL + "/api/goods/manage/class";
    //添加商品分类
    public static String ADD_GOODS_CLASS = BASE_URL + "/api/goods/manage/class/add";
    //编辑/删除商品分类
    public static String OPERATION_GOODS_CLASS = BASE_URL + "/api/goods/manage/class/";
    //商品列表
    public static String GOODS_LIST = BASE_URL + "/api/goods/manage/goods";
    //商品详情
    public static String GOODS_DETAIL = BASE_URL + "/api/goods/manage/goods/";
    //添加商品
    public static String GOODS_ADD = BASE_URL + "/api/goods/manage/goods/add";
    //删除商品
    public static String GOODS_DELETE = BASE_URL + "/api/goods/manage/goods/";
    //编辑商品信息 /api/goods/manage/goods/id
    public static String EDIT_GOODS = BASE_URL + "/api/goods/manage/goods/";
    //编辑完提交商品审核 /api/goods/manage/goods/21254/audit/submit
    public static String EDIT_GOODS_AUDIT = BASE_URL + "/api/goods/manage/goods/";
    //门票列表 /api/goods/manage/toruism/ticket/21254/list?
    public static String TICKET_LIST = BASE_URL + "/api/goods/manage/toruism/ticket/";
    //门票详情 /api/goods/manage/toruism/ticket/get?ticket_id=201&goods_id=21255
    public static String TICKET_INFO = BASE_URL + "/api/goods/manage/toruism/ticket/get";
    //商品上架
    public static String GOODS_START = BASE_URL + "/api/goods/manage/goods/sales/start";
    //商品下架
    public static String GOODS_STOP = BASE_URL + "/api/goods/manage/goods/sales/stop";
    //我的全景
    public static String MY_PANO = BASE_URL + "/api/scenter/manage/pano";
    //店铺的全景信息
    public static String STORE_PANO = BASE_URL + "/api/scenter/pano/";
    //当前店铺模板
    public static String STORE_TEMPLATE = BASE_URL + "/api/scenter/manage/menu/status";
    //选择店铺模板
    public static String CHOOSE_STORE_TEMPLATE = BASE_URL + "/api/scenter/manage/menu/status";
    //售后列表
    public static String REFUND_LIST = BASE_URL + "/api/order/refunds/list";
    //售后详情
    public static String REFUND_DETAIL = BASE_URL + "/api/order/refunds/";
    //评价列表
    public static String EVALUATE_LIST = BASE_URL + "/api/fc/comment/store";
    //订单列表
    public static String ORDER_LIST = BASE_URL + "/api/order/orders/list";
    //订单详情
    public static String ORDER_DETAIL = BASE_URL + "/api/order/orders/";
    //修改订单状态 /orders/{id}/update
    public static String ORDER_UPDATE = BASE_URL + "/api/order/orders/";
    //修改密码
    public static String UPDATE_PWD = BASE_URL + "/api/scenter/modifyPwd";
    //忘记密码
    public static String FORGET_PWD = BASE_URL + "/api/scenter/modifyPwd";
    //更改用户手机号
    public static String UPDATE_PHONE = BASE_URL + "/api/scenter/user/change/phone";
    //自定义分享/api/scenter/manage/store/14097/share
    public static String DIY_SHARE = BASE_URL + "/api/scenter/manage/store/";
    //红包管理
    public static String RED_PACKET_LIST = BASE_URL + "/api/redpack/redpack/lists";
    //发红包
    public static String RED_PACKET_ADD = BASE_URL + "/api/redpack/redpack/add";
    //删除红包/api/redpack/redpack/33/operation
    public static String RED_PACKET_DELETE = BASE_URL + "/api/redpack/redpack/";
    //红包详情/api/redpack/redpack/26
    public static String RED_PACKET_DETAIL = BASE_URL + "/api/redpack/redpack/";
    //红包领取记录/api/redpack/redpack/26/receive
    public static String RED_PACKET_RECEIVE = BASE_URL + "/api/redpack/redpack/";
}
