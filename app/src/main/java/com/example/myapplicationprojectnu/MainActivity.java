package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Runnable re = () -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        };

        Handler r = new Handler();
        r.postDelayed(re, 2000);


    }

}