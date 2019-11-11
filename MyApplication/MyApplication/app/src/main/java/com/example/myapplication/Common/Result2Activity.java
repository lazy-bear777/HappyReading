package com.example.myapplication.Common;

import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.myapplication.R;
import com.example.myapplication.RequiestTest.ResponseRec;
import com.example.myapplication.RequiestTest.RetrofitGet;
import com.example.myapplication.RequiestTest.SearchService;
import com.example.myapplication.Spider.Bean;
import com.example.myapplication.Spider.BookSearch;
import com.example.myapplication.Spider.Introduction;
import com.google.gson.Gson;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Result2Activity extends AppCompatActivity {
    private List<Introduction> previewList=new ArrayList<>();
    private List<Bean> soureList=new ArrayList<>();
    private String bookName;
    //private List<Book> bookList=new ArrayList<>();
    ListView listView1;
    ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result2b);
        //获得搜索的文件名
        bookName = getIntent().getBundleExtra("bookName").get("bookName").toString();
        listView1 =(ListView) findViewById(R.id.previewlistid);
        listView2 =(ListView) findViewById(R.id.soureListid);

        new MyTask().execute();
        initSoure();
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Introduction book=previewList.get(position);
                //Toast.makeText(ResultActivity.this,book.getName(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Result2Activity.this,IntroductionActivity.class);
                intent.putExtra("faceUrl",book.getFaceUrl());
                startActivity(intent);
            }
        });
        ImageButton gopython =(ImageButton)findViewById(R.id.gopythona);
        EditText mypreview=(EditText) findViewById(R.id.mypreview);
       ImageButton back_button=(ImageButton)findViewById(R.id.backbutton);

       //文本框上移代码
        View decorView = getWindow().getDecorView();
        View contentView = findViewById(Window.ID_ANDROID_CONTENT);
 decorView.getViewTreeObserver().addOnGlobalLayoutListener(getGlobalLayoutListener(decorView, contentView));

        //返回
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //初始化网络资源，priview不再是评论，而是网络资源
    private void initPreview(){
        previewList = BookSearch.serachBook(bookName);
    }
    //初始化服务器本地资源
    private void initSoure(){
        System.out.println("本地查找！*****************");
        soureList.clear();
        searchBaseBook(bookName);
    }
    //文本框上移代码

    private ViewTreeObserver.OnGlobalLayoutListener getGlobalLayoutListener(final View decorView, final View contentView) {
        return new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                decorView.getWindowVisibleDisplayFrame(r);

                int height = decorView.getContext().getResources().getDisplayMetrics().heightPixels;
                int diff = height - r.bottom;

                if (diff != 0) {
                    if (contentView.getPaddingBottom() != diff) {
                        contentView.setPadding(0, 0, 0, diff);
                    }
                } else {
                    if (contentView.getPaddingBottom() != 0) {
                        contentView.setPadding(0, 0, 0, 0);
                    }
                }
            }
        };
    }
    //线程内部类，用于在子线程中更新主线程中的View资源
    class MyTask extends AsyncTask<String ,Integer,List<Introduction>> {
        @Override
        protected void onPostExecute(List<Introduction> introductions) {
            PreviewAdapter adapter =new PreviewAdapter(Result2Activity.this,R.layout.book3_list,previewList);
            listView1.setAdapter(adapter);
        }
        @Override
        protected List<Introduction> doInBackground(String... strings) {
            initPreview();
            return null;
        }
    }

    private  void searchBaseBook(String bookName)
    {
        Retrofit retrofit= RetrofitGet.getRetrofit();
        SearchService searchService = retrofit.create(SearchService.class);
        Call<ResponseRec<List<Bean>>> call = searchService.getCall(bookName);
        final List<Bean> list = new ArrayList<>();
        call.enqueue(new Callback<ResponseRec<List<Bean>>>() {
            @Override
            public void onResponse(Call<ResponseRec<List<Bean>>> call, Response<ResponseRec<List<Bean>>> response) {

                ResponseRec<List<Bean>> responseRec= response.body();
                list.addAll(responseRec.getData());
                System.out.println("信息："+responseRec.getMsg()+"  "+responseRec.getStatus());//登陆成功的信息
                soureList.clear();
                soureList.addAll(list);
                System.out.println("内容大小："+soureList.size());
                SoureAdapter adapter1 =new SoureAdapter(Result2Activity.this,R.layout.source_list,soureList);
                listView2.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<ResponseRec<List<Bean>>> call, Throwable t) {
                System.out.println("访问失败"+t.toString()+call.request().toString());

            }
        });
    }
}
