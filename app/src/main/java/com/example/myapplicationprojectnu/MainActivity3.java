package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText username , password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);


        username.setInputType(InputType.TYPE_NULL);
        password.setInputType(InputType.TYPE_NULL);
        login.setInputType(InputType.TYPE_NULL);

        login.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity3.this, MainActivity4.class);

            if (username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
                Toast.makeText(this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                i.putExtra("the name",username.getText().toString());
                startActivity(i);

            } else {
                Toast.makeText(this, "Error UserName Or Password", Toast.LENGTH_SHORT).show();
            }
        });



    }
}