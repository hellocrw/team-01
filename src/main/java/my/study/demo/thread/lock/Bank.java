package my.study.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private int account = 100;
    // private Lock lock = new ReentrantLock();

    public void deposit(int money){
        System.out.println("start lock");
        // lock.lock();
        try {
            System.out.println("inner lock");
            account += money;
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // lock.unlock();
            System.out.println("end lock");
        }
    }

    public int getAccount(){
        return account;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposit(10);
        bank.deposit(10);
        int account = bank.getAccount();
        System.out.println(account);
    }
}
