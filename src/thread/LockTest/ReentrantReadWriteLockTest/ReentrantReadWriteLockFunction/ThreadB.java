package thread.LockTest.ReentrantReadWriteLockTest.ReentrantReadWriteLockFunction;

public class ThreadB extends Thread{
    private Service service;
    ThreadB(Service service){
        this.service = service;
    }
    public void run(){
        service.read();
    }
}
