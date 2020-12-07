package bigdata.demo.hadoop.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 1. k
 * 2. v
 * 3. k1
 * 4. v1
 */
public class MyMap extends Mapper<LongWritable, Text, Data, NullWritable> {
    Data data = new Data();

    /**
     *
     * @param key  source key
     * @param value  source value
     * @param context 上下文
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(" ");
        data.set(words[0], Integer.parseInt(words[1]));
        context.write(data, NullWritable.get());
    }
}
