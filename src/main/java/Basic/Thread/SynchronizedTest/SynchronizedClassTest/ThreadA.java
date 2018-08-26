package Basic.Thread.SynchronizedTest.SynchronizedClassTest;

public class ThreadA extends Thread{
    private Service service;
    ThreadA(Service service){
        super();
        this.service = service;
    }
    public void run(){
        super.run();
        service.printA();
    }
}
