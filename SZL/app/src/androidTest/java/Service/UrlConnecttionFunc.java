package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnecttionFunc {

    //连接服务器，并写入参数
    public static HttpURLConnection doPost(String data,String urlAddr) throws MalformedURLException {
        URL url = new URL(urlAddr);
        HttpURLConnection httpURLConnection=null;
        try {
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");//设置传递方法
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true); //可接收参数
            httpURLConnection.setDoOutput(true); //可写入参数
            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");//设置传递类型 键值对
            httpURLConnection.setRequestProperty("Content-Length",data.length()+" ");
            OutputStream outputStream = httpURLConnection.getOutputStream(); //输出流6
            outputStream.write(data.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpURLConnection;
    }

    public static String ChangeToString(InputStream inputStream) throws IOException {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String temp=null;
        while ((temp=bufferedReader.readLine())!=null)
        {
            buffer.append(temp);
        }
        bufferedReader.close();
        inputStream.close();
        return buffer.toString();
    }
}
