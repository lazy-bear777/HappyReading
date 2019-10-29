package com.example.demo15.Controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {

    @RequestMapping("/hello")
    public String hello()
    {
        System.out.print("123");
        return "hello11";

    }
}
