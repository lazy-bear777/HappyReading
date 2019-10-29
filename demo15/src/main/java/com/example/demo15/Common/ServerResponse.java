package com.example.demo15.Common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {

    int status;
    String msg;
    T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ServerResponse<T> createSuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createSuccessData(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createSuccessMessageAndData(String message,T data)
    {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message,data);
    }

    public static <T> ServerResponse<T> createError()
    {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createErrorMessage(String message)
    {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),message);
    }

    public static <T> ServerResponse<T> createErrorCodeAndMsg(int errorCode,String errorMsg)
    {
        return new ServerResponse<T>(errorCode,errorMsg);
    }




    @Override
    public String toString() {
        return "ResponseServer{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
