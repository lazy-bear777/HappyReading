package com.example.demo15.dao;

import com.example.demo15.Model.UserFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//用户文件库的dao层
@Mapper
public interface UserFilterDao {

    public int createUserFilter(@Param("tableName") String tableName);//创建一个用户文件库 无主键 表名为file+用户ID

    public int addUserFile(@Param("userFilter") UserFilter userFilter);//添加一个用户文件信息

    public int deleteUserFile(@Param("fileNum") int fileNum);//删除用户文件信息

    public UserFilter selectUserFilter(@Param("fileNum") int fileNum);//查询一个文件信息

    public List<UserFilter> selectAll(@Param("tableName") String tableName); //查询一个用户文件库中的所有文件信息
}
