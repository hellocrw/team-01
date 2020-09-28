package crw.bishe.team.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    // 创建一个非公平锁
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread1.start();
        myThread2.start();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            new LockTest().serviceTest();
        }
    }

    public void serviceTest(){
        lock.lock();
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("TheadName="+Thread.currentThread().getName()+"(" + (i+1) + ")");
            }
        }finally {
            lock.unlock();
        }
    }
    public void test(){
        lock.lock();
        try{

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
