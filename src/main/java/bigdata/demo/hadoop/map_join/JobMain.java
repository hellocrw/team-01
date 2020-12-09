package bigdata.demo.hadoop.map_join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import javax.xml.soap.Text;
import java.net.URI;

public class JobMain extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        Job job = Job.getInstance(super.getConf(), "map_join_job");
        job.addCacheFile(new URI("hdfs://192.168.92.135:9000/hadoop/input/product.txt"));
        // DistributedCache.addCacheFile(new URI("D://hadoop/input/product.txt"), super.getConf());
        // 设置输入类和输入路径
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("D://hadoop/input/product.txt"));

        // 设置Mapper类型
        job.setMapperClass(MapJoinMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setOutputFormatClass(TextOutputFormat.class);
        Path path = new Path("D:\\hadoop\\output");
        FileSystem fileSystem = FileSystem.get(new URI("file:///"), new Configuration());
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path, true);
        }
        TextOutputFormat.setOutputPath(job, path);

        boolean b = job.waitForCompletion(true);
        return b ? 0: 1;
    }

    public static void main(String[] args) throws Exception {
        Configuration conf  = new Configuration();
        int run = ToolRunner.run(conf, new JobMain(), args);
        System.exit(run);
    }
}
