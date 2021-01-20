package my.study.demo.thread.demo;

import java.util.ArrayList;

/**
 * ArrayList由于多线程访问冲突，会使得保存容器大小的变量被多线程不正常的访问，同时两个线程也对arrayList中同一个位置进行赋值导致的。
 * 改进：
 *      1. 使用线程安全的Vector代替ArrayList
 */
public class ArrayListMultiThread {
    static ArrayList<Integer> al = new ArrayList<>(10);
    public static class addThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new addThread());
        Thread t2 = new Thread(new addThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
