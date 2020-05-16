package com.example.demo.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 1 封装本次job 运行时 所需要的必要参数
 * 2 跟yarn 进行交互  将mapreduce程序成功的启动  运行
 */
public class jobSubmitter {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException, ClassNotFoundException {
        // 在代码中设置jvm参数 用于给job对象来访问hdfs的用户身份
        System.setProperty("HADOOP_USER_NAME","root");

        Configuration conf = new Configuration();
        //1 设置job运行 要访问的默认文件系统
        conf.set("fs.defaultFS","hdfs://47.97.90.207:9000");
        //2 设置job要提交到哪里去运行
        conf.set("mapreduce.framework.name","yarn");
        conf.set("yarn.resourcemanager.hostname","47.97.90.207");
        //3 如果要从windows系统上运行这个job提交客户端程序 则需要加上跨平台参数
        conf.set("mapreduce.app-submission.cross-platform","true");
// wc.jobSubmitter


        Job job = Job.getInstance(conf);
        //1封装参数:jar包所在位置
        job.setJar("D://wc.jar");
        // 2 封装参数  本次job所需要调用的mapper实现类 reducer实现类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);
        //3 封装参数  本次job的mapper实现类 reducer实现类产生的结果数据的key value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        Path output = new Path("/wordcount/output");
        FileSystem fs = FileSystem.get(new URI("hdfs://47.97.90.207:9000"),conf,"root");
        if(fs.exists(output)){
            fs.delete(output,true);
        }
        System.out.println("test");    //4 封装参数 本次job要处理的输入数据集所在路径  最终结果的输出位置
        FileInputFormat.setInputPaths(job, new Path("/wordcount/input"));
        FileOutputFormat.setOutputPath(job, output);  // 注意：输出路径必须不存在

        // 5、封装参数：想要启动的reduce task的数量
        job.setNumReduceTasks(1);

        // 6、提交job给yarn
        boolean res = job.waitForCompletion(true);
        //写脚本用的
        System.exit(res?0:-1);

    }


}
