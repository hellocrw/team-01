package my.study.demo.thread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition接口提供的基本方法：
 *  1. void await()                 使用当前线程等待，同时释放当前锁
 *  2. awitUninterruptibly()        和await()相同，但是它不会在等待过程中响应中断
 *  3. long awaitNanos(long nanosTimeout)
 *  4. boolean await(long time, TimeUnit unit)
 *  5. boolean awaitUnit(Date deadline)
 *  6. void signal()                唤醒一个线程并执行
 *  7. void signalAll()             唤醒所有等待中的线程
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition t1 = new ReenterLockCondition();
        Thread t2 = new Thread(t1);
        t2.start();
        Thread.sleep(2000);
        condition.signal();
        lock.unlock();
    }
}
