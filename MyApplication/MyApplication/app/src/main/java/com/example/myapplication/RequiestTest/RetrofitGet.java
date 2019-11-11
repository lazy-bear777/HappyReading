package com.example.myapplication.RequiestTest;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGet {

    public static Retrofit getRetrofit()
    {
        final OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS).build();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://10.26.18.41:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit;

    }
}
