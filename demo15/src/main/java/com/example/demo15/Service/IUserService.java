package com.example.demo15.Service;

import com.example.demo15.Common.ServerResponse;
import com.example.demo15.Model.User;

public interface IUserService {

    ServerResponse<User> login(String username,String password);
}
