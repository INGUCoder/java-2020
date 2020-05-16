package com.example.demo.controller.dto;

public class AnswerAndTemplateDto {
    private String id;
    private String locationName;
    private String name;
    private Integer total;
    private String type;
    private String userName;
    private Integer status;
    private String question;
    private Integer max;


    public AnswerAndTemplateDto() {

    }

    public AnswerAndTemplateDto(String id, String locationName, String name, Integer total, String type, String userName, Integer status,String question,Integer max) {
        this.id = id;
        this.locationName = locationName;
        this.name = name;
        this.total = total;
        this.type = type;
        this.userName = userName;
        this.status = status;
        this.question =question;
        this.max = max;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
