package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button start = findViewById(R.id.start);
        Button pree = findViewById(R.id.pre1);

       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainMenu.this , MainActivity.class);
               startActivity(intent);
           }
       });

        pree = (Button) findViewById(R.id.pre1);
        pree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this , ActivRe.class);
                startActivity(intent);
            }
        });

        loadData();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences" , MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<ArrayList<ACT>>(){}.getType();
        arry.arrayl = gson.fromJson(json,type);

        if(arry.arrayl == null){
            arry.arrayl = new ArrayList<>();
        }
    }
}