package Basic.Thread.WaitAndNotifyTest.WaitMeetInterrupt;

public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("当线程呈wait状态时，对线程对象调用interrupt方法会出现InterruptedException异常！");
        }
    }
}
