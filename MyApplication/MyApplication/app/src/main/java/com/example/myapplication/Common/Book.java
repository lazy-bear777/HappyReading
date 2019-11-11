package com.example.myapplication.Common;

public class Book {
    private String bookName;
    private String bookThur;
    //private int imageId;
    public Book(String bookName,String bookThur){
        this.bookName=bookName;
        this.bookThur=bookThur;
        //this.imageId=imageId;
    }
    public String getBookName()
    {
        return bookName;
    }
    public String getBookThur()
    {
        return bookThur;
    }

    /*public int getImageId(int imageId) {
        return imageId;
    }*/
}