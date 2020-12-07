package bigdata.demo.hadoop.sort_demo01;

import lombok.Data;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
public class SortBean implements WritableComparable<SortBean> {

    private String word;
    private int num;

    @Override
    public String toString() {
        return word + '\t'+ num;
    }

    /**
     * 排序规则
     * @param o
     * @return
     */
    @Override
    public int compareTo(SortBean o) {
        // 先对一个列排序：word排序
        int compare = this.word.compareTo(o.word);
        if (compare == 0){
            return this.num - o.num;
        }
        return compare;
    }

    /**
     * 实现序列化
     * @param dataOutput
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(word);
        dataOutput.writeInt(num);
    }

    /**
     * 反序列化
     * @param dataInput
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.word = dataInput.readUTF();
        this.num = dataInput.readInt();
    }
}
