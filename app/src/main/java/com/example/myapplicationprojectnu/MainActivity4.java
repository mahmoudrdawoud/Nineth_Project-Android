package com.example.myapplicationprojectnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText ProductName , ProductPrice , QuantityAvailable ;
    Button add, show;
    MYDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        ////////////////////////////////////////////////////////////////////////////////////////////
        db=new MYDB(this);

        ProductName=findViewById(R.id.ProductNameInfo);
        ProductPrice=findViewById(R.id.ProductPriceInfo);
        QuantityAvailable=findViewById(R.id.QuantityAvailableInfo);
        add=findViewById(R.id.add);
        show=findViewById(R.id.show);


        ProductName.setInputType(InputType.TYPE_NULL);
        ProductPrice.setInputType(InputType.TYPE_NULL);
        QuantityAvailable.setInputType(InputType.TYPE_NULL);



        ////////////////////////////////////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////////
        add.setOnClickListener(view -> {
            String myProductName =ProductName.getText().toString();
            double myProductPrice =Double.parseDouble(ProductPrice.getText().toString());
            double myQuantityAvailable =Double.parseDouble(QuantityAvailable.getText().toString());

            Information emp=new Information(myProductName,myProductPrice,myQuantityAvailable);

            boolean b=db.addEmp(emp);
            if (b)
                Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Failed Added", Toast.LENGTH_SHORT).show();




        });

        ////////////////////////////////////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////////
        show.setOnClickListener(view -> {

            Intent i=new Intent(this,MainActivity5.class);
            startActivity(i);
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}