package my.study.demo.threadPool;

import java.util.concurrent.*;

/**
 * 线程的拒绝策略
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID: " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " is discard");
                    }
                }
        );
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
