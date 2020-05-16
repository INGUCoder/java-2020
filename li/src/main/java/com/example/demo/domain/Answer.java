package com.example.demo.domain;

public class Answer {
    private String id;

    private String templateId;

    private String userId;

    private String locationName;

    private Integer a1;

    private Integer a2;

    private Integer a3;

    private Integer a4;

    private Integer a5;

    private Integer a6;

    private Integer a7;

    private Integer a8;

    private Integer total;

    private Integer status;

    private Integer minScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getA1() {
        return a1;
    }

    public void setA1(Integer a1) {
        this.a1 = a1;
    }

    public Integer getA2() {
        return a2;
    }

    public void setA2(Integer a2) {
        this.a2 = a2;
    }

    public Integer getA3() {
        return a3;
    }

    public void setA3(Integer a3) {
        this.a3 = a3;
    }

    public Integer getA4() {
        return a4;
    }

    public void setA4(Integer a4) {
        this.a4 = a4;
    }

    public Integer getA5() {
        return a5;
    }

    public void setA5(Integer a5) {
        this.a5 = a5;
    }

    public Integer getA6() {
        return a6;
    }

    public void setA6(Integer a6) {
        this.a6 = a6;
    }

    public Integer getA7() {
        return a7;
    }

    public void setA7(Integer a7) {
        this.a7 = a7;
    }

    public Integer getA8() {
        return a8;
    }

    public void setA8(Integer a8) {
        this.a8 = a8;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Answer() {
        super();
    }

    public Answer(String id, String templateId, String userId, String locationName, Integer a1, Integer a2, Integer a3, Integer a4, Integer a5, Integer a6, Integer a7, Integer a8, Integer total, Integer status,Integer minScore) {
        this.id = id;
        this.templateId = templateId;
        this.userId = userId;
        this.locationName = locationName;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
        this.total = total;
        this.status = status;
        this.minScore = minScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
}