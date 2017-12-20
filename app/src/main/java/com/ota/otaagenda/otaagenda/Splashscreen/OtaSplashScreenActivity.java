package com.ota.otaagenda.otaagenda.Splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ota.otaagenda.otaagenda.Login.LoginActivity;
import com.ota.otaagenda.otaagenda.R;

public class OtaSplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ota_splash_screen);

        Thread timer= new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openSplash();
                }
            }
        };
        timer.start();


    }

    protected void openSplash(){
        Intent intentLogin = new Intent(OtaSplashScreenActivity.this, SplashscreenActivity.class);
        startActivity(intentLogin);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
