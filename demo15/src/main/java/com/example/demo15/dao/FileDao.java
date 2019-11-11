package com.example.demo15.dao;

import com.example.demo15.Model.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileDao {
    public int addFileInfo(@Param("file") File file); //添加一个文件

    public int deleteFileByFileNum(@Param("fileNum") int fileNum);//通过文件编号删除文件

    public int updateFileNameByFileNum(@Param("fileNum") int fileNum,@Param("newName") String newName);//通过文件编号修改文件名

    public int updateDownloadsByFileNum(@Param("fileNum") int fileNum);//更新下载次数

    public int updateFileInfoByFileNum(@Param("fielNum") int fileNum,@Param("newFileInfo") String newFileInfo);//修改文件信息

    public File selectFileByFileNum(@Param("fileNum") int fileNum);

    public List<File> selectFileByUserID(@Param("userID")int userID);

    //通过文件名查找所有文件
    public List<File> selectFileByFileName(@Param("fileName")String fileName);

    public List<File> selectAllFile();
}
