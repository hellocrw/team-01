package my.study.demo.thread.demo;

/**
 * 错误的加锁方式
 *      Integer 属于不变对象，对象一旦被创建就不可能被修改。
 *      由于多线程间，并不一定能够看到同一个i对象（因为i对象一直在变），因此两个线程每次加锁可能都加在了不同对象实例上，从而导致临界区代码控制出现问题
 */
public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            // 修改前
//            synchronized (i){
//                i++;
//            }
            // 修改后
            synchronized (instance){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
