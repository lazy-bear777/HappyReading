package com.example.szl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.szl.SQLiteDB.DBOperation;

public class TestActivity extends AppCompatActivity {

    private Button bt;
    private DBOperation dbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        bt = (Button) findViewById(R.id.button);
        dbOperation = new DBOperation(TestActivity.this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });
    }
}
