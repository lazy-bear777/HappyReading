package com.example.myapplication.Common;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookSheftFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;
    //
    private List<SBook> bookList = new ArrayList<>();
    private Button begin_read;
    private Button col_book;

    public BookSheftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static BookSheftFragment newInstance(String param1) {
        BookSheftFragment fragment = new BookSheftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SHOW_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sactivity_book, container, false);
        //TextView contentTv = rootView.findViewById(R.id.content_tv);
        //contentTv.setText(mContentText);

        init();
        SBookAdapter adapter = new SBookAdapter(getContext(),R.layout.sitem_layout,bookList);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);   // 把假数据渲染到页面中

       /* begin_read=(Button) rootView.findViewById(R.id.begin_read);
        // 点击事件
        begin_read.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getContext(),"点击了开始阅读按钮",Toast.LENGTH_SHORT).show();
            }
        } );*/

        return rootView;
    }



    //  模拟假数据 (汉字，图片)
    private void init() {
        SBook apple = new SBook("书籍相关介绍", R.drawable.pic00);
        bookList.add(apple);
        SBook banana = new SBook("书籍相关介绍", R.drawable.pic02);
        bookList.add(banana);
        SBook orange = new SBook("书籍相关介绍", R.drawable.pic03);
        bookList.add(orange);
        SBook watermelon = new SBook("书籍相关介绍", R.drawable.pic04);
        bookList.add(watermelon);
        SBook pear = new SBook("书籍相关介绍", R.drawable.pic05);
        bookList.add(pear);
        SBook grape = new SBook("书籍相关介绍", R.drawable.pic01);
        bookList.add(grape);
        SBook pineapple = new SBook("书籍相关介绍", R.drawable.pic20);
        bookList.add(pineapple);

    }

}