package com.example.myapplication.Common;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Spider.BookSearch;
import com.example.myapplication.Spider.Introduction;
import com.example.myapplication.Spider.IntroductionBuilder;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntroductionActivity extends AppCompatActivity {
    TextView nameView;
    TextView authorView;
    TextView neweastCapterView;
    TextView introView;
    Button startButton;
    String faceUrl;
    Introduction introduction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduce1);
        startButton = (Button)findViewById(R.id.start_read);
        nameView = (TextView)findViewById(R.id.intro_book_name);
        authorView = (TextView)findViewById(R.id.intro_author);
        neweastCapterView = (TextView)findViewById(R.id.Intro_newestCapter);
        introView = (TextView)findViewById(R.id.intro_intro);
        faceUrl = getIntent().getStringExtra("faceUrl");
        MyTask myTask = new MyTask();
        myTask.execute();
    }
    class MyTask extends AsyncTask<String ,Integer, List<Introduction>> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(List<Introduction> introductions) {
            //BookAdapter adapter =new BookAdapter(Result2Activity.this,R.layout.book3_list,bookList);
            /*- PreviewAdapter adapter =new PreviewAdapter(Result2Activity.this,R.layout.book3_list,previewList);
            listView1.setAdapter(adapter);-*/
            nameView.setText(introduction.getName());
            authorView.setText(introduction.getAuthor());
            neweastCapterView.setText(introduction.getNewest());
            introView.setText(introduction.getIntroduction());
            introView.requestLayout();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected List<Introduction> doInBackground(String... strings) {
            introduction = new IntroductionBuilder().getIntroduction(BookSearch.getMainUrl(),faceUrl);
            return null;
        }
    }
}
