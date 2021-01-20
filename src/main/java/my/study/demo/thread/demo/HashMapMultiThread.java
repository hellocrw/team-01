package my.study.demo.thread.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap多线程解决：
 *      使用ConcurrentHashMap代替HashMap
 */
public class HashMapMultiThread {
    static Map<String, String > map = new HashMap<>();
    public static class AddThread implements Runnable{
        int start = 0;
        public AddThread(int start){
            this.start = start;
        }
        @Override
        public void run() {
            for (int i = start; i < 1000000; i+=2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread t2 = new Thread(new HashMapMultiThread.AddThread(1));
        t1.start();
        t2.start();
        // 多线程情况下在HashMap内部数据遍历，多线程可能破坏链表成环，造成死循环（JDK 1.7）
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
