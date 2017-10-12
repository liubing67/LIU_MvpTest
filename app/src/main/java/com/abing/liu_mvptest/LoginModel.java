package com.abing.liu_mvptest;


import com.abing.liu_mvptest.utils.HttpTask;
import com.abing.liu_mvptest.utils.HttpUtils;


//M层
public class LoginModel {

    public void login(String username, String password, final HttpUtils.OnHttpResultListener onHttpResultListener) {
        HttpTask httpTask = new HttpTask(new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                onHttpResultListener.onResult(result);
            }
        });
        httpTask.execute(HttpUtils.URL_STR, username, password);
    }

}
