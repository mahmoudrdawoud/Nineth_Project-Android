package com.example.myapplicationprojectnu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private Context c;
    private ArrayList<Information> data;
    MYDB db;

    public MyAdapter(Context c, ArrayList<Information> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(c).inflate(R.layout.card_view_item,null,false);
        MyHolder mh=new MyHolder(root);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        Information a=data.get(position);

        holder.cv.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.animation1));

        holder.tv1.setText(""+a.getId());
        holder.tv2.setText(a.getProductName());
        holder.tv1.setOnClickListener(view->{
            Intent i=new Intent(c,Info.class);
            i.putExtra("id",a.getId());
            c.startActivity(i);
        });
        holder.tv2.setOnClickListener(view->{
            Intent i=new Intent(c,Info.class);
            i.putExtra("id",a.getId());
            c.startActivity(i);
        });
        holder.iv.setOnClickListener(view->{
            showPopupMenu(holder.iv,a.getId());
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView tv1,tv2;
        ImageView iv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cv=itemView.findViewById(R.id.cardview);
            tv1=itemView.findViewById(R.id.card_textView1);
            tv2=itemView.findViewById(R.id.card_textView2);
            iv=itemView.findViewById(R.id.imageView6);

        }
    }
    private void showPopupMenu(View view , int t) {
        PopupMenu popupMenu = new PopupMenu(c, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Set an item click listener for the popup menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.ed){
                    Intent i = new Intent(c, newInfo.class);
                    i.putExtra("ttt",t);
                    c.startActivity(i);
                    return true;
                } else if (item.getItemId() == R.id.del) {
                    showDeleteConfirmationDialog(t);
                    return true;
                }else {
                    return false;
                }

            }
        });
        popupMenu.show();
    }
    private void showDeleteConfirmationDialog(int proID) {
        db=new MYDB(c);
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Delete the item");
        builder.setMessage("are you sure ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int d=db.delete(proID);
                Toast.makeText(c, "number of rows deleted is "+d, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(c,MainActivity5.class);
                c.startActivity(i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
