package bigdata.demo.hadoop.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

/**
 * 配置Job任务对象（八个步骤）
 */
public class JobMain extends Configured implements Tool {
    // 该方法用于指定一个job任务
    @Override
    public int run(String[] strings) throws Exception {
        // 创建一个job任务对象
        Job job = Job.getInstance(super.getConf(), "wordcount");
        // 设置jar存储位置
        job.setJarByClass(JobMain.class);
        // 指定Map阶段和reduce的处理方式，自定义map逻辑
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 设置Map阶段的K2类型和V2类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 设置最终输出的K3和V3的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置文件的输入路径和输出路径

         job.setInputFormatClass(TextInputFormat.class);
         job.setOutputFormatClass(TextOutputFormat.class);

         // TextInputFormat.addInputPath(job, new Path("hdfs://192.168.92.135:9000/crw/a.txt"));
        TextInputFormat.addInputPath(job, new Path("D:\\hadoop\\input\\*.txt"));

        //Path path = new Path("hdfs://192.168.92.135:9000/output1");
        Path path = new Path("D:\\hadoop\\output");
        FileSystem fileSystem = FileSystem.get(new URI("file:///"), new Configuration());
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path, true);
        }
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
