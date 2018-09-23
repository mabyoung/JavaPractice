package Basic.Thread.DeadLock;

/**
 * 避免死锁的方法：
 * 1、避免一个线程同时获取多个锁
 * 2、避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源
 * 3、尝试使用定时锁，使用lock.tryLock来代替使用内置锁。
 */
class Thread1 extends Thread{
    private Object lock1;
    private Object lock2;
    public Thread1(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void run(){
        System.out.println("线程1开始执行");
        synchronized (lock1){
            System.out.println("线程1拿到锁1");
            try {
                Thread1.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println("线程1拿到锁2");
            }
        }
    }
}
class Thread2 extends Thread{
    private Object lock1;
    private Object lock2;
    public Thread2(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void run(){
        System.out.println("线程2开始执行");
        synchronized (lock2){
            System.out.println("线程2拿到锁2");
            try {
                Thread2.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                System.out.println("线程2拿到锁1");
            }
        }
    }
}
public class DeadLockTest {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread1 thread1 = new Thread1(lock1,lock2);
        Thread2 thread2 = new Thread2(lock1,lock2);
        thread1.start();
        thread2.start();
    }
}
