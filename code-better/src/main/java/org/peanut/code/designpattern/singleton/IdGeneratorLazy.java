package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author lch
 */
public class IdGeneratorLazy {

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorLazy instance = null;

    private IdGeneratorLazy() {
    }

    public synchronized static IdGeneratorLazy getInstance() {
        if (instance != null) {
            instance = new IdGeneratorLazy();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
