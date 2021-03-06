package bigdata.demo.hadoop.map_join;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class MapJoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    private HashMap<String , String > map = new HashMap<>();

    // 1. 将分布式缓存的小表数据读取到本地Map集合（只执行一次）
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 获取分布式缓存列表
        URI[] cacheFiles = context.getCacheFiles();
        // 获取指定的缓存文件的文件系统（FileSystem）
        FileSystem fileSystem = FileSystem.get(cacheFiles[0], context.getConfiguration());
        // 获取文件的输入流，读取文件内容
        FSDataInputStream inputStream = fileSystem.open(new Path(cacheFiles[0]));
        // FSDDataInputStream -> BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // 读取小表文件内容，以行为单位
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            map.put(split[0], line);
        }
        inputStream.close();
        fileSystem.close();
    }


    // 2. 对大表的处理业务逻辑，实现大表和小表的join操作

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split(",");
        String productId = split[2];
        String productLine = map.get(productId);
        String valueLine= productLine + "\t" + value.toString();
        context.write(new Text(productId), new Text(valueLine));
    }
}
