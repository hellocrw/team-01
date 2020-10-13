package my.study.demo.thread;

/**
 * 线程优先级
 * public final static int MIN_PRIORITY = 1;
 * public final static int NORM_PRIORITY = 5;
 * public final static int MAX_PRIORITY = 10;
 * 数字越大，优先级越高，有效范围在1 - 10之间
 */
public class PriorityDemo {
    public static class HightPriority extends Thread{
        static int count = 0;

        @Override
        public void run() {
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if (count > 10000000){
                        System.out.println("HightPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static int count = 0;

        @Override
        public void run() {
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if (count> 10000000){
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread high = new HightPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
