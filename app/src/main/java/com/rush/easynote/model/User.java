package com.rush.easynote.model;

/**
 * Created by huangxiaolong1 on 2016/10/19.
 */

public class User {
    private String phone;
    private String nickname;
    private String password;

    public User(String nickname, String phone, String password) {
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
