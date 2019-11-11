package com.example.szl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import com.example.szl.SQLiteDB.DBOperation;

public class WelcomeActivity extends AppCompatActivity {

    private DBOperation dbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        dbOperation = new DBOperation(WelcomeActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        },3000);
    }

    private boolean isdone = true;
    public void startMainActivity(){
        if (isdone) {
            isdone = false;
            if(dbOperation.islogin())
            {
                Intent intent = new Intent(WelcomeActivity.this,TestActivity.class);
                startActivity(intent);
                finish();
            }

            else {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMainActivity();
        return super.onTouchEvent(event);
    }
}
