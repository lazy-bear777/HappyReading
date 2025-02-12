package com.example.myapplication.textreader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;


import com.example.myapplication.R;
import com.example.myapplication.textreader.model.MyPage;
import com.example.myapplication.textreader.utils.CharsetDetector;
import com.example.myapplication.textreader.view.FlipperLayout;
import com.example.myapplication.textreader.view.ReadView;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Reader extends Activity implements OnClickListener, FlipperLayout.TouchListener {

    private static final int MSG_DRAW_TEXT = 1;
    CharBuffer buffer = CharBuffer.allocate(8000);
    boolean oneIsLayout;
    String filePath;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_DRAW_TEXT:

                    FlipperLayout rootLayout = (FlipperLayout) findViewById(R.id.container);

                    View recoverView = LayoutInflater.from(Reader.this).inflate(R.layout.view_new, null);
                    View view1 = LayoutInflater.from(Reader.this).inflate(R.layout.view_new, null);
                    View view2 = LayoutInflater.from(Reader.this).inflate(R.layout.view_new, null);

                    rootLayout.initFlipperViews(Reader.this, view2, view1, recoverView);

                    final ReadView readView1 = (ReadView) view1.findViewById(R.id.textview);
                    final ReadView readView2 = (ReadView) view2.findViewById(R.id.textview);

                    buffer.position(0);

                    //填充第一页的文本
                    readView1.setText(buffer);

                    //填充第二页的文本
                    ViewTreeObserver vto1 = readView1.getViewTreeObserver();
                    vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (oneIsLayout)
                                return;

                            int charNum = readView1.getCharNum();


                            MyPage page = new MyPage();
                            page.setPageSize(charNum);
                            page.setStartPosition(charNum);
                            page.setId(1);

                            //将第一页的数据存储在数据库中，如果该数据不存在
                            if (isSavePage(1)) {
                                page.update(1);
                            } else {
                                page.save();
                            }

                            buffer.position(charNum);
                            readView2.setText(buffer);

                            oneIsLayout = true;
                        }
                    });


                    ViewTreeObserver vto2 = readView2.getViewTreeObserver();
                    vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            int charNum = readView2.getCharNum();
                            if (charNum == 0)
                                return;

                            //将第二页的数据存储在数据库中, 如果该数据不存在
                            MyPage page = new MyPage();
                            page.setPageSize(charNum);
                            page.setStartPosition(charNum + getStartPosition(1));
                            page.setId(2);

                            if (isSavePage(2)) {
                                page.update(2);
                            } else {
                                page.save();
                            }
                        }
                    });
                    break;
            }
        }
    };


    //该页是否存储
    private boolean isSavePage(int pageNo) {
        return DataSupport.find(MyPage.class, pageNo) != null;
    }

    //获取该页的结束位置
    private int getStartPosition(int pageNo) {
        if (pageNo < 1) {
            return 0;
        }

        if (isSavePage(pageNo)) {
            return DataSupport.find(MyPage.class, pageNo).getStartPosition();
        }
        return 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePalApplication.initialize(this);
        setContentView(R.layout.activity_main);
        try {
            Bundle bunde = this.getIntent().getExtras();
            filePath = bunde.getString("fileName");
            System.out.println("--------------------------------------filePath = " +filePath);

            //refreshGUI(defaultCode);
            new ReadingThread().start();
        } catch (Exception e) {
        }

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public View createView(final int direction, final int index) {
        View newView;
        if (direction == FlipperLayout.TouchListener.MOVE_TO_LEFT) { //下一页
            buffer.position(getStartPosition(index));

            newView = LayoutInflater.from(this).inflate(R.layout.view_new, null);
            final ReadView readView = (ReadView) newView.findViewById(R.id.textview);
            readView.setText(buffer);

            ViewTreeObserver vto2 = readView.getViewTreeObserver();
            vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int charNm = readView.getCharNum();

                    MyPage page = new MyPage();
                    page.setPageSize(charNm);

                    page.setStartPosition(getStartPosition(index) + charNm);
                    page.setBookId(index + 1);
                    page.setId(index + 1);

                    if (isSavePage(index + 1)) {
                        page.update(index + 1);
                    } else {
                        page.save();
                    }
                }
            });
        } else {
            buffer.position(getStartPosition(index-2));
            newView = LayoutInflater.from(this).inflate(R.layout.view_new, null);
            final ReadView readView = (ReadView) newView.findViewById(R.id.textview);
            readView.setText(buffer);
        }

        return newView;
    }

    @Override
    public boolean whetherHasNextPage() {
        return true;
    }

    @Override
    public boolean currentIsLastPage() {
        return true;
    }

    private class ReadingThread extends Thread {
        public void run() {
            BufferedReader reader = null;
            InputStream in = null;
            //AssetManager assets = getAssets();
            try {
                //in = assets.open("text.txt");
                in = new FileInputStream(filePath);
                Charset charset = CharsetDetector.detect(in);
                reader = new BufferedReader(new InputStreamReader(in,charset));
                reader.read(buffer);

                mHandler.obtainMessage(MSG_DRAW_TEXT).sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
