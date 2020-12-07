package bigdata.demo.hadoop.sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

public class Sort {

    public static class Map extends Mapper<Object , Text, IntWritable, IntWritable> {

        private static IntWritable data = new IntWritable();
        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            data.set(Integer.parseInt(line));
            context.write(data, new IntWritable(1));
        }
    }

    public static class Reduce extends Reducer<IntWritable, IntWritable , IntWritable , IntWritable> {
        private static IntWritable linenum  = new IntWritable();
        @Override
        protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            for (IntWritable val : values) {
                context.write(linenum, key);
                linenum = new IntWritable(linenum.get() + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf  = new Configuration();
        conf.set("mapred.job.tracker", "192.168.92.135:9000");
        String[] ioArgs = new String[]{"sort_in", "sort_out"};
        String[] otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
        if (otherArgs.length != 2){
            System.out.println("Usage: Data Sort <in><out>");
            System.exit(2);
        }

        Job job = new Job(conf, "Data Sort");
        job.setJarByClass(Sort.class);
        // 设置Map和Reduce处理类
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        // 设置输出类型
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);

        // 设置输入和输出目录
        FileInputFormat.addInputPath(job , new Path("hdfs://192.168.92.135:9000/" + otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.92.135:9000/" + otherArgs[1]));
        System.out.println(job.waitForCompletion(true));
        System.exit(job.waitForCompletion(true)? 0: 1);







    }
}
