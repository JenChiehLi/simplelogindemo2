package com.android.simplelogindemo2.presenter;

import com.android.simplelogindemo2.model.IModel;
import com.android.simplelogindemo2.model.Listener.LoginListener;
import com.android.simplelogindemo2.model.LoginMode;
import com.android.simplelogindemo2.view.ILoginView;
import com.android.simplelogindemo2.view.IView;

import java.lang.ref.WeakReference;

public class LoginPresenter extends PresenterFather {

    public LoginPresenter(ILoginView loginView) {
        this.mIModel = new LoginMode();
        this.mViewReference = new WeakReference<IView>(loginView);
    }

    public void login() {
        if (mIModel != null && mViewReference != null && mViewReference.get() != null) {
            ILoginView loginView = (ILoginView) mViewReference.get();
            String name = loginView.getUserName();
            String password = loginView.getPassword();
            loginView = null;
            // 此时LoginListener作为匿名内部类是持有外部类的引用的
            ((LoginMode) mIModel).login(name, password, new LoginListener() {
                @Override
                public void onSuccess() {
                    if (mViewReference.get() != null) {
                        ((ILoginView) mViewReference.get()).onLoginSuccess();
                    }
                }

                @Override
                public void onFails() {
                    if (mViewReference.get() != null) {
                        if (mViewReference.get() != null) {
                            ((ILoginView) mViewReference.get()).onLoginFails();
                        }
                    }
                }
            });
        }
    }
}
