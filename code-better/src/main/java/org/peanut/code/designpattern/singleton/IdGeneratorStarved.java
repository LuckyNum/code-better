package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author lch
 */
public class IdGeneratorStarved {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGeneratorStarved instance = new IdGeneratorStarved();

    private IdGeneratorStarved() {
    }

    public static IdGeneratorStarved getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
