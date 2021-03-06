package Basic.Thread.WaitAndNotifyTest.WaitAndNotifyFunctionTest;

public class ThreadA extends Thread{
    private Object lock;
    ThreadA(Object lock){
        super();
        this.lock = lock;
    }
    public void run(){
        try {
            synchronized (lock){
                if (MyList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
