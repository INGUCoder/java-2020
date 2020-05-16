package com.carbuybuy.carbuybuy.admin.entity;

import java.util.Date;

public class AdminUsers {

    private Integer id;

    //用户账号
    private String name;

    //用户密码
    private String password;

    /**
     * 1  超级管理员
     * 2  普通管理员
     */
    private String userName;

    private String phone;

    /**
     * 状态  1  启用
     * 状态  2 停用
     */
    private Integer status;

    private Date date;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 管理员类型
     * 1  超级管理员
     * 2  普通管理员
     *
     */



    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AdminUsers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
