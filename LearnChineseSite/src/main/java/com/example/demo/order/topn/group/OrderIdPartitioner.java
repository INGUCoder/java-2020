package com.example.demo.order.topn.group;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class OrderIdPartitioner extends Partitioner<OrderBean, NullWritable> {
    public int getPartition(OrderBean orderBean, NullWritable nullWritable, int i) {
        return (orderBean.getOrderId().hashCode()&Integer.MAX_VALUE)%i;
    }
}
