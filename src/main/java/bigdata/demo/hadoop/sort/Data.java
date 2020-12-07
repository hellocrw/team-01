package bigdata.demo.hadoop.sort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 序列化对象
 */
@lombok.Data
public class Data implements WritableComparable<Data> {
    private String word;
    private int num;

    public void set(String word, int num) {
        this.word = word;
        this.num = num;
    }

    @Override
    public int compareTo(Data o) {
        int state = this.word.compareTo(o.word);
        if (state == 0){
            return this.num - o.num;
        }
        return state;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(word);
        dataOutput.writeInt(num);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        word = dataInput.readUTF();
        num = dataInput.readInt();
    }
}
