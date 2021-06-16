package java;

import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: joe22
 * @Date: 2021/6/16 16:17
 */
public class CreateAuthString {

    public static void main(String[] args) {
        try {

            System.out.println(DigestAuthenticationProvider.generateDigest("Joe:123456#*"));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
