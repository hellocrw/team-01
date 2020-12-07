package bigdata.demo.hadoop.combiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * KEYIN: K2   map阶段的key
 * VALUEIN: V2 map阶段的value
 *
 * KEYOUT: K3 reduce阶段输出的key
 * VALUEOUT: V3 reduce阶段输出的value
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    // 将K2 V2转为K3 V3,将K3 V3 写入上下文中

    /**
     *
     * @param key 新K2
     * @param values 集合，新V2
     * @param context 上下文对象
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        // 遍历集合，将集合中的数字相加，得到V3
        long count = 0;
        for(LongWritable value : values){
            count += value.get();
        }
        // 将K3 V3 写入上下文中
        context.write(key, new LongWritable(count));
    }
}
