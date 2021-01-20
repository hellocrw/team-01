package my.study.demo.thread.sychronized;

public class MyRunablel implements Runnable {
    @Override
    public void run() {
        synchronized (MyRunablel.class){
            print();
        }
    }
    void print(){

        int num = 10;
        while (num > 0){
            System.out.println(Thread.currentThread().getName() + "开始" + "num=" + num--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }


    public static void main(String[] args) {
        MyRunablel myRunablel = new MyRunablel();
        MyRunablel myRunablel2 = new MyRunablel();
        Thread thread1 = new Thread(myRunablel, "线程1");
        Thread thread2 = new Thread(myRunablel2, "线程2");
        thread1.start();
        thread2.start();
    }
}
