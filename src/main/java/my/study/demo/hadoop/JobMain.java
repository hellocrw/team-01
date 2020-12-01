package my.study.demo.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

public class JobMain extends Configured implements Tool {
    // 该方法用于指定一个job任务
    @Override
    public int run(String[] strings) throws Exception {
        // 创建一个job任务对象
        Job job = Job.getInstance(super.getConf(), "wordcount");
        // 如果打包允许出错，则添加
        job.setJarByClass(JobMain.class);
        // 配置Job任务对象（八个步骤）
        // 1. 指定文件读取方式和读取路径
        job.setInputFormatClass(TextInputFormat.class);
//        TextInputFormat.addInputPath(job, new Path("hdfs://192.168.92.135:9000/crw/a.txt"));
        TextInputFormat.addInputPath(job, new Path("file:///D:\\input\\*.txt"));
        // 2. 指定Map阶段的处理方式，自定义map逻辑
        job.setMapperClass(WordCountMapper.class);
        // 设置Map阶段的K2类型
        job.setMapOutputKeyClass(Text.class);
        // 设置Map阶段的V2类型
        job.setMapOutputValueClass(LongWritable.class);
        // 3.4.5.6 采用默认的方式
        // 7. 指定Reduce阶段的处理方式和数据类型，自定义reduce逻辑
        job.setReducerClass(WordCountReducer.class);
        // 设置K3的类型
        job.setOutputKeyClass(Text.class);
        // 设置V3的类型
        job.setMapOutputValueClass(LongWritable.class);
        // 8. 设置输出方式
        job.setOutputFormatClass(TextOutputFormat.class);
        // 设置输出路径
        Path path = new Path("file:///D:\\output");
        FileSystem fileSystem = FileSystem.get(new URI("file:///"), new Configuration());
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path, true);
        }
        // TextOutputFormat.setOutputPath(job, new Path("hdfs://192.168.92.135:9000/output1"));
        TextOutputFormat.setOutputPath(job, path);

        // 等待任务结束
        boolean wait = job.waitForCompletion(true);
        System.out.println(wait);
        return wait ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        // 启动job任务
        int run = ToolRunner.run(configuration, new JobMain(), args);
        System.exit(run);
    }
}
