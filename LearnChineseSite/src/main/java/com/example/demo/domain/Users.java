package com.example.demo.domain;

public class Users {
    private String id;

    private String userName;

    private String passWord;

    private String name;

    private String city;

    private String phone;

    private String email;

    private String chineseName;

    private Integer learnType;

    public Users(String id, String userName, String passWord, String name, String city, String phone, String email, String chineseName, Integer learnType) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.chineseName = chineseName;
        this.learnType = learnType;
    }

    public Users() {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public Integer getLearnType() {
        return learnType;
    }

    public void setLearnType(Integer learnType) {
        this.learnType = learnType;
    }
}