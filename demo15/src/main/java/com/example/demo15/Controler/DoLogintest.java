package com.example.demo15.Controler;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.User;
import com.example.demo15.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DoLogintest {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public ServerResponse<User> login(String username, String pswd)
    {
       // ServerResponse<User> response = iUserService.login(username,pswd);
        return iUserService.login(username,pswd);
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ServerResponse<String> checkEmail(String email)
    {
        return iUserService.checkEmail(email);
    }

    @RequestMapping("/register")
    @ResponseBody
    public ServerResponse<User> doRegister(String userName,String password,String email,String telephone)
    {
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserEmail(email);
        user.setUserPhone(telephone);
        return iUserService.register(user);
    }
}
