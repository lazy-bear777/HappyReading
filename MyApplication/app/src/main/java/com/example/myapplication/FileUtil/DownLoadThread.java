package com.example.myapplication.FileUtil;

import android.util.Log;

import com.example.myapplication.RequiestTest.FileService;
import com.example.myapplication.RequiestTest.ResponseRec;
import com.example.myapplication.RequiestTest.RetrofitGet;
import com.example.myapplication.Spider.BookBean;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.litepal.LitePalBase.TAG;

public class DownLoadThread extends Thread {
    DownLoadThread(){
    }
    private BookBean bookBean;

    @Override
    public void run() {
       /* try {
            URL url = new URL(downLoadUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            // 允许Input、Output，不使用Cache
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setConnectTimeout(50000);
            con.setReadTimeout(50000);
            // 设置传送的method
            con.setRequestMethod("POST");
            //在一次TCP连接中可以持续发送多份数据而不会断开连接
            con.setRequestProperty("Connection", "Keep-Alive");
            //设置编码
            con.setRequestProperty("Charset", "UTF-8");
            //设置下载文件的编码格式
            con.setRequestProperty("Content-Type", "application/octet-stream");
            //设置请求的文件名
            con.setRequestProperty("path", URLEncoder.encode(path,"utf-8"));

            File dir = new File(dirPath+"/books/");
            if(!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(dir.getAbsolutePath(), bookBean.getName());
            System.out.println(file.getAbsoluteFile());
            try {
                if(!file.createNewFile()) {
                    System.out.println("File already exists");
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
            // 设置文件输入流
            DataInputStream inputStream = new DataInputStream(con.getInputStream());
            // 获得文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 设置每次写入1024bytes
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            int length = -1;
            // 从文件读取数据至缓冲区
            while ((length = inputStream.read(buffer)) != -1) {
                // 将资料写入文件中
                fileOutputStream.write(buffer, 0, length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}
