package com.abing.liu_mvptest;


import com.abing.liu_mvptest.base.BaseModel;
import com.abing.liu_mvptest.utils.http.HttpUtils;
import com.abing.liu_mvptest.utils.nohttp.HttpListener;
import com.yanzhenjie.nohttp.RequestMethod;

import java.util.Map;

//M层
public class LoginModel extends BaseModel{

//    public void login(String username, String password, final HttpUtils.OnHttpResultListener onHttpResultListener) {
//
//
////        HttpTask httpTask = new HttpTask(new HttpUtils.OnHttpResultListener() {
////            @Override
////            public void onResult(String result) {
////                onHttpResultListener.onResult(result);
////            }
////        });
////        httpTask.execute(HttpUtils.URL_STR, username, password);
//    }

    public void login(int what, Map<String,Object> map, String url, HttpListener<String> callback){
        HttpRequestQueueString(what,map,url,RequestMethod.POST,true,true,callback);
    }
}
