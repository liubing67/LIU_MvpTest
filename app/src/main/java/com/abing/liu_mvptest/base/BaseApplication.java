package com.abing.liu_mvptest.base;

import android.app.Application;
import android.content.Context;

import com.abing.liu_mvptest.utils.common.ToastUtil;
import com.yanzhenjie.nohttp.NoHttp;

/**
 * 项目名称：LIU_MvpTest
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017-10-12 17:12
 * 修改人：Administrator
 * 修改时间：2017-10-12 17:12
 * 修改备注：
 */
public class BaseApplication extends Application {
    private static BaseApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NoHttp.initialize(this);
        ToastUtil.init(this);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
