package com.rush.easynote.presenter;

import android.os.Handler;

import com.rush.easynote.model.IUser;
import com.rush.easynote.model.IregisterListener;
import com.rush.easynote.model.User;
import com.rush.easynote.model.UserModel;
import com.rush.easynote.view.IRegisterView;

/**
 * Created by huangxiaolong1 on 2016/10/24.
 */

public class RegisterPresenter {
    private IRegisterView mRegisterView;
    private IUser mUser;
    private Handler mHandler = new Handler();

    public RegisterPresenter(IRegisterView iRegisterView){
        mRegisterView = iRegisterView;
        mUser = new UserModel();
    }

    public void register(){

        mUser.register(mRegisterView.getNickName(), mRegisterView.getPhone(), mRegisterView.getPassword(), new IregisterListener() {
            @Override
            public void registerSucess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRegisterView.registerSuccess(user);
                    }
                });

            }

            @Override
            public void registerFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRegisterView.registerFailed();
                    }
                });

            }
        });
    }
}
