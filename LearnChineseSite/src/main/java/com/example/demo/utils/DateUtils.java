package com.example.demo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//时间工具
public class DateUtils {

    //将当前日期转成  yyyy-MM-dd 形式
    public static String getDateForYMD(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date.getTime());
        return time;
    }

    //将数据库时间转成  yyyy-MM-dd 形式
    public static String getDateForYMD2(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date.getTime());
        return time;
    }

}
