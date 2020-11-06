 package my.study.demo.CAS;

import com.sun.org.apache.xpath.internal.operations.Number;

import java.io.Serializable;

/**
 * 乐观锁常见的实现： CAS操作
 * 冲突检测 + 数据更新
 * CAS (compare and swap , 比较和替换)，三个操作数: 内存地址V， 旧的预期值A， 新的预期值B
 * 步骤：
 *      1. 当V的值和A相同时，则用新值B替换V中的值，否则不执行更新（PS： 该操作是原子性的）
 *      2. 在JDK1.5新增的java.util.concurrent(JUC)就是建立在CAS操作上的。CAS是一种非阻塞的实现（乐观锁采用一种“自旋锁”技术，
 *          原理： 如果存在竞争，则没有获得资源的线程不利己挂起，而是采用让线程执行一个忙循环(自旋)方式，等待一段时间看是否能获得锁，
 *          如果超时规定时间再挂起）。
 */
public class AtomicInteger extends Number implements Serializable {
    private volatile int value;

    public final int get(){
        return value;
    }

    public final boolean compareAndSet(int expect , int update){
//        return unsafe.compareAndSwapInt(this,valueOffset, expect, update);
        return true;
    }

    // CAS操作
    public final int getAndIncrement() {
        for (;;){
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next)) return current;
        }
    }


}
