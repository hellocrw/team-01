package bigdata.demo.hadoop.partition;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 自定义分区规则
 */
public class MyPartitioner extends Partitioner<Text, NullWritable> {
    @Override
    public int getPartition(Text text, NullWritable nullWritable, int i) {
        // 1. 拆分行文本数据(K2), 获取字段的值
        String[] split = text.toString().split(" ");
        String numStr = split[1];
        if (Integer.parseInt(numStr) > 5){
            return 1;
        }else {
            return 0;
        }
    }
}
