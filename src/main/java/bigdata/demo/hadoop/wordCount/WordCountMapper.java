package bigdata.demo.hadoop.wordCount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.mortbay.util.ajax.JSON;

import java.io.IOException;

/**
 * KEYIN: k1的类型 输入数据的key
 * VALUEIN: v1的类型 输入数据的value
 *
 * KEYOUT： K2的类型 输出数据的类型key
 * VALUEOUT： K2的类型 输入数据的类型value
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
        Text text = new Text();  // 定义输出类型K2 的key， 封装到context中
        LongWritable longWritable = new LongWritable(); // 定义输出类型的V2 的value ， 封装到context中

        // 将一行的文本数据进行拆分 value：文本中一行的数据
        String[] split = value.toString().split(" ");
        System.out.println(split.toString());

        // 遍历数据，组装K2 V2
        for (String word: split) {
            text.set(word);
            longWritable.set(1);

            // 将K2 V2写入上下文
            context.write(text, longWritable);
        }
    }
}
