package bigdata.demo.hadoop.sort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * 将 K1 V1 转为 K2 V2
 */
public class sortReduce extends Reducer<Data, NullWritable, Data, NullWritable> {
    @Override
    protected void reduce(Data key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
