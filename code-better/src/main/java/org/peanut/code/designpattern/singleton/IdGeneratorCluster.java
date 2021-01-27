package org.peanut.code.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 集群唯一的
 *
 * @author lch
 */
public class IdGeneratorCluster {

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorCluster instance;
    private static SharedObjectStorage storage = new SharedObjectStorage();
    private static DistributedLock lock = new DistributedLock();

    private IdGeneratorCluster() {
    }

    public synchronized static IdGeneratorCluster getInstance() throws InstantiationException, IllegalAccessException {
        if (instance == null) {
            lock.lock();
            instance = (IdGeneratorCluster) storage.load(IdGeneratorCluster.class);

        }
        return instance;
    }

    public synchronized void freeInstance() {
        storage.save(this, IdGeneratorCluster.class);
        instance = null; //释放对象
        lock.unlock();
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
