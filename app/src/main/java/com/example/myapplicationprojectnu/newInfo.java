package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newInfo extends AppCompatActivity {
    EditText ProductName , ProductPrice , QuantityAvailable ;
    Button save, cancel;
    MYDB db;
    Information ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_info);
        db=new MYDB(this);

        ProductName=findViewById(R.id.PN);
        ProductPrice=findViewById(R.id.PP);
        QuantityAvailable=findViewById(R.id.QA);
        save=findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);

        int id= (int) getIntent().getExtras().get("ttt");
        ii=db.search(id);

        ProductName.setText(ii.getProductName());
        ProductPrice.setText(""+(int) ii.getProductPrice());
        QuantityAvailable.setText(""+(int) ii.getQuantityAvailable());

        save.setOnClickListener(view->{
            String myProductName =ProductName.getText().toString();
            double myProductPrice =Double.parseDouble(ProductPrice.getText().toString());
            double myQuantityAvailable =Double.parseDouble(QuantityAvailable.getText().toString());

            Information emp=new Information(id,myProductName,myProductPrice,myQuantityAvailable);
            db.update(emp);
            Toast.makeText(this, "success updating", Toast.LENGTH_SHORT).show();
            Intent u =new Intent(this,MainActivity5.class);
            startActivity(u);
        });
        cancel.setOnClickListener(view->{
            Intent u =new Intent(this,MainActivity5.class);
            startActivity(u);
        });
    }
}