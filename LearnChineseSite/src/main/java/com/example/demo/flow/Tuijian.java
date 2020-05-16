package com.example.demo.flow;

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
import java.util.ArrayList;
import java.util.Collections;

public class Tuijian {

    public static class FriendsMapper extends Mapper<LongWritable, Text,Text,Text>{
        Text k = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            //输入 A:B,C,D,E,F
            //输出B->A C->A D->A E->A F->A
            String[] userAndFriends =  value.toString().split(":");
            String user = userAndFriends[0];
            String[] friends = userAndFriends[1].split(",");
            v.set(user);
            for (String f:friends){
                k.set(f);
                context.write(k,v);
            }
        }
    }

    public static class FriendsReducer extends Reducer<Text,Text,Text,Text>{
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            ArrayList<String> userList = new ArrayList<String>();
            for (Text user:values){
                userList.add(user.toString());
            }
            Collections.sort(userList);
            for (int i=0;i<userList.size()-1;i++){
                for (int j=1+i;j<userList.size();j++){
                    context.write(new Text(userList.get(i)+"-"+userList.get(j)),key);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(Tuijian.class);

        job.setMapperClass(FriendsMapper.class);
        job.setReducerClass(FriendsReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path("/root/data/input/friends"));
        FileOutputFormat.setOutputPath(job, new Path("/root/data/input/out"));

        job.waitForCompletion(true);


    }
}
