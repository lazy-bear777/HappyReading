package com.example.myapplication.Spider;

public class Chapter {
    private String name;
    private String Content;

    public Chapter(String name, String content) {
        this.name = name;
        Content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
