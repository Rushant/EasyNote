package com.rush.easynote.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rush.easynote.R;
import com.rush.easynote.model.DaoSession;
import com.rush.easynote.model.User;
import com.rush.easynote.model.UserDao;
import com.rush.easynote.presenter.App;
import com.rush.easynote.presenter.RegisterPresenter;

public class RegisterViewActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener {
    private RegisterPresenter mRegisterPresenter = new RegisterPresenter(this);
    private static final String TAG = "RegisterViewActivity";

    private EditText mNameEdt;
    private EditText mPhoneEdt;
    private EditText mPasswordEdt;
    private Button mRegisterBtn;
    private ProgressBar mProgresssBar;

    private UserDao mUserDao;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        mNameEdt = (EditText) findViewById(R.id.name_editText);
        mPhoneEdt = (EditText) findViewById(R.id.phone_editText);
        mPasswordEdt = (EditText) findViewById(R.id.password_editText);
        mRegisterBtn = (Button) findViewById(R.id.sign_up_button);
        mRegisterBtn.setOnClickListener(this);
        mProgresssBar = (ProgressBar) findViewById(R.id.register_progress);

        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mUserDao = daoSession.getUserDao();
    }

    @Override
    public String getNickName() {
        return mNameEdt.getText().toString();
    }

    @Override
    public String getPhone() {
        return mPhoneEdt.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEdt.getText().toString();
    }

    @Override
    public void registerSuccess(User user) {
        hideProgressbar();
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("name",user.getNickname());
        mEditor.commit();
        // userDao
        mUserDao.insert(user);
        finish();
        Intent mIntent = new Intent(RegisterViewActivity.this,MainActivity.class);
        startActivity(mIntent);
    }

    @Override
    public void registerFailed() {
        hideProgressbar();
        Toast.makeText(mContext,R.string.register_fail,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressbar() {
        mProgresssBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressbar() {
        mProgresssBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_up_button:
                showProgressbar();
                mRegisterPresenter.register();
                break;
        }
    }
}
