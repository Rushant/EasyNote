package com.rush.easynote.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.rush.easynote.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = mSharedPreferences.getString("name", null);
        if(userName == null){
            startActivity(new Intent(this,RegisterViewActivity.class));
            finish();
        }else {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }
}
