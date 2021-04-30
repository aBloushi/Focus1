package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ActivRe extends AppCompatActivity {
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ_re);

        ArrayList<String> OO = new ArrayList<String>();
        ArrayList<Integer> EE = new ArrayList<Integer>();
        ArrayList<Integer> AA = new ArrayList<Integer>();


        Intent get = getIntent();

       //  ACT act=(ACT) get.getSerializable("act");
          ACT act= (ACT) get.getSerializableExtra("act");


        /////////////////
        Bundle bun = getIntent().getExtras();
        //arr.add(act);

//        try {
//
//            int min =act.getMin();
//            int sec =act.getSec();
//            String name = act.getActi();
//
//            Log.e("TAG",act.getSec()+"");
//            OO.add(name);
//        } catch (Exception e) {
//
//        }



//        int min =get.getInt("min");
//        int sec =get.getInt("sec");

//
//        ACT actN = new ACT(Name,sec,min);
//        ArrayList<ACT> arr = new ArrayList<ACT>();




//        EE.add(min);
//        AA.add(sec);

        RecyclerView rv = findViewById(R.id.rec);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        try {

            int min =act.getMin();
            int sec =act.getSec();
            String name = act.getActi();

            Log.e("TAG",act.getSec()+"");
            OO.add(name);

            PPad ad = new PPad(act,OO,min,sec,this);

            rv.setAdapter(ad);
        } catch (Exception e) {
            PPad ar = new PPad(this);
            rv.setAdapter(ar);
        }







    }
}