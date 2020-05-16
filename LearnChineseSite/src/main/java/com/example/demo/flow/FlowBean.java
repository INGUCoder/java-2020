package com.example.demo.flow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements Writable {
    private int upFlow;
    private int dFlow;
    private int amountFlow;
    private String phone;

    public FlowBean() {

    }

    public FlowBean(String phone, int upFlow, int dbFlow) {
        this.upFlow = upFlow;
        this.dFlow = dbFlow;
        this.phone = phone;
        this.amountFlow = upFlow+dFlow;
    }

    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getdFlow() {
        return dFlow;
    }

    public void setdFlow(int dFlow) {
        this.dFlow = dFlow;
    }

    public int getAmountFlow() {
        return amountFlow;
    }

    public void setAmountFlow(int amountFlow) {
        this.amountFlow = amountFlow;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.phone+","+this.upFlow+","+this.dFlow+","+this.amountFlow;
    }

    /**
     *序列化
     * @param dataOutput
     * @throws IOException
     */
    public void write(DataOutput dataOutput) throws IOException {

        dataOutput.writeInt(upFlow);
        dataOutput.writeUTF(phone);
        dataOutput.writeInt(dFlow);
        dataOutput.writeInt(amountFlow);


    }


    /**
     * 反序列化
     * @param dataInput
     * @throws IOException
     */
    public void readFields(DataInput dataInput) throws IOException {

        this.upFlow = dataInput.readInt();
        this.phone = dataInput.readUTF();
        this.dFlow = dataInput.readInt();
        this.amountFlow = dataInput.readInt();



    }
}
