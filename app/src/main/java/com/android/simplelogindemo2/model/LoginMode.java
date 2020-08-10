package com.android.simplelogindemo2.model;

import com.android.simplelogindemo2.model.Listener.LoginListener;

// model负责的是数据以及业务逻辑
public class LoginMode implements IModel{

    private String mUserName = "jenchiehli";
    private String mPassWord = "123";

    public void login(String username, String password, LoginListener listener) {
        if (listener == null) {
            return;
        }
        if (mUserName.equals(username) && mPassWord.equals(password)) {
            listener.onSuccess();
        } else {
            listener.onFails();
        }
    }
}
