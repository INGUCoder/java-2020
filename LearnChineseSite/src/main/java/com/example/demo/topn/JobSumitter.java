package com.example.demo.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class JobSumitter {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.addResource("xx-oo.xml");

        Job job = Job.getInstance();
        job.setJarByClass(JobSumitter.class);

        job.setMapperClass(PageTopMapper.class);
        job.setReducerClass(PageTopReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);


        FileInputFormat.setInputPaths(job,new Path("D:/mrdata/url/input"));
        FileOutputFormat.setOutputPath(job,new Path("D:/mrdata/url/output"));

        job.waitForCompletion(true);

    }

}
