package my.study.demo.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有运动员准备完毕");
            }
        });

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new PrepareWork(cyclicBarrier), "运动员"+i);
            list.add(thread);
            thread.start();
            if (i ==3){
                // thread.interrupt(); // 运动员3置为中断标志位
            }
        }

        Thread.sleep(2000);
        System.out.println("Barrier是否损坏："+ cyclicBarrier.isBroken());
    }

    private static class PrepareWork implements Runnable {
        private CyclicBarrier cyclicBarrier;
        public PrepareWork(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"准备完成");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断");
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName() + "抛出BrokenBarrierException异常");
                e.printStackTrace();
            }
        }
    }
}
