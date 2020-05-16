package com.example.demo.domain;

public class Admin {
    private String id;

    private String userName;

    private String password;

    private String name;

    private Integer type;

    public Admin(String id, String userName, String password, String name, Integer type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.type = type;
    }

    public Admin() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}