package my.study.demo.thread.collectionSync;

public class ThreadGroupTest implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            Thread currentThread = Thread.currentThread();
            System.out.println("current thread : "+ currentThread.getName()
                +" thread group : "+ currentThread.getThreadGroup().getName()
                +" + parent thread group : "+ currentThread.getThreadGroup().getParent().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup rootThreadGroup = new ThreadGroup("root线程组1");
        Thread t0 = new Thread(rootThreadGroup, new ThreadGroupTest(), "Thread 0");
        t0.start();
        ThreadGroup tg = new ThreadGroup(rootThreadGroup, "线程组1");
        ThreadGroup tg2 = new ThreadGroup(rootThreadGroup, "线程组2");
        Thread t1 = new Thread(tg, new ThreadGroupTest(), "Thread 1");
        Thread t2 = new Thread(tg, new ThreadGroupTest(), "Thread 2");
        t1.start();
        t2.start();
        Thread t3 = new Thread(tg2, new ThreadGroupTest(), "Thread 3");
        Thread t4 = new Thread(tg2, new ThreadGroupTest(), "Thread 4");
        t3.start();
        t4.start();
    }
}
