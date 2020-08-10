package com.android.simplelogindemo2.view;

// 写了一个继承自IView的接口
public interface ILoginView extends IView {
    String getUserName();
    String getPassword();
    void onLoginSuccess(); // 登录成功所要执行的功能
    void onLoginFails();   // 登录失败所要执行的功能
}
