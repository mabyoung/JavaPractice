package Basic.Thread.WaitAndNotifyTest.WaitMeetInterrupt;

public class ThreadA extends Thread{
    public  Object lock;
    ThreadA(Object lock){
        super();
        this.lock = lock;
    }
    public void run(){
        Service service = new Service();
        service.testMethod(lock);
    }
}
