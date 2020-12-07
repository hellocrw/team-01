package bigdata.demo.hadoop.reduce_join;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReduceJoinReducer extends Reducer<Text, Text, Text , Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String first = "";
        String second = "";
        // 遍历集合
        for(Text value : values) {
            if (value.toString().startsWith("p")){
                first = value.toString();
            }else {
                second += value.toString();
            }
        }
        context.write(key, new Text(first + "\t" + second));
    }
}
