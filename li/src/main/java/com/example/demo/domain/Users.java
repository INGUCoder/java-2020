package com.example.demo.domain;

public class Users {
    private String id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String userEmail;

    private Integer userImit;

    private String userGroup;

    public Users(String id, String account, String password, String name, String phone, String userEmail, Integer userImit, String userGroup) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.userEmail = userEmail;
        this.userImit = userImit;
        this.userGroup = userGroup;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserImit() {
        return userImit;
    }

    public void setUserImit(Integer userImit) {
        this.userImit = userImit;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup == null ? null : userGroup.trim();
    }
}