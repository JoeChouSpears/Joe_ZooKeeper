package java;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Author: joe22
 * @Date: 2021/6/16 16:22
 */
public class GetData {

    public static Stat stat = new Stat();

    public static void main(String[] args) throws IOException {
        String hostPort = "localhost:2181";
        String path = "/mynode";
        ZooKeeper zk = new ZooKeeper(hostPort, 20000, null);
        if (zk != null) {
            try {
                byte[] bytes = zk.getData(path,false,  stat);
                String output = new String(bytes);
                System.out.println(output);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
