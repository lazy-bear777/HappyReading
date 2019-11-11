package com.example.demo15.Controler;

import com.example.demo15.Common.ServerResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
@Controller
public class ServletUpLoad extends HttpServlet {
    @ResponseBody
    @RequestMapping("/upload")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("12345");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        String upload = "D:/aa/image/";
        String temp = System.getProperty("java.io.tmpdir");
        factory.setSizeThreshold(1024 * 1024 * 5);
        factory.setRepository(new File(temp));
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);


        try {
            List<FileItem> list = servletFileUpload.parseRequest((RequestContext) request);
            for (FileItem item : list) {
                String name = item.getFieldName();
                InputStream is = item.getInputStream();

                System.out.println("the current name is " + name);

                if (name.contains("aFile")) {
                    try {
                        inputStream2File(is, upload + "\\" + /*
                         * System.
                         * currentTimeMillis
                         * () +
                         */item.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String key = item.getName();
                    String value = item.getString();
                    System.out.println(key + "---" + value);
                }
            }
            Gson gson = new Gson();
            ServerResponse serverResponse = ServerResponse.createSuccessMessage("上传成功");
            String gsonStr = gson.toJson(serverResponse);
            response.getWriter().print(gsonStr);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }



    private static void inputStream2File(InputStream is, String savePath)
            throws Exception {
        System.out.println("the file path is  :" + savePath);
        File file = new File(savePath);
        InputStream inputSteam = is;
        BufferedInputStream fis = new BufferedInputStream(inputSteam);
        FileOutputStream fos = new FileOutputStream(file);
        int f;
        while ((f = fis.read()) != -1) {
            fos.write(f);
        }
        fos.flush();
        fos.close();
        fis.close();
        inputSteam.close();

    }



}
