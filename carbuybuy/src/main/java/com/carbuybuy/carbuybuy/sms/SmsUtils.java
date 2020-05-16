package com.carbuybuy.carbuybuy.sms;
import com.carbuybuy.carbuybuy.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SmsUtils {

    public static String sendSms(String phone) {

        String host = "http://codesms.market.alicloudapi.com";
        String path = "/sms/send/template/code/70";
        String method = "POST";
        String appcode = "1a82b5e79af14233a965268e5e21dcb9";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);

        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<4;i++){
            str.append(random.nextInt(10));
        }
        String smsCode = str.toString();

        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【摩字】您的验证码为"+smsCode+"，您正在进行API调试，请于10分钟内完成验证，如非本人操作，请忽略此短信。");
        querys.put("mobile", phone);
        Map<String, String> bodys = new HashMap<String, String>();


        try {
           // HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode;
    }


    public static void main(String[] args){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<4;i++){
            str.append(random.nextInt(10));
        }
        System.out.println(str);
    }

}
