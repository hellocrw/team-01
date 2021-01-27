package my.study.demo.thread.collectionSync;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListnoSafe {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread( () -> {
                System.out.println(Thread.currentThread().getName());
                list.add(UUID.randomUUID().toString().substring(0,8));
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
