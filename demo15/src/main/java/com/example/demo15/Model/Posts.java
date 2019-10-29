package com.example.demo15.Model;

import java.sql.Date;

//用户帖子实体类
public class Posts {

    private int PostNum;    //帖子编号
    private int UserID;     //用户ID
    private String UserName;   //用户名
    private Date upTime;    //上传时间
    private String Content; //帖子内容

    public int getPostNum() {
        return PostNum;
    }

    public void setPostNum(int postNum) {
        PostNum = postNum;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "PostNum=" + PostNum +
                ", UserID=" + UserID +
                ", UserName=" + UserName +
                ", upTime=" + upTime +
                ", Content='" + Content + '\'' +
                '}';
    }
}
