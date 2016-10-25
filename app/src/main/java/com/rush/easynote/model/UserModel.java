package com.rush.easynote.model;

/**
 * Created by huangxiaolong1 on 2016/10/24.
 */

public class UserModel implements IUser {
    @Override
    public void register(final String nickname, final String phone, final String password, final IregisterListener iregisterListener) {

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("hxl".equals(nickname) && "110".equals(phone) && "123".equals(password)) {
                    User user = new User();
                    user.setNickname(nickname);
                    user.setPhone(phone);
                    user.setPassword(password);

                    iregisterListener.registerSucess(user);
                } else {
                    iregisterListener.registerFail();
                }
            }
        }.start();
    }

    @Override
    public void login(String phone, String password) {

    }
}
