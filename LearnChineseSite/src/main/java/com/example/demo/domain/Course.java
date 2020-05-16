package com.example.demo.domain;

import java.util.Date;

public class Course {
    private String id;

    private String name;

    private String teacher;

    private String category;

    private Double price;

    private Float score;

    private String url;

    private String introduce;

    private String introduceEn;

    private Date produceTime;

    public Course(String id, String name, String teacher, String category, Double price, Float score, String url, String introduce, String introduceEn, Date produceTime) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.category = category;
        this.price = price;
        this.score = score;
        this.url = url;
        this.introduce = introduce;
        this.introduceEn = introduceEn;
        this.produceTime = produceTime;
    }

    public Course() {
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getIntroduceEn() {
        return introduceEn;
    }

    public void setIntroduceEn(String introduceEn) {
        this.introduceEn = introduceEn == null ? null : introduceEn.trim();
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }
}