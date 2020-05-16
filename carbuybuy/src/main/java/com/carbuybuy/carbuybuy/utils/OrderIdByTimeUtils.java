package com.carbuybuy.carbuybuy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//根据日期生成不重复的订单号
public class OrderIdByTimeUtils {
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

}
