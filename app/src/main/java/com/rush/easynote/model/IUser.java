package com.rush.easynote.model;

/**
 * Created by huangxiaolong1 on 2016/10/24.
 */

public interface IUser {
    void register(String nickname, String phone, String password, IregisterListener iregisterListener);
    void login(String phone, String password);

}
