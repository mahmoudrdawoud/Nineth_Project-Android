package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Runnable re = () -> {
            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(i);
        };

        Handler r = new Handler();
        r.postDelayed(re, 2000);


    }

}