package bigdata.demo.hadoop.sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

public class JobMain extends Configured implements Tool {
    // 该方法用于指定一个job任务
    @Override
    public int run(String[] strings) throws Exception {
        Job job = Job.getInstance(new Configuration());
        job.setMapperClass(MyMap.class);
        job.setReducerClass(sortReduce.class);
        job.setJarByClass(JobMain.class);

        job.setMapOutputKeyClass(Data.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Data.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job, "D:\\hadoop\\input\\a.txt");
        //FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.92.135:9000/crw/a.txt"));
        //Path path = new Path("hdfs://192.168.92.135:9000/output1");
        Path path = new Path("D:\\hadoop\\output");
        FileSystem fileSystem = FileSystem.get(new URI("file:///"), new Configuration());
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path, true);
        }
        TextOutputFormat.setOutputPath(job, path);

        boolean b = job.waitForCompletion(true);
        System.out.println(b);
        return b ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        // 启动job任务
        int run = ToolRunner.run(configuration, new JobMain(), args);
        System.exit(run);
    }
}
