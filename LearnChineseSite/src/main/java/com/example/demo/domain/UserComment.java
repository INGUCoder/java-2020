package com.example.demo.domain;

import java.util.Date;

public class UserComment {
    private String id;

    private String userName;

    private String userId;

    private String neirong;

    private Integer commentStatus;

    private Date pushTime;

    public UserComment(String id, String userName, String userId, String neirong, Integer commentStatus, Date pushTime) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.neirong = neirong;
        this.commentStatus = commentStatus;
        this.pushTime = pushTime;
    }

    public UserComment() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}