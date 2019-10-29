package com.example.demo15.dao;

import com.example.demo15.Model.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostsDao {

    public int createPostTable(@Param("tableName") String tableName);//创建一个用户帖子表 命名方式：post+用户ID postNum为主键 自增 都不能为空

    public int addPost(@Param("posts") Posts posts); //添加一个帖子

    public int deletePostByPostNum(@Param("postNum") int postNum);//删除帖子

    public int updateContent(@Param("postNum") int postNum,@Param("newContent") String newContent);//修改帖子内容

    public Posts selectPost(@Param("postNum") int postNum); //查询帖子信息

    public List<Posts> selectAllPosts(@Param("tableName") String tableName);//查询所有帖子


}
