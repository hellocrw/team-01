package my.study.demo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZKCreate {

    String ip = "120.79.191.236:2181";
    ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(ip, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                }
            }
        });
        // 主线程阻塞等待连接对象的创建成功
        countDownLatch.wait();
    }
    @After
    public void after() throws Exception {
        zooKeeper.close();
    }

    @Test
    public void create1() throws Exception {
        /**
         * arg1 : 节点路径
         * arg2 : 节点数据
         * arg3 : 权限列表 world : anyone : cdrwa
         * arg4 : 节点类型  持久化节点
         */
        zooKeeper.create("/create/node1", "node1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create2() throws Exception {
        /**
         * arg1 : 节点路径
         * arg2 : 节点数据
         * arg3 : 权限列表 world : anyone : r
         * arg4 : 节点类型  持久化节点
         */
        zooKeeper.create("/create/node1", "node1".getBytes(), ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create3() throws KeeperException, InterruptedException {
        // world 授权模式
        // 权限列表
        List<ACL> acls = new ArrayList<>();
        // 权限模式和授权对象
        Id id = new Id("world", "anyone");
        // 权限设置
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        zooKeeper.create("/create/node3", "node3".getBytes(), acls, CreateMode.PERSISTENT);
    }

    @Test
    public void create4() throws Exception{
        // ip授权模式
        List<ACL> acls = new ArrayList<>();
        Id id = new Id("ip", "120.79.191.236");
        acls.add(new ACL(ZooDefs.Perms.ALL, id));
        zooKeeper.create("/create/node4", "node4".getBytes(), acls, CreateMode.PERSISTENT);
    }
}
