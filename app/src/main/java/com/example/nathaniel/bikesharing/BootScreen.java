package com.example.nathaniel.bikesharing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class BootScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_screen);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            //sets the next activity to the login screen after a period of time in milliseconds
            public void run(){
                Intent mainIntent = new Intent(BootScreen.this,google_sign_in.class);
                BootScreen.this.startActivity(mainIntent);
                BootScreen.this.finish();
            }
        },secondsDelayed * 800);


    }
}
