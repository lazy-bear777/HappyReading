package com.example.demo15.dao;

import com.example.demo15.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Userdao {

//    添加新用户
    public int addUser(@Param("user") User user);

//    查询所有用户
    public List<User> selectUsers();

//    通过用户名查询用户
    public User selectUserByUserName(@Param("name") String name);

//    通过用户ID查询用户
    public User selectUserByUserID(@Param("userID") int userID);



//    通过邮箱查询用户
    public User selectUserByEmail(@Param("email") String email);


//    通过用户ID删除用户
    public int deleteUserByUserID(@Param("userID") int userID);

//    通过用户ID修改用户密码
    public int updatePasswordByUserID(@Param("userID") int userID,@Param("newPassword") String newPassword);

//    通过用户ID修改用户信息

    public int updateUserInfoByUserID(@Param("userID") int userID,@Param("newUserInfo") User newUserInfo);
}
