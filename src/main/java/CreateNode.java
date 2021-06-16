package java;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.*;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: joe22
 * @Date: 2021/6/16 16:20
 */
public class CreateNode {

    public static List<String> zooChildren ;
    public static String zpath = "/";
    public static String PATH = "/mynode";

    public static void main(String[] args) throws Exception {
        String hostPort = "localhost:2181";
        String newNodeName = "newCode";
        zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 20000, null);
        if (zk != null) {
            try {
                zooChildren = getChildren(zk);
                System.out.println(zooChildren);
                String path =zk.create(PATH,newNodeName.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println("return path: " + path);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String>  getChildren(ZooKeeper zk) throws Exception {
        zooChildren = zk.getChildren(zpath, false);
        return zooChildren;
    }
}
