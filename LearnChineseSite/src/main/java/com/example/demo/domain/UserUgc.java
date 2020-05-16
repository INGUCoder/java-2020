package com.example.demo.domain;

import java.util.Date;

public class UserUgc {
    private String id;

    private String title;

    private String userId;

    private String neirong;

    private Integer userLimit;

    private Date pushTime;

    public UserUgc(String id, String title, String userId, String neirong, Integer userLimit, Date pushTime) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.neirong = neirong;
        this.userLimit = userLimit;
        this.pushTime = pushTime;
    }

    public UserUgc() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}