package com.carbuybuy.carbuybuy.utils;

import java.util.UUID;

/**
 * 生成用户主键
 */
public class UUIDUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr;
    }


}
