package com.example.demo15.Model;

public class BookBean {
    private String fileName;
    private int fileNum;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "fileName='" + fileName + '\'' +
                ", fileNum=" + fileNum +
                '}';
    }
}
