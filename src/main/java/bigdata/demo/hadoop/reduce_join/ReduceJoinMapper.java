package bigdata.demo.hadoop.reduce_join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 *
 */
public class ReduceJoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 判断数据来自哪个文件
        FileSplit fileSplit = (FileSplit) context.getInputSplit();
        String filename = fileSplit.getPath().getName();
        if (filename.equals("product.txt")){
            String[] split = value.toString().split(",");
            String productId = split[0];
            context.write(new Text(productId), value);
        }else {
            String[] split = value.toString().split(",");
            String productId = split[2];
            context.write(new Text(productId), value);
        }
    }
}
