package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    MYDB db;
    RecyclerView rv;
    ArrayList<Information> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        rv=findViewById(R.id.rv);
        db=new MYDB(this);
        data=db.show();
        MyAdapter myAdapter=new MyAdapter(this,data);
        RecyclerView.LayoutManager ll=new LinearLayoutManager(this);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(ll);


    }
}
