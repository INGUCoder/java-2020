package com.carbuybuy.carbuybuy.entity;
//用户收藏
public class UserCollect {

    private Integer id;

    //用户id
    private String userId;

    //收藏的汽车id
    private Integer carId;

    //地址图片
    private String url;

    //车名
    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UserCollect{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", carId=" + carId +
                ", url='" + url + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
