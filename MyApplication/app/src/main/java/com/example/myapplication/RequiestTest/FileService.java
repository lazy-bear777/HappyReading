package com.example.myapplication.RequiestTest;

import com.example.myapplication.Spider.BookBean;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface FileService {
    @POST("uploadBook")
    Call<ResponseRec> upload(@Body RequestBody body);
}
