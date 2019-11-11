package com.example.demo15.Service.Impl;

import com.example.demo15.Common.EmailCode;
import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.User;
import com.example.demo15.Service.IUserService;
import com.example.demo15.dao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private Userdao userdao;
    @Override
    public ServerResponse<User> login(String username, String password) {

        User user = userdao.selectUserByEmail(username);
        if(user==null)
        {
            return ServerResponse.createErrorMessage("该用户不存在");
        }
        else {
            if(!user.getPassword().equals(password))
            {
                return ServerResponse.createErrorMessage("密码错误");
            }
        }
        return ServerResponse.createSuccessMessageAndData("登录成功",user);
    }

    @Override
    public ServerResponse<User> register(User user) {
        System.out.println(user.toString());

        if(userdao.selectUserByEmail(user.getUserEmail())!=null)
        {
            return ServerResponse.createErrorMessage("邮箱已被注册");
        }
        userdao.addUser(user);
        return ServerResponse.createSuccessMessageAndData("注册成功",userdao.selectUserByEmail(user.getUserEmail()));

    }

    @Override
    public ServerResponse<String> checkEmail(String email) {
        User user=userdao.selectUserByEmail(email);
        if(user!=null)
            return ServerResponse.createErrorMessage("邮箱已被注册能注册");

        return ServerResponse.createSuccessMessageAndData("验证码已发送！", EmailCode.sendEamilCode(email));

    }
}
