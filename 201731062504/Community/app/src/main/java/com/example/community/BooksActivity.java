package com.example.community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {
    boolean flag=true;//为点击关注而设置
    private List<BooksDisplay> booksDisplayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        initBooks();
        RecyclerView recyclerView=findViewById(R.id.book_recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BookDisplayAdapter adapter=new BookDisplayAdapter(booksDisplayList);
        recyclerView.setAdapter(adapter);

        //点击详情界面中的返回图标，返回到动态界面
        ImageView details_back=findViewById(R.id.details_back);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BooksActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //点击关注/取消关注
        final TextView textView=(TextView) findViewById(R.id.text1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==true){
                    textView.setText("已关注");
                    flag=false;
                }
                else{
                    textView.setText("加关注");
                    flag=true;
                }
            }
        });
        //点击"动态"跳转到动态界面
        TextView txt1=findViewById(R.id.book_txt1);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BooksActivity.this,User_DetailsActivity.class);
                startActivity(intent);
            }
        });
        //点击"其他"跳转到其他界面
    }
    public  void initBooks(){
        for(int i=0;i<3;i++) {
            BooksDisplay book1 = new BooksDisplay(R.drawable.book1, "名人传", "名人传名人传名人传名人传");
            booksDisplayList.add(book1);
            BooksDisplay book2 = new BooksDisplay(R.drawable.book2, "名人传", "名人传名人传名人传名人传");
            booksDisplayList.add(book2);
        }
    }
}
