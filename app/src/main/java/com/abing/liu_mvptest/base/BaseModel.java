package com.abing.liu_mvptest.base;

import com.abing.liu_mvptest.utils.nohttp.HttpListener;
import com.abing.liu_mvptest.utils.nohttp.HttpResponseListener;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.ssl.SSLUtils;

import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/**
 * 项目名称：LIU_MvpTest
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017-10-12 17:38
 * 修改人：Administrator
 * 修改时间：2017-10-12 17:38
 * 修改备注：
 */
public class BaseModel {

    /**
     * 请求队列。
     */
    private RequestQueue mQueue;

    public BaseModel() {
        // 初始化请求队列，传入的参数是请求并发值。
        mQueue = NoHttp.newRequestQueue();
    }

    /**
     * 发起请求。
     *
     * @param what      what.
     * @param request   请求对象。
     * @param callback  回调函数。
     * @param canCancel 是否能被用户取消。
     * @param isLoading 实现显示加载框。
     * @param <T>       想请求到的数据类型。
     */
    public <T> void request(int what, Request<T> request, HttpListener<T> callback,
                            boolean canCancel, boolean isLoading) {
        request.setCancelSign(this);
        mQueue.add(what, request, new HttpResponseListener<>(BaseActivity.instance, request, callback, canCancel, isLoading));
    }

    public void HttpRequestQueueString(int what, Map<String, Object> map, String url, RequestMethod requestMethod, boolean canCancel, boolean isLoading, HttpListener<String> callback) {
        Request<String> httpsRequest = NoHttp.createStringRequest(url, requestMethod);
        httpsRequest.add(map);
        request(what, httpsRequest, callback, canCancel, isLoading);
    }
}
