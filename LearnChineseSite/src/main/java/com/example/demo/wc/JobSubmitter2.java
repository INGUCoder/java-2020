package com.example.demo.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.IOException;


public class JobSubmitter2 {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();

        conf.set("mapreduce.framework.name","yarn");
        Job job = Job.getInstance(conf);
        // 2 封装参数  本次job所需要调用的mapper实现类 reducer实现类

        job.setJarByClass(JobSubmitter2.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);
        //3 封装参数  本次job的mapper实现类 reducer实现类产生的结果数据的key value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);


        Path output = new Path("/wordcount/output");

        FileInputFormat.setInputPaths(job, new Path("/wordcount/input"));
        FileOutputFormat.setOutputPath(job, output);  // 注意：输出路径必须存在

        // 5、封装参数：想要启动的reduce task的数量
        job.setNumReduceTasks(1);

        // 6、提交job给yarn
        boolean res = job.waitForCompletion(true);
        //写脚本用的
        System.exit(res?0:-1);

    }

}
