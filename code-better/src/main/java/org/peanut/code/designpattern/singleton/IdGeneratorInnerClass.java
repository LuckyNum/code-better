package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 内部类单例
 *
 * @author lch
 */
public class IdGeneratorInnerClass {

    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorInnerClass() {
    }

    /**
     * 内部单例类
     */
    private static class SingletonHolder {
        private static final IdGeneratorInnerClass instance = new IdGeneratorInnerClass();
    }

    public static IdGeneratorInnerClass getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
