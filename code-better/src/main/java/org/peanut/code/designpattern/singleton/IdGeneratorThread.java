package org.peanut.code.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一的
 *
 * @author lch
 */
public class IdGeneratorThread {

    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, IdGeneratorThread> instances
            = new ConcurrentHashMap<>();

    private IdGeneratorThread() {
    }

    public static IdGeneratorThread getInstance() {
        long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGeneratorThread());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
