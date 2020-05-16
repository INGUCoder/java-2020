package com.carbuybuy.carbuybuy.entity;

import java.util.Date;
//最后一次登陆记录
public class UsersLoginRecords {
    //id
    private Integer id;

    //ip地址
    private String ip;

    //用户id
    private String userId;

    //最后一次登陆时间
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UsersLoginRecords{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", userId='" + userId + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
