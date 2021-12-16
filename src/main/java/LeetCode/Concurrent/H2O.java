package LeetCode.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class H2O {

    volatile int hNum = 0;

    ReentrantLock lock = new ReentrantLock();
    // O元素 满足条件的队列
    Condition oFull = lock.newCondition();
    // H元素 满足条件的队列
    Condition hFull = lock.newCondition();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (hNum == 2) {
                hFull.signal();
                oFull.await();
            }
            releaseHydrogen.run();
            hNum++;
            if (hNum == 2) {
                hFull.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        while (hNum != 2) {
            hFull.await();
        }
        releaseOxygen.run();
        hNum = 0;
        oFull.signalAll();
        lock.unlock();
    }
}

