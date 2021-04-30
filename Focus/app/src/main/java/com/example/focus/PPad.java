package com.example.focus;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PPad extends RecyclerView.Adapter {

    ArrayList<ACT> AArray;

    ArrayList<String> pArray;
    Context context;
    ACT act;
    int min;
    int sec;

    public PPad( ArrayList<ACT> AArray,ACT act, ArrayList<String> pArray,int min,int sec, Context context) {
        this.pArray = pArray;
        this.context = context;
        this.act = act;
        this.min = min;
        this.sec = sec;
        this.AArray =AArray;

    }

    public PPad(ACT act, ArrayList<String> pArray,int min,int sec, Context context) {
        this.pArray = pArray;
        this.context = context;
        this.act = act;
        this.min = min;
        this.sec = sec;

    }

    public PPad(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder) holder).time.setText("Time Taken: "+arry.arrayl.get(position).getMin() + ":"+ arry.arrayl.get(position).getSec() + " ");
        ((ViewHolder) holder).name.setText("Your activity was: "+arry.arrayl.get(position).getActi() + " ");
        ((ViewHolder) holder).date.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));




    }


    @Override
    public int getItemCount() {
        return arry.arrayl.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView time;
        public TextView sec;
        public View view;
        public TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            name = itemView.findViewById(R.id.textView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.textView3);
            //   sec = itemView.findViewById(R.id.textViews);


        }


    }


}
