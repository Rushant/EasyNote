package com.rush.easynote.view;

import com.rush.easynote.model.User;

/**
 * Created by huangxiaolong1 on 2016/10/24.
 */

public interface IRegisterView {

    String getNickName();
    String getPhone();
    String getPassword();
    void registerSuccess(User user);
    void registerFailed();
    void showProgressbar();
    void hideProgressbar();
}
