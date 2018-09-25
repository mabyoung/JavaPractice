package Basic.Thread.SynchronizedTest.ReentrantAndNonReentrant.Reentrant;

class Lock implements Runnable{
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;
    public synchronized void lock(){
        Thread thread = Thread.currentThread();
        while(isLocked && lockedBy != thread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }
    public synchronized void unlock(){
        if (Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if (lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

    @Override
    public void run() {
        Lock lock = new Lock();
        lock.lock();
        lock.lock();
        lock.unlock();
        lock.unlock();
    }
}
public class Test{
    public static void main(String[] args) {
        Lock lock = new Lock();
        Thread thread1 = new Thread(lock);
        thread1.start();
        Thread thread2 = new Thread(lock);
        thread2.start();
    }
}
