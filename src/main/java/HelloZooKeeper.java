package java;


import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: joe22
 * @Date: 2021/6/16 16:23
 */
public class HelloZooKeeper {

    public static Stat stat = new Stat();

    public static void main(String[] args) throws IOException {

        String hostPort = "localhost:2181";
        String zpath = "/";
        String path = "/mynode";
        List<String> zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 20000, null);
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                byte[] bytes = zk.getData(path,false,  stat);
                String output = new String(bytes);
                System.out.println(output);
                System.out.println("Znodes of '/': ");
                for (String child: zooChildren) {
                    //print the children
                    ;
                    System.out.println(child);
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
