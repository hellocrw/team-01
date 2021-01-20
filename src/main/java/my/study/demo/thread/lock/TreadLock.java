package my.study.demo.thread.lock;

public class TreadLock implements Runnable {
    int account = 100;
    @Override
    public void run() {
        synchronized (TreadLock.class){
            account = account + 10;
            System.out.println(account);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TreadLock(),"线程1");
        Thread thread2 = new Thread(new TreadLock(),"线程1");
        thread.start();
        thread2.start();
    }

}
