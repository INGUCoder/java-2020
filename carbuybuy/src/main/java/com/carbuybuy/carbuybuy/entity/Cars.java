package com.carbuybuy.carbuybuy.entity;

public class Cars {

    private Integer id;
    private String name;
    //产品介绍
    private String introduce;
    //价格区间
    private String price;
    private String url;
    //厂家
    private String fromAddress;
    //级别
    private String level;
    //能源类型
    private String costType;
    //发动机
    private String engine;
    //变速箱
    private String changeSpeed;
    //0-100KM/h加速(s)
    private String speed;
    //首页展示分类
    /**
     * 首页分类id
     * 1 热门车
     * 2 豪华车
     * 3 小型或其他
     * 4 商用车
     * 5 猜你喜欢
     * 6 搜索框下面的汽车
     */
    private Integer types;

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getType() {
        return types;
    }

    public void setType(Integer types) {
        this.types = types;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getChangeSpeed() {
        return changeSpeed;
    }

    public void setChangeSpeed(String changeSpeed) {
        this.changeSpeed = changeSpeed;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", level='" + level + '\'' +
                ", costType='" + costType + '\'' +
                ", engine='" + engine + '\'' +
                ", changeSpeed='" + changeSpeed + '\'' +
                ", speed='" + speed + '\'' +
                ", types=" + types +
                '}';
    }
}
