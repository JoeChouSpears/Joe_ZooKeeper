package java;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: joe22
 * @Date: 2021/6/16 16:21
 */
public class DeleteNode {

    public static Stat stat = new Stat();

    public static void main(String[] args) throws IOException {
        String hostPort = "localhost:2181";
        String path = "/test";
        String zpath = "/";
        List<String> zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 30000, null);
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                for (String child: zooChildren) {
                    System.out.println("before======="+ child);
                }
                zk.delete(path,-1);
                zooChildren = zk.getChildren(zpath, false);
                for (String child: zooChildren) {
                    System.out.println("after======="+ child);
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
