package Basic.Thread.SynchronizedTest.SynchronizedClassTest;

public class ThreadC extends Thread{
    private Service service;
    ThreadC(Service service){
        super();
        this.service = service;
    }
    public void run(){
        service.printC();
    }
}
