package my.study.demo.thread.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁： 可以反复进入的，这里的反复仅仅局限于一个线程 。
 *      提供中断处理的能力
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            // 加锁
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
            // 反复进入
            /*lock.lock();
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }*/ // 这种情况下，一个线程连续两次获得同一把锁是允许的。如果不允许这么操作，那么同一个线程在第2次获得锁时，将会和自己产生死锁。
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock t1 = new ReenterLock();
        Thread t2  = new Thread(t1);
        Thread t3  = new Thread(t1);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
        System.out.println(i);
    }
}
