package com.example.demo15.Model;

public class UserFilter {

    private int userID;
    private int fileNum;
    private String URL;

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "UserFilter{" +
                "userID=" + userID +
                ", fileNum=" + fileNum +
                ", URL='" + URL + '\'' +
                '}';
    }
}
