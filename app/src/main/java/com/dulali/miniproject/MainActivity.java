package com.dulali.miniproject;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    SharedPreferences perf = getSharedPreferences("login" , MODE_PRIVATE);
                    Boolean check = perf.getBoolean("flag" , false);

                    if(check){
                        startActivity(new Intent(MainActivity.this , HomeActivity.class));
                    }
                    else{
                        startActivity(new Intent(MainActivity.this , LoginActivity.class));
                    }



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}