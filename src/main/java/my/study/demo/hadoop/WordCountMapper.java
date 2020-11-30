package my.study.demo.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * KEYIN: k1的类型
 * VALUEIN: v1的类型
 *
 * KEYOUT： K2的类型
 * VALUEOUT： K2的类型
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    // map方法，将K1和V1 转为K2 和 V2

    /**
     * 如何将K1 V1 转为 K2 V2
     * @param key  K1 行偏移量
     * @param value  V1 每一行的文本数据
     * @param context 表示上下文对象
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Text text = new Text();
        LongWritable longWritable = new LongWritable();
        // 将一行的文本数据进行拆分
        String[] split = value.toString().split(",");
        // 遍历数据，组装K2 V2
        for (String word: split) {
            text.set(word);
            longWritable.set(1);
            // 将K2 V2写入上下文
            context.write(text, longWritable);
        }
    }
}
