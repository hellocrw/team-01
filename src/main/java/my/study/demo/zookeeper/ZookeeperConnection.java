package my.study.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZookeeperConnection {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            /**
             * param1 : IP  param2 : 会话时间  param3 : 监听事件
             */
            ZooKeeper zooKeeper = new ZooKeeper("120.79.191.236:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState()==Event.KeeperState.SyncConnected){
                        System.out.println("连接创建成功");
                        countDownLatch.countDown();
                    }
                }
            });
            // 主线程阻塞等待连接对象的创建成功
            countDownLatch.wait();
            System.out.println(zooKeeper.getSessionId());
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
