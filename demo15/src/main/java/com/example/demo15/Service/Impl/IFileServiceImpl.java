package com.example.demo15.Service.Impl;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.File;
import com.example.demo15.Service.IFileService;
import com.example.demo15.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iFileService")
public class IFileServiceImpl implements IFileService {

    @Autowired
    FileDao fileDao;

    @Override
    public ServerResponse addFile(File file) {
        fileDao.addFileInfo(file);
        return ServerResponse.createSuccessMessage("上传成功");
    }

    @Override
    public ServerResponse<List<File>> getFileByFileName(String fileName) {
        List<File> files = fileDao.selectFileByFileName(fileName);
        return ServerResponse.createSuccessMessageAndData("成功",files);
    }
}
