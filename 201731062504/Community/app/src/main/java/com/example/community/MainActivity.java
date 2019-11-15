package com.example.community;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<UserNews> userNewsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUserNew();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserNewsAdapter adapter=new UserNewsAdapter(userNewsList);
        recyclerView.setAdapter(adapter);
    }
    private void initUserNew(){
        UserNews userNews1 = new UserNews(R.drawable.user1, "你好",R.drawable.focus,"一定要努力啊不试一试，怎么知道会不会成功呢不试一试，怎么知道会不会成功呢", "2019-10-10", "地址", R.drawable.background, R.drawable.forward, R.string.forward, R.drawable.comment, R.string.comment, R.drawable.thumbup, R.string.thubmup);
        userNewsList.add(userNews1);
        UserNews userNews2 = new UserNews(R.drawable.user1, "你好", R.drawable.focus,"一定要努力啊不试一试，怎么知道会不会成功呢不试一试，怎么知道会不会成功呢", "2019-10-10", "地址", R.drawable.img_2, R.drawable.forward, R.string.forward, R.drawable.comment, R.string.comment, R.drawable.thumbup, R.string.thubmup);
        userNewsList.add(userNews2);
    }
}
