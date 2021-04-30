package com.example.focus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    TextView timer;
    Button start, pause, reset, pree;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;
    Handler handler;
    int Seconds, Minutes, MilliSeconds;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
//        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
//        SharedPreferences.Editor editor = wmbPreference.edit();
//
//        if (isFirstRun){
//            // Code to run once
//       //
//            editor.putBoolean("FIRSTRUN", false);
//            editor.apply();
 //       }
        timer = (TextView) findViewById(R.id.tvTimer);
        start = (Button) findViewById(R.id.btStart);
        pause = (Button) findViewById(R.id.btPause);
        reset = (Button) findViewById(R.id.btReset);

        handler = new Handler();


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                final EditText edittext = new EditText(MainActivity.this);

                //dialoge
                alert.setMessage("What were you doing?");
                alert.setTitle("Done");

                alert.setView(edittext);





                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value
                        // Editable YouEditTextValue = edittext.getText();
                        //OR

                        int min = Minutes;
                        int sec = Seconds;

                        String activity = edittext.getText().toString();


                        ACT act = new ACT(activity, sec, min);

                        arry.arrayl.add(act);

                   //     ArrayList<ACT> arr = new ArrayList<ACT>();

                     //   arr.add(act);

                        Intent intent = new Intent(MainActivity.this ,ActivRe.class);

                        intent.putExtra("act",act);
//                        intent.putExtra("min",min);
//                        intent.putExtra("sec",sec );





                        startActivity(intent);
                        saveData();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });

                alert.show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;

                timer.setText("00:00:00");

            }
        });


    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefrences" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arry.arrayl);
        editor.putString("task list",json);
        editor.apply();
    }


    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            timer.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };



}