package org.peanut.code.designpattern.singleton;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 多例模式一
 * 饿汉式
 *
 * @author lch
 */
public class BackendServer {

    private Long serverNo;
    private String serverAddress;

    public static final int SERVER_COUNT = 3;
    public static final Map<Long, BackendServer> serverInstance = new HashMap<>();

    static {
        serverInstance.put(1L, new BackendServer(1L, "192.168.1.1:9200"));
        serverInstance.put(2L, new BackendServer(2L, "192.168.1.2:9200"));
        serverInstance.put(3L, new BackendServer(3L, "192.168.1.3:9200"));
    }

    private BackendServer(Long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo) {
        return serverInstance.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        SecureRandom random = new SecureRandom();
        int no = random.nextInt(SERVER_COUNT) + 1;
        return serverInstance.get(no);
    }
}
