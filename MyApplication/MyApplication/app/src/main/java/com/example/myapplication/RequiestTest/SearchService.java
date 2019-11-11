package com.example.myapplication.RequiestTest;
import com.example.myapplication.Spider.Bean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SearchService {
        @POST("search")
        @FormUrlEncoded
        Call<ResponseRec<List<Bean>>> getCall(@Field("bookName") String bookName);
}
