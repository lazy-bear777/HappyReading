package com.example.demo15.Service.Impl;

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

        User user = userdao.selectUserByUserName(username);
        if(user==null)
        {
            return ServerResponse.createErrorMessage("用户名不存在");
        }
        else {
            if(!user.getPassword().equals(password))
            {
                return ServerResponse.createErrorMessage("密码错误");
            }
        }
        return ServerResponse.createSuccessMessageAndData("登录成功",user);
    }
}
