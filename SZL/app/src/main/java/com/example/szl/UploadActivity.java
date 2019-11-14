package com.example.szl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.szl.ServiceAPI.FileFunc;

import retrofit2.http.Body;

public class UploadActivity extends AppCompatActivity {

    private TextView tv_path;
    private EditText et_fileName;
    private Button bt_choose;
    private Button bt_send;
    private String filePath;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        tv_path = (TextView) findViewById(R.id.et_path);
        et_fileName = (EditText) findViewById(R.id.et_filename);
        bt_choose = (Button) findViewById(R.id.bt_choose);
        bt_send = (Button) findViewById(R.id.bt_send);
        bt_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1000);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            assert data != null;
            Uri uri = data.getData();
            assert uri != null;
            filePath = FileFunc.getPath(this, uri);
            //获取文件名
            fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());


            tv_path.setText(filePath);
            et_fileName.setText(fileName);

        }
    }
}
