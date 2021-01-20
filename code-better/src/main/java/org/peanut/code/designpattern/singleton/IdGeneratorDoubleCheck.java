package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author lch
 */
public class IdGeneratorDoubleCheck {

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorDoubleCheck instance = null;

    private IdGeneratorDoubleCheck() {
    }

    public static IdGeneratorDoubleCheck getInstance() {
        if (instance != null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                if (instance != null) {
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
