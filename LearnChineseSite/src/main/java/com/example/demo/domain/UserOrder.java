package com.example.demo.domain;

import java.util.Date;

public class UserOrder {
    private String id;

    private String courseId;

    private String userId;

    private Date produceTime;

    public UserOrder(String id, String courseId, String userId, Date produceTime) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.produceTime = produceTime;
    }

    public UserOrder() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }
}