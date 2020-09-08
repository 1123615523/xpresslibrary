package com.aaa.frontcontroller;

import com.aaa.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("code")
public class codeController {

    @Resource
    CustomerService customerService;

    @RequestMapping("phonecode")
    public Object cyh(String phone){

        Integer res = customerService.findCustomerByPhone(phone);
        if(res == 1){
            return 1;
        }
        String testUsername = "hui_ai";
        String testPassword = "hui970511";
        String testPhone = phone;
        String str = "1234567890";
        String code = "";
        for(int i= 0;i<6;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }

        String testContent = "【随心文库】您的验证码是"+code+",５分钟内有效。若非本人操作请忽略此消息。";
        String httpUrl = "http://api.smsbao.com/sms";
        StringBuffer httpArg = new StringBuffer();
        httpArg.append("u=").append(testUsername).append("&");
        httpArg.append("p=").append(md5(testPassword)).append("&");
        httpArg.append("m=").append(testPhone).append("&");
        httpArg.append("c=").append(encodeUrlString(testContent, "UTF-8"));
        String result = request(httpUrl, httpArg.toString());
        System.out.println(result);
        return code;
    }

    public String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public  String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;}
                if (i < 16){
                    buf.append("0");}
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public  String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null){
            return str;}
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }

}
