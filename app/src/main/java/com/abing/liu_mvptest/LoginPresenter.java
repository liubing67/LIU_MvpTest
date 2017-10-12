package com.abing.liu_mvptest;

import com.abing.liu_mvptest.base.BasePresenter;
import com.abing.liu_mvptest.utils.HttpUtils;


//P层
//特点：持有UI层和数据层引用
public class LoginPresenter extends BasePresenter<LoginView> {

    //持有M层引用
    private LoginModel loginModel;

    //构造方法绑定UI层
    public LoginPresenter() {
        this.loginModel = new LoginModel();
    }

    public void login(String username, String password) {
        this.loginModel.login(username, password, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                //回调UI层->和UI进行交互
                if (getView() != null) {
                    getView().onLoginResult(result);
                }
            }
        });
    }

}
