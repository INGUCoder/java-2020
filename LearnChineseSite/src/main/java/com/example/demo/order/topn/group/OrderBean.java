package com.example.demo.order.topn.group;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {

    private String orderId;
    private String userId;
    private String productName;
    private Float price;
    private int num;
    private Float amountPrice;

    public void set(String orderId, String userId, String productName, Float price, int num) {
        this.orderId = orderId;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.num = num;
        this.amountPrice = price * num;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Float getAmountPrice() {
        return amountPrice;
    }

    @Override
    public String toString() {
        return this.orderId + "," + this.getUserId() + "," + this.getProductName() + "," + this.getPrice() + "," + this.getNum() + "," + this.getAmountPrice();

    }

    public void setAmountPrice(Float amountPrice) {
        this.amountPrice = amountPrice;
    }

    public int compareTo(OrderBean o) {
        return this.orderId.compareTo(o.getOrderId())==0?Float.compare(this.amountPrice,o.getAmountPrice()):this.orderId.compareTo(o.getOrderId());
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.orderId);
        dataOutput.writeUTF(this.userId);
        dataOutput.writeUTF(this.productName);
        dataOutput.writeFloat(this.price);
        dataOutput.writeInt(this.num);

    }

    public void readFields(DataInput dataInput) throws IOException {
        this.orderId = dataInput.readUTF();
        this.userId = dataInput.readUTF();
        this.productName = dataInput.readUTF();
        this.price = dataInput.readFloat();
        this.num = dataInput.readInt();
        this.amountPrice = this.price * this.num;
    }
}
