package com.example.demo.domain;

public class SocreTotal {
    private String id;

    private String courseId;

    private String userId;

    private Float score;

    public SocreTotal(String id, String courseId, String userId, Float score) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.score = score;
    }

    public SocreTotal() {
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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}