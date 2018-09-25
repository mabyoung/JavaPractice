package Basic.Thread.SynchronizedTest.ReentrantAndNonReentrant.NonReentrant;

class Lock{
    private boolean isLocked = false;
    public synchronized void lock(){
        while(isLocked){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        this.notify();
    }
}
public class Main {
    Lock lock = new Lock();
    public void print(){
        lock.lock();
        doAdd();
        lock.unlock();
    }
    public void doAdd(){
        lock.lock();
        lock.unlock();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.print();
    }
}
