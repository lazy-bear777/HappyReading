package com.example.demo15.Controler;

import com.example.demo15.Common.EmailCode;
import com.example.demo15.Model.File;
import com.example.demo15.Model.User;
import com.example.demo15.dao.FileDao;
import com.example.demo15.dao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloTest {
    @Autowired
    Userdao userdao;

    @RequestMapping("/hello")
    public int hello()
    {
        /*System.out.print("123");
        File file=new File();
        file.setUserID(1241231);
        file.setFileName("小说");
        Date date = new Date();
        file.setUpTime(new java.sql.Date(date.getTime()));
        file.setFileInfo("dasfqfaffafgasgda");
        file.setURL("D://afafafw");*/
        //fileDao.addFileInfo(file);
        //fileDao.updateFileNameByFileNum(1,"jinpingmei");
        //fileDao.updateDownloadsByFileNum(1);
        EmailCode emailCode =new EmailCode();
        User user=new User();
        user.setUserPhone("123");
        user.setPassword("123");
        user.setUserEmail("123");
        user.setUserName("123");


        return userdao.addUser(user);

    }
}
