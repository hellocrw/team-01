package bigdata.demo.hadoop.partition;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * K2 : Text
 * V2 : NullWritable
 *
 * K3 : Text
 * V3 : NullWritable
 */
public class PartitionerReducer extends Reducer {
    @Override
    protected void reduce(Object key, Iterable values, Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
