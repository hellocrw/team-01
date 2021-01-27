package my.study.demo.thread.collectionSync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListInThread implements Runnable {

    private List threadList = Collections.synchronizedList(new ArrayList());

    Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        threadList.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayListInThread list = new ArrayListInThread();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(list, String.valueOf(i));
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(list.threadList.size());

        for (int i = 0; i < list.threadList.size(); i++) {
            if (list.threadList.get(i) == null){
                System.out.println();
            }
            System.out.print(list.threadList.get(i) + " ");
        }
    }
}
