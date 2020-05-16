package com.carbuybuy.carbuybuy.entity;
//用户订单
public class UserOrder {

    private Integer id;

    //用户id
    private String userId;

    //收藏的汽车id
    private Integer carId;

    //图片地址
    private String url;

    //车名
    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", carId=" + carId +
                ", url='" + url + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
