package com.android.simplelogindemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.simplelogindemo2.presenter.LoginPresenter;
import com.android.simplelogindemo2.view.ILoginView;

// LoginActivity展现了一个界面，尤其是实现了ILoginView，代表他是MVP中的V
public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText mUserNameEdit;

    private EditText mPasswordEdit;

    private Button mLoginBtn;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setData();
    }

    private void setView() {
        mUserNameEdit = findViewById(R.id.edit_userName);
        mPasswordEdit = findViewById(R.id.edit_password);
        mLoginBtn = findViewById(R.id.login);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                mPresenter.login();
            }
        });
    }

    private void setData() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return mUserNameEdit.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEdit.getText().toString();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFails() {
        Toast.makeText(getApplicationContext(), "登录失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 记得在销毁的时候断掉引用链
        mPresenter = null;
    }
}