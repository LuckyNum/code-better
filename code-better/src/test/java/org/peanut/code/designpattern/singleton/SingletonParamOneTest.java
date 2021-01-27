package org.peanut.code.designpattern.singleton;

import org.junit.Test;
import org.peanut.code.util.TestUtil;

public class SingletonParamOneTest {

    @Test
    public void getInstance() throws InterruptedException {
        TestUtil.concurrentTest(100, startTime -> {
            try {
                SingletonParamOne.init(1, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SingletonParamOne instance = SingletonParamOne.getInstance();
            System.out.println(instance);
        });
    }

    @Test
    public void init() {
    }
}