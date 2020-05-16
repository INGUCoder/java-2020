package com.example.demo.domain;

import java.util.Date;

public class vedio {
    private String id;

    private String name;

    private String pictureUrl;

    private String playUrl;

    private String courseId;

    private Date produceTime;

    private String description;

    public vedio(String id, String name, String pictureUrl, String playUrl, String courseId, Date produceTime, String description) {
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.playUrl = playUrl;
        this.courseId = courseId;
        this.produceTime = produceTime;
        this.description = description;
    }

    public vedio() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl == null ? null : playUrl.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}