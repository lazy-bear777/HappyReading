package com.example.demo15.Controler;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.User;
import com.example.demo15.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoLogintest {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public ServerResponse<User> login(String username, String pswd)
    {
        ServerResponse<User> response = iUserService.login(username,pswd);
        return response;
    }
}
