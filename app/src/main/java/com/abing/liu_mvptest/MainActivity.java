package com.abing.liu_mvptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.abing.liu_mvptest.base.BaseActivity;
import com.abing.liu_mvptest.base.BasePresenter;
import com.abing.liu_mvptest.base.BaseView;
import com.abing.liu_mvptest.utils.http.HttpUtils;
import com.abing.liu_mvptest.utils.nohttp.HttpListener;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：LIU_MvpTest
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017-9-16 17:53
 * 修改人：Administrator
 * 修改时间：2017-9-16 17:53
 * 修改备注：
 */
public class MainActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    public LoginPresenter createPresneter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    private void initView(){
        findViewById(R.id.email_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map=new HashMap<String, Object>();
                map.put("username","17321436171");
                map.put("password","123456789");
                getPresneter().login(1, map, HttpUtils.URL_STR, httpListener);
            }
        });
    }
    HttpListener<String> httpListener=new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            Toast.makeText(MainActivity.this, response.get(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailed(int what, Response<String> response) {

        }
    };
    @Override
    public void onLoginResult(String result) {
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
    }
}
