package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举单例
 *
 * @author lch
 */
public enum IdGeneratorEnum {
    /**
     * 单例
     */
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
