package com.rush.easynote.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by huangxiaolong1 on 2016/10/19.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String phone;
    private String nickname;
    private String password;

    public User(String nickname, String phone, String password) {
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
    }

    @Generated(hash = 518095013)
    public User(Long id, String phone, String nickname, String password) {
        this.id = id;
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
