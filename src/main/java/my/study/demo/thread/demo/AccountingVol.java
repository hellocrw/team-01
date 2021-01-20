package my.study.demo.thread.demo;

/**
 * 多线程下引起的写入冲突
 * 关键字synchronized：实现线程间的同步。他的工作是对同步的代码块加锁，使得每一次只能有一个线程进入代码块，从而保证线程间的安全性。
 *       1. 指定加锁对象： 对给定对象加锁，进入同步代码前要获得给定对象的锁。
 *       2. 直接作用于实例方法： 相当于对当前实例加锁，进入同步代码前要获得当前实例的锁。
 *       3. 直接作用于静态方法： 相当于对当前类加锁，进入同步代码前要获得当前类的锁
 */
public class AccountingVol implements Runnable {
    static AccountingVol instance = new AccountingVol();
    // volatile 只能保证线程可见性，不能保证线程执行的顺序性
    static volatile int i = 0;
    // 和run()中的synchronized(instance) 作用是等价的
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            // 改进前
            // increase();
            // 改进后, 将关键字synchronized作用于一个对象instance，每当线程进入synchronized代码块，要求请求instance实例的锁。
            // 如果其他线程正持有这把锁，那么新到的线程必须等待锁的释放。
            synchronized (instance){
                i++;
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程，让两个线程都指向同一个Runnable接口实例（instance对象），这样才能保证两个线程工作时，能够关注到同一个对象锁上去，
        // 从而保证线程安全
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        // 错误写法： Thread t1 = new Thread(new AccountingSyncBad()); Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();t2.start();
        // 等待线程结束join
        t1.join();t2.join();
        System.out.println(i);
    }
}
