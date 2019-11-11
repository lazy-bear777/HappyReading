package com.example.demo15.Common;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmailCode {
    public static String achieveCode() {
        String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(3, 9);
        //System.out.print(result);
        return result;
    }

    public static String sendEamilCode(String email) {
        HtmlEmail send = new HtmlEmail();
        // 获取随机验证码
        String resultCode = achieveCode();
        try {
            send.setHostName("smtp.qq.com");
            send.setSmtpPort(465); //端口号
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email); //接收者的QQEamil
            send.setFrom("3097225061@qq.com", "悦读APP");  //第一个参数是发送者的QQEamil   第二个参数是发送者QQ昵称
            send.setAuthentication("3097225061@qq.com", "ufewawtmyszrdfaf"); //第一个参数是发送者的QQEamil   第二个参数是刚刚获取的授权码
            send.setSubject("悦读APP注册码");//Eamil的标题
            send.setMsg("欢迎注册悦读APP，特此送上验证:   " + resultCode + "   请您签收！");  //Eamil的内容
            send.send(); //发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return resultCode;
    }

}
