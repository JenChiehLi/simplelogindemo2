package com.android.simplelogindemo2.presenter;

import com.android.simplelogindemo2.model.IModel;
import com.android.simplelogindemo2.view.IView;

import java.lang.ref.WeakReference;

// 所有presenter的父类，因为presenter会持有View以及Model部分，所以索性写到总父类里面
public class PresenterFather {

    protected IModel mIModel;

    // 此处View个人感觉最好用的一个弱引用
    protected WeakReference<IView> mViewReference;
}
