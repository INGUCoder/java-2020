package com.carbuybuy.carbuybuy.redis.service;

import java.util.Set;

public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key,String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超时时间
     */
    boolean expire(String key,long expire);
    /**
     * 删除数据
     */
    void remove(String key);
    /**
     * 自增
     * @param delta 自增
     */
    Long increment(String key,long delta);

    void addSet(String key,String value);

    Set<String> getSet(String key);



}
