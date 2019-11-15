package com.example.community;

public class BooksDisplay {
    private  int bookPicPath;
    private  String bookName;
    private  String bookIntroduction;

    public BooksDisplay(int bookPicPath,String bookName,String bookIntroduction ){
        this.bookPicPath=bookPicPath;
        this.bookName=bookName;
        this.bookIntroduction=bookIntroduction;
    }
    public int getBookPicPath() {
        return bookPicPath;
    }
    public void setUserPicPath(int userPicPath) {
        this.bookPicPath = bookPicPath;
    }

    public  String getBookName(){
        return bookName;
    }
    public  void setBookName(String bookName){
        this.bookName=bookName;
    }

    public  String getBookIntroduction(){
        return bookIntroduction;
    }
    public void setBookIntroduction(String bookIntroduction){
        this.bookIntroduction=bookIntroduction;
    }
}
