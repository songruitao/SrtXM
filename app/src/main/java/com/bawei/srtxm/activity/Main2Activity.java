package com.bawei.srtxm.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bawei.srtxm.R;

public class Main2Activity extends AppCompatActivity {


    private SharedPreferences sharedPreferences;
    private boolean isFirstRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        sharedPreferences = this.getSharedPreferences("Text",MODE_APPEND);
        isFirstRun = sharedPreferences.getBoolean("isFirstRun",true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstRun) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isFirstRun",false);
                    editor.commit();
                    Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent);
                    Toast.makeText(Main2Activity.this,"第一次运行",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Main2Activity.this,"不是第一次运行",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        },3000);


    }
}
