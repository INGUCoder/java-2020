package com.carbuybuy.carbuybuy.entity;

import java.util.Date;

//订单
public class Orders {

    //订单id
    private Integer id;

    //用户id
    private String userId;

    //下订单人姓名
    private String name;

    //订单地址
    private String address;

    //订单人电话
    private String phone;

    //订单  汽车id

    private Integer carId;

    //订单时间
    private Date orderTime;

    //订单号
    private String orderId;

    //汽车名
    private String carName;

    //价格
    private String price;

    //下单账号
    private String orderForUserName;

    //状态  1 代表已下单 未完成   2 代表完成订单
    private Integer status;

    public String getOrderForUserName() {
        return orderForUserName;
    }

    public void setOrderForUserName(String orderForUserName) {
        this.orderForUserName = orderForUserName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", carId=" + carId +
                ", orderTime=" + orderTime +
                ", orderId='" + orderId + '\'' +
                ", carName='" + carName + '\'' +
                ", price='" + price + '\'' +
                ", orderForUserName='" + orderForUserName + '\'' +
                ", status=" + status +
                '}';
    }
}
