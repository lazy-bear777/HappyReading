package com.example.demo15.Service;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.BookBean;
import com.example.demo15.Model.File;

import java.util.List;

public interface IFileService {



    public ServerResponse<List<BookBean>> search(String fileName);
}
