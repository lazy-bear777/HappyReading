package com.example.demo15.Controler;

import com.example.demo15.Common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class UploadTest {

    @ResponseBody
    @RequestMapping("/uploadTest")
    public ServerResponse<String> uploadtest(@RequestParam("mutipartFile")MultipartFile file)
    {

        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            System.out.println("Load fn:" + filename);
            //System.out.println("Load uploadfile:" + fname);
            try {

                String fileurl = "D:\\/" + filename;
                File f = new File(fileurl);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
                if (!f.exists()) {
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                out.write(file.getBytes());
                out.flush();
                out.close();
                return ServerResponse.createSuccessMessage("上传成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("上传失败，因为文件是空的.");
            return ServerResponse.createSuccessMessage("失败");

        }
        return ServerResponse.createSuccessMessage("成功");

    }

}
