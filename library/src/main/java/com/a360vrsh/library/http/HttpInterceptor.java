package com.a360vrsh.library.http;


import com.a360vrsh.library.bean.EventBean;
import com.a360vrsh.library.bean.EventID;
import com.a360vrsh.library.util.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rxhttp.RxHttp;

/**
 *
 */
public class HttpInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originalResponse = chain.proceed(request);
        int code = originalResponse.code();
        if (code == 200 || code == 201) {//网络请求成功
            try {
                return handleService(chain, request, originalResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        LogUtil.e("HttpInterceptor", "ResponseCode:" + originalResponse.code());
        return originalResponse;
    }


    private Response handleService(Chain chain, Request request, Response response) throws IOException, JSONException {

        RequestBody requestBody = request.body();
        ResponseBody responseBody = response.body();
        Request newRequest;
        JSONObject jsonObject = new JSONObject(responseBody.string());
        int errorCode = jsonObject.optInt("errcode");
        if (errorCode == 0 || errorCode == 201 || errorCode == 200) {//业务请求成功
            switch (request.method()) {
                case "GET":

                    newRequest = RxHttp.get(request.url().toString())
                            .addAll(getHttpUrlParams(request.url())) //添加参数
                            .buildRequest();
                    break;
                case "POST":
                    newRequest = RxHttp.postForm(request.url().toString())
                            .addAll(getHttpUrlParams(requestBody)) //添加参数
                            .buildRequest();
                    break;
                case "DELETE":

                    newRequest = RxHttp.deleteForm(request.url().toString())
                            .addAll(getHttpUrlParams(requestBody)) //添加参数
                            .buildRequest();
                    break;
                case "PUT":

                    newRequest = RxHttp.putForm(request.url().toString())
                            .addAll(getHttpUrlParams(requestBody)) //添加参数
                            .buildRequest();
                    break;
                default:

                    newRequest = request;
                    break;
            }

        } else if (errorCode == 433) {//登录过期
            newRequest = request;
            EventBus.getDefault().post(new EventBean(EventID.GO_TO_LOGIN));
        } else {
            newRequest = request;
        }

        return chain.proceed(newRequest);
    }

    /**
     * 获取url中的参数
     *
     * @param httpUrl
     * @return
     */
    private Map<String, String> getHttpUrlParams(HttpUrl httpUrl) {
        Set<String> paramsSet = httpUrl.queryParameterNames();
        Map<String, String> paramMap = new HashMap<>();
        if (paramsSet != null && paramsSet.size() > 0) {
            for (String s : paramsSet) {
                paramMap.put(s, httpUrl.queryParameter(s));
//                Logger.e("HttpInterceptor", s + "=" + httpUrl.queryParameter(s));
            }
        }
        return paramMap;
    }


    /**
     * 获取请求form中的参数
     *
     * @param requestBody
     * @return
     */
    private Map<String, String> getHttpUrlParams(RequestBody requestBody) {
        HashMap<String, String> mapParam = new HashMap<>();
        if (requestBody instanceof FormBody) {
            FormBody formBody = (FormBody) requestBody;
            for (int i = 0; i < formBody.size(); i++) {
                mapParam.put(formBody.name(i), formBody.value(i));  //2、保存参数
            }
        }
        return mapParam;
    }
}
