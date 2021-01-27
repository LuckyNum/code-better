package org.peanut.code.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 多例模式二
 *
 * @author lch
 */
public class Logger {

    public static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<>();

    private Logger() {
    }

    public static Logger getInstance(String loggerName) {
        instances.putIfAbsent(loggerName, new Logger());
        return instances.get(loggerName);
    }

    public void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance("User.class");
        Logger logger1 = Logger.getInstance("Role.class");
        Logger logger2 = Logger.getInstance("Group.class");
    }
}
