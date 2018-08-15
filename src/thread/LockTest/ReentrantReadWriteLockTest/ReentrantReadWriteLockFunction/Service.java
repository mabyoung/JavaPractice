package thread.LockTest.ReentrantReadWriteLockTest.ReentrantReadWriteLockFunction;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantLock(排他锁)具有完全互斥排他的效果，即同一时刻只允许一个线程访问，这样做虽然保证了实例变量的线程安全性，但效率非常低下
 * ReentrantReadWriteLock(读写锁)维护了两个锁，一个是读操作相关的锁(共享锁)，一个是写操作相关的锁(排他锁)。通过分离读锁和写锁，其并发性比一般排他锁有了很大提升
 * 多个读锁之间不互斥，读锁与写锁互斥，写锁与写锁互斥（只要出现写操作的过程就是互斥的）
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    void read(){
        lock.readLock().lock();
        System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
            System.out.println("释放读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        }
    }
    void write(){
        lock.writeLock().lock();
        System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
            System.out.println("释放写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        }
    }
}
