package my.study.demo.thread.collectionSync;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class VectorTest implements Runnable{

    public void A (){
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(i);
            System.out.println(JSON.toJSONString(list));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new VectorTest(), "线程1");
        Thread thread1 = new Thread(new VectorTest(), "线程2");
        thread.start();
        thread1.start();
    }

    @Override
    public void run() {
        this.A();
    }
}
