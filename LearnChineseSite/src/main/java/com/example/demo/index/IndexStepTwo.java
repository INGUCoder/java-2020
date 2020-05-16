package com.example.demo.index;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class IndexStepTwo {

    public static class indexStepTwoMapper extends Mapper<LongWritable, Text,Text,Text>{

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("-");
            context.write(new Text(split[0]),new Text(split[1].replaceAll("\t","-->")));

        }
    }

    public static class indexStepTwoReducer extends Reducer<Text,Text,Text,Text>{
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            StringBuilder stringBuilder = new StringBuilder();
            for (Text value:values
                 ) {
                stringBuilder.append(value.toString()).append("\t");
            }
            context.write(key,new Text(stringBuilder.toString()));
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setJarByClass(IndexStepTwo.class);

        job.setMapperClass(indexStepTwoMapper.class);
        job.setReducerClass(indexStepTwoReducer.class);

        job.setNumReduceTasks(2);

        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);


        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);


        FileInputFormat.setInputPaths(job,new Path("D:\\data\\out1"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\data\\out2"));

        job.waitForCompletion(true);






    }








}
