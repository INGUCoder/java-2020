package com.example.demo.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PageTopReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    TreeMap<PageCount, Object> treeMap = new TreeMap<PageCount, Object>();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable value : values) {
            count += value.get();
        }
        PageCount pageCount = new PageCount();
        pageCount.set(key.toString(), count);
        treeMap.put(pageCount, values);

    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Configuration conf = context.getConfiguration();
        int topn = conf.getInt("topn", 5);
        Set<Map.Entry<PageCount, Object>> entrySet = treeMap.entrySet();
        int i = 0;
        for (Map.Entry<PageCount, Object> entry : entrySet) {
            context.write(new Text(entry.getKey().getPage()), new IntWritable(entry.getKey().getCount()));
            i++;
            if (i == topn)
                return;

        }

    }
}
