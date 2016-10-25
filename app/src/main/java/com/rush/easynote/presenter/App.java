package com.rush.easynote.presenter;

import android.app.Application;

import com.rush.easynote.model.DaoMaster;
import com.rush.easynote.model.DaoSession;

import org.greenrobot.greendao.database.Database;


/**
 * Created by huangxiaolong1 on 2016/10/25.
 */

public class App extends Application {
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
