package thread.LockTest.ReentrantReadWriteLockTest.ReentrantReadWriteLockFunction;

public class ThreadA extends Thread{
    private Service service;
    ThreadA(Service service){
        super();
        this.service = service;
    }
    public void run(){
        service.read();
    }
}
