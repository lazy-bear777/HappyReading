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

public class User_DetailsActivity extends AppCompatActivity {
    boolean flag=true;//为点击关注而设置
    private List<UserNews> userNewsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__details);

        initUserNew();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserNewsAdapter adapter=new UserNewsAdapter(userNewsList);
        recyclerView.setAdapter(adapter);
        //点击详情界面中的返回图标，返回到动态界面
        ImageView details_back=findViewById(R.id.details_back);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_DetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //点击关注/取消关注
        final TextView  textView=(TextView) findViewById(R.id.text1);
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
        //点击"书籍"跳转到书籍页面
        TextView  txt2=findViewById(R.id.txt2);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_DetailsActivity.this,BooksActivity.class);
                startActivity(intent);
            }
        });
        //点击"其他"跳转到"其他"界面

    }
    private void initUserNew(){
        UserNews userNews1 = new UserNews(R.drawable.user1, "你好",R.drawable.focus,"一定要努力啊不试一试，怎么知道会不会成功呢不试一试，怎么知道会不会成功呢", "2019-10-10", "地址", R.drawable.background, R.drawable.forward,R.string.forward, R.drawable.comment, R.string.comment, R.drawable.thumbup, R.string.thubmup);
        userNewsList.add(userNews1);
        UserNews userNews2 = new UserNews(R.drawable.user1, "你好", R.drawable.focus,"一定要努力啊不试一试，怎么知道会不会成功呢不试一试，怎么知道会不会成功呢", "2019-10-10", "地址", R.drawable.img_2, R.drawable.forward, R.string.forward, R.drawable.comment, R.string.comment, R.drawable.thumbup, R.string.thubmup);
        userNewsList.add(userNews2);
    }
}
