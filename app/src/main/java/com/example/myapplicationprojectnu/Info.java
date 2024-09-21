package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView name,price,qty;
    MYDB mydb;
    Information information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name=findViewById(R.id.ProductNameInfo);
        price=findViewById(R.id.ProductPriceInfo);
        qty=findViewById(R.id.QuantityAvailableInfo);


        mydb=new MYDB(this);
        int id= (int) getIntent().getExtras().get("id");
        information =mydb.search(id);
        name.setText(information.getProductName());
        price.setText(String.valueOf(information.getProductPrice()));
        qty.setText(String.valueOf(information.getQuantityAvailable()));
    }
}