package com.example.myapplication.Spider;

public class Bean {
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public Bean(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
