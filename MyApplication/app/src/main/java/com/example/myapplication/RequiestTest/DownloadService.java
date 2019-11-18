package com.example.myapplication.RequiestTest;

import com.example.myapplication.Spider.BookBean;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface DownloadService {
    @POST("downloadBook")
    Call<ResponseBody> download(@Body BookBean bookBean);
}
