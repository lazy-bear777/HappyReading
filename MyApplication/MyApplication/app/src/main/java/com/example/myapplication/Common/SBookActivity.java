package com.example.myapplication.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.Spider.Introduction;
import com.leon.lib.settingview.LSettingItem;

import java.util.ArrayList;
import java.util.List;

public class SBookActivity extends AppCompatActivity {
    private List<Introduction> bookList = new ArrayList<>();
    private Button begin_read;
    private Button col_book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity_book);


        init();
        BookAdapter adapter = new BookAdapter(SBookActivity.this,R.layout.sitem_layout,bookList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);   // 把假数据渲染到页面中


          // 点击事件
       begin_read.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               Toast.makeText(SBookActivity.this,"点击了开始阅读按钮",Toast.LENGTH_SHORT).show();
           }
       } );


    }
    //  模拟假数据 (汉字，图片)
    private void init() {
        /*
        Book apple = new Book("书籍相关介绍", R.drawable.pic00);
        bookList.add(apple);
        Book banana = new Book("书籍相关介绍", R.drawable.pic02);
        bookList.add(banana);
        Book orange = new Book("书籍相关介绍", R.drawable.pic03);
        bookList.add(orange);
        Book watermelon = new Book("书籍相关介绍", R.drawable.pic04);
        bookList.add(watermelon);
        Book pear = new Book("书籍相关介绍", R.drawable.pic05);
        bookList.add(pear);
        Book grape = new Book("书籍相关介绍", R.drawable.pic01);
        bookList.add(grape);
        Book pineapple = new Book("书籍相关介绍", R.drawable.pic20);
        bookList.add(pineapple);*/

    }
}
