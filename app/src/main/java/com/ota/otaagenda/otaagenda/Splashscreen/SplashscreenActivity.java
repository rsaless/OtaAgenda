package com.ota.otaagenda.otaagenda.Splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ota.otaagenda.otaagenda.Login.LoginActivity;
import com.ota.otaagenda.otaagenda.Main.MainActivity;
import com.ota.otaagenda.otaagenda.R;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread timer= new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openLogin();
                }
            }
        };
        timer.start();

    }

    protected void openLogin(){
        Intent intentLogin = new Intent(SplashscreenActivity.this, LoginActivity.class);
        startActivity(intentLogin);
    }

    protected void openMain(){
        Intent intentMain = new Intent(SplashscreenActivity.this, MainActivity.class);
        startActivity(intentMain);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
