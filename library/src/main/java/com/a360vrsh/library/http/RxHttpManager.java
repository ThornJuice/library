package com.a360vrsh.library.http;


import android.app.Application;

import com.a360vrsh.library.util.MMKVUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import rxhttp.RxHttp;
import rxhttp.wrapper.cookie.CookieStore;
import rxhttp.wrapper.param.Method;
import rxhttp.wrapper.ssl.HttpsUtils;
import rxhttp.wrapper.ssl.HttpsUtils.SSLParams;


public class RxHttpManager {


//    @OkClient(name = "SimpleClient", className = "Simple")
//    public static OkHttpClient simpleClient = new OkHttpClient.Builder().build();


    public static void init(Application context, boolean debug) {
        File file = new File(context.getExternalCacheDir(), "RxHttpCookie");
        SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new CookieStore(file))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager) //添加信任证书
                .hostnameVerifier((hostname, session) -> true) //忽略host验证
//            .followRedirects(false)  //禁制OkHttp的重定向操作，我们自己处理重定向
//                .addInterceptor(new HttpInterceptor())
                .build();
        //RxHttp初始化，自定义OkHttpClient对象，非必须
        RxHttp.init(client, debug);

        //设置缓存策略，非必须
//        File cacheFile = new File(context.getExternalCacheDir(), "RxHttpCache");
////        RxHttpPlugins.setCache(cacheFile, 1000 * 100, CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
////        RxHttpPlugins.setExcludeCacheKeys("time"); //设置一些key，不参与cacheKey的组拼

        //设置数据解密/解码器，非必须
//        RxHttp.setResultDecoder(s -> s);

        //设置全局的转换器，非必须
//        RxHttp.setConverter(FastJsonConverter.create());

        //设置公共参数，非必须
        RxHttp.setOnParamAssembly(onParamAssembly -> {
            /*根据不同请求添加不同参数，子线程执行，每次发送请求前都会被回调
            如果希望部分请求不回调这里，发请求前调用Param.setAssemblyEnabled(false)即可
             */
            Method method = onParamAssembly.getMethod();
//            if (method.isGet()) { //Get请求
//
//            } else if (method.isPost()) { //Post请求
//
//            }
            return onParamAssembly
                    .addHeader("accept", "application/json")
                    .addHeader("ticket", MMKVUtil.getTicket()); //添加公共请求头

        });
    }
}
