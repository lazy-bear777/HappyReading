package com.example.demo15.Controler;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.BookBean;
import com.example.demo15.Service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class fileDownLoad {

    @Autowired
    IFileService iFileService;

    @RequestMapping("/search")
    @ResponseBody
    public ServerResponse<List<BookBean>> search(String fileName)
    {
        return iFileService.search(fileName);
    }
}
