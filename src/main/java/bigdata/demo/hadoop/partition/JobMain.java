package bigdata.demo.hadoop.partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

public class JobMain extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        // 创建job任务对象
        Job job = Job.getInstance(super.getConf(), "partition_maperduce");
        // job任务配置 （八大步骤）
        // 1. 设置输入类和输入路径
        job.setInputFormatClass(TextInputFormat.class);
//        TextInputFormat.addInputPath(job, new Path("hdfs://192.168.92.135:9000/crw/a.txt"));
        TextInputFormat.addInputPath(job, new Path("D:\\hadoop\\input\\a.txt"));
        // 2. 设置Mapper类和数据类型
        job.setMapperClass(PartitionMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        // 3. 指定分区类
        job.setPartitionerClass(MyPartitioner.class);

        // 4.5.6
        // 7. 指定 Reducer类和数据类型（K3 V3）
        job.setReducerClass(PartitionerReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        // 设置ReduceTask的个数
        job.setNumReduceTasks(2);

        // 8. 指定输出类和输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
// 设置输出路径
        Path path = new Path("D:\\hadoop\\output");
        FileSystem fileSystem = FileSystem.get(new URI("file:///"), new Configuration());
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path, true);
        }
        // TextOutputFormat.setOutputPath(job, new Path("hdfs://192.168.92.135:9000/output1"));
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
