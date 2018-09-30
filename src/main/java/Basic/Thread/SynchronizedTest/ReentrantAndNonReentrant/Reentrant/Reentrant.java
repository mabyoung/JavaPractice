package Basic.Thread.SynchronizedTest.ReentrantAndNonReentrant.Reentrant;

import java.util.concurrent.atomic.AtomicReference;

public class Reentrant {
    private AtomicReference<Thread> owner;
    private int state = 0;
    public Reentrant(AtomicReference<Thread> owner, int state){
        this.owner = owner;
        this.state = state;
    }
    public void lock(){
        Thread current = Thread.currentThread();
        if (current == owner.get()){
            state++;
            System.out.println("线程"+current+"获得重入锁");
            return;
        }
        for (;;){
            if (owner.compareAndSet(null,current)){
                System.out.println("线程"+current+"获得锁");
                return;
            }
        }
    }
    public void unlock(){
        Thread current = Thread.currentThread();
        if (current == owner.get()){
            if (state != 0){
                state--;
                System.out.println("线程"+current+"释放可重入锁");
            }else{
                owner.compareAndSet(current,null);
                System.out.println("线程"+current+"释放锁");
            }
        }
    }
}
class ReentrantLockTest extends Reentrant implements Runnable{
    @Override
    public void run() {
        lock();
        lock();
        unlock();
        unlock();
    }
    public ReentrantLockTest(AtomicReference<Thread> owner, int state){
        super(owner, state);
    }
}
class Test{
    public static void main(String[] args) {
        AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();
        new Thread(new ReentrantLockTest(threadAtomicReference,0)).start();
        new Thread(new ReentrantLockTest(threadAtomicReference,0)).start();
    }
}