package com.example.myapplication.RequiestTest;
import com.example.myapplication.Spider.BookBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SearchService {
        @GET("search")
        Call<ResponseRec<List<BookBean>>> getCall(@Query("fileName") String bookName);
}
