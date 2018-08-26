package Basic.Thread.SynchronizedTest.SynchronizedClassTest;

public class ThreadB extends Thread{
    private Service service;
    ThreadB(Service service){
        super();
        this.service = service;
    }
    public void run(){
        service.printB();
    }
}
