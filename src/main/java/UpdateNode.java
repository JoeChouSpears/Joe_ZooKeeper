package java;


import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @Author: joe22
 * @Date: 2021/6/16 16:24
 */
public class UpdateNode {

    private static ZooKeeper zookeeper;

    private static Stat stat = new Stat();

    private static String hostPort = "localhost:2181";

    public static void main(String[] args) throws Exception {

        byte[] bytes;

        zookeeper = new ZooKeeper(hostPort, 50000, null);

        System.out.println(zookeeper.getState().toString());

        bytes = zookeeper.getData("/mynode",null,stat);

        System.out.println("before =====" + new String(bytes));

        zookeeper.setData("/mynode", "mynode_7899".getBytes(), -1, null, null);

        bytes = zookeeper.getData("/mynode",null,stat);

        System.out.println("after =====" + new String(bytes));


    }
}
