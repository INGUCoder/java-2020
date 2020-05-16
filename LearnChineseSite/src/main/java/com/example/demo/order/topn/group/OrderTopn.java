package com.example.demo.order.topn.group;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class OrderTopn {

    public static class OrderTopnMapper extends Mapper<LongWritable, Text,OrderBean, NullWritable>{
        OrderBean orderBean = new OrderBean();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split(",");
            orderBean.set(split[0],split[1],split[2],Float.parseFloat(split[3]),Integer.parseInt(split[4]));
            context.write(orderBean,NullWritable.get());
        }
    }


    public static class OrderTopnReduce extends Reducer<OrderBean,NullWritable,OrderBean,NullWritable>{
        @Override
        protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            int i = 0;
            //context.getConfiguration().getInt("topn.num",2);
            for (NullWritable value:values){
                context.write(key,value);
                if(++i==3){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        configuration.set("topn.num","3");
        Job job = Job.getInstance();
        job.setJarByClass(OrderTopn.class);


        job.setPartitionerClass(OrderIdPartitioner.class);
        job.setGroupingComparatorClass(OrderIdGroupingComparator.class);

        job.setMapperClass(OrderTopnMapper.class);
        job.setReducerClass(OrderTopnReduce.class);


        job.setNumReduceTasks(2);

        job.setMapOutputKeyClass(OrderBean.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job,new Path("D://data//input//topn"));
        FileOutputFormat.setOutputPath(job,new Path("D://data//out5"));

        job.waitForCompletion(true);




    }
}
