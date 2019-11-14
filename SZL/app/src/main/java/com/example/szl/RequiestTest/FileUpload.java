package com.example.szl.RequiestTest;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface FileUpload {

    @POST("fileUpload")
    ResponseRec<String> upload(@Field("userID")int userID,@Field("fileName")String fileName);
}
