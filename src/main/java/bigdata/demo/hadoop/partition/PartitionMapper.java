package bigdata.demo.hadoop.partition;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * K1 : 行行偏移量 LongWritable
 * V1 : 行文本数据 Text
 *
 * K2 : 行文本数据 Text
 * V2 : NullWritable
 */
public class PartitionMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        context.write(value, NullWritable.get());
    }
}
