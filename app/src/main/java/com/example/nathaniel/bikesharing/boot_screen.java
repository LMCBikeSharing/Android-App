package com.example.nathaniel.bikesharing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class boot_screen extends AppCompatActivity {

    @Override//The starter activity constructor defined in the android manifest
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_screen);
        //define the delay of the what the milliseconds will be multiplied to
        int secondsDelayed = 1;
        //create a new handler to create a delay before the code is executed
        new Handler().postDelayed(new Runnable() {
            //sets the next activity to the login screen after a period of time in milliseconds
            public void run(){//execute the next activity code
                //create a new activity intent set as the google sign in class
                Intent mainIntent = new Intent(boot_screen.this,google_sign_in.class);
                //start the next activity defined above
                boot_screen.this.startActivity(mainIntent);
                //close the current activity, which is the boot screen
                boot_screen.this.finish();
            }
        },secondsDelayed * 800);


    }
}
