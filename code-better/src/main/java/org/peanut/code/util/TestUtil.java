package org.peanut.code.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class TestUtil {

    /**
     * 并发测试方法
     *
     * @param threadCount 并发线程数
     * @param consumer    待测试方法
     * @throws InterruptedException 并发异常
     */
    public static void concurrentTest(int threadCount, Consumer<Long> consumer) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(threadCount);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        ExecutorService es = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            es.execute(() -> {
                try {
                    cyclicBarrier.await();
                    consumer.accept(System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            });
        }

        cdl.await();
        es.shutdown();
    }
}
