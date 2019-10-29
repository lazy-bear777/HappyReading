package com.example.demo15;

import com.example.demo15.Model.User;
import com.example.demo15.dao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demo15Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo15Application.class, args);



    }

}
