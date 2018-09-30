package Basic.Thread.SynchronizedTest.ReentrantAndNonReentrant.NonReentrant;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 用CAS操作来模拟不可重入锁
 */
public class NonReentrantLock {
    private AtomicReference<Thread> owner;

    public NonReentrantLock(AtomicReference<Thread> owner){
        this.owner = owner;
    }

    public void lock(){
        Thread current = Thread.currentThread();
        for (;;){
            if (owner.compareAndSet(null,current)){
                System.out.println("线程"+current+"获得锁");
                return;
            }
        }
    }
    public void unlock(){
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
        System.out.println("线程"+current+"释放锁");
    }
}
class NonReentrantLockTest extends NonReentrantLock implements Runnable{
    /*同一线程两次调用lock()方法，如果不执行unlock()释放锁的话，第二次调用自旋的时候就会产生死锁，这个锁就不是可重入的。
     *而实际上同一个线程不必每次都去释放锁再来获取锁，这样的调度切换是很耗资源的。
     */
    @Override
    public void run() {
        lock();
        //unlock();
        lock();
    }

    public NonReentrantLockTest(AtomicReference<Thread> owner){
        super(owner);
    }
}
class Test{
    public static void main(String[] args) {
        AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();
        new Thread( new NonReentrantLockTest(threadAtomicReference)).start();
        new Thread( new NonReentrantLockTest(threadAtomicReference)).start();
    }
}
