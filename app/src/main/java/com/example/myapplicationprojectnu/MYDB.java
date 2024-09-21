package com.example.myapplicationprojectnu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MYDB extends SQLiteOpenHelper {

    static String DBNAME="Information.DB";
    static int VERSION=12;
    Context myContext;

    public MYDB(@Nullable Context context) {
        super(context,DBNAME, null, VERSION);
        this.myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase x) {
        Toast.makeText(myContext, "onCreate", Toast.LENGTH_SHORT).show();
        x.execSQL(Information.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase x, int i, int i1) {

    }

    public boolean addEmp(Information e){
        SQLiteDatabase s=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(Information.COL_NAME,e.getProductName());
        cv.put(Information.COL_PRICE,e.getProductPrice());
        cv.put(Information.COL_AVAILABLE,e.getQuantityAvailable());
        long l=s.insert(Information.TABLE_NAME,null,cv);

        return l!=-1;
    }

    public ArrayList<Information> show(){

        ArrayList<Information> e=new ArrayList<>();
        SQLiteDatabase s=getReadableDatabase();
        Cursor c=s.rawQuery("select * from "+Information.TABLE_NAME,null);
        while (c.moveToNext()){
            int id=c.getInt(0);
            String ProductName =c.getString(1);
            double ProductPrice =c.getDouble(2);
            double QuantityAvailable =c.getDouble(3);



            Information emp =new Information(id,ProductName,ProductPrice,QuantityAvailable);
            e.add(emp);
            Log.e("asd","111"+QuantityAvailable);
        }

        return e;
    }

    public Information search(int i){
        Information e=new Information();

        SQLiteDatabase s=getReadableDatabase();
        String [] args={String.valueOf(i)};
        Cursor c=s.rawQuery("select * from "
                +Information.TABLE_NAME+" where "
                +Information.COL_ID+"=?",args);
        while (c.moveToNext()){
            int id=c.getInt(0);
            String ProductName =c.getString(1);
            double ProductPrice =c.getDouble(2);
            double QuantityAvailable =c.getDouble(3);
            e=new Information(id,ProductName,ProductPrice,QuantityAvailable);

        }

        return e;
    }
    public int delete(int i){
        SQLiteDatabase s=getWritableDatabase();
        String [] args={String.valueOf(i)};
        int i1=s.delete(Information.TABLE_NAME,Information.COL_ID+"=?",args);
        return i1;
    }

    public int update(Information e){
        SQLiteDatabase s= getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(Information.COL_NAME,e.getProductName());
        cv.put(Information.COL_PRICE,e.getProductPrice());
        cv.put(Information.COL_AVAILABLE,e.getQuantityAvailable());
        String[]args={String.valueOf(e.getId())};
        int i= s.update(Information.TABLE_NAME,cv,Information.COL_ID+"=?",args);
        return i;
    }

}
