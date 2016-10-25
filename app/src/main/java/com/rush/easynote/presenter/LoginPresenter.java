package com.rush.easynote.presenter;

import com.rush.easynote.model.IUser;
import com.rush.easynote.model.UserModel;
import com.rush.easynote.view.ILoginView;

/**
 * Created by huangxiaolong1 on 2016/10/24.
 */

public class LoginPresenter {
    private ILoginView mLoginView;
    private IUser mUser;
    public LoginPresenter(ILoginView iLoginView){
        mLoginView = iLoginView;
        mUser = new UserModel();
    }

    public void login(){

    }
}
