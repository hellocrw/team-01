package my.study.demo.threadPool;

import java.util.concurrent.*;

public class CreateThreadPoolDemo {
    public static void main(String[] args) {
    ThreadPoolDemo.MyTask task = new ThreadPoolDemo.MyTask();
    ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    System.out.println("create " + t);
                    return t;
                }
            });
        for(int i = 0; i< 5;i++) {
            es.submit(task);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
