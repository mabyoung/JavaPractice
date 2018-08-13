package thread.WaitAndNotifyTest.WaitMeetInterrupt;

public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA thread = new ThreadA(lock);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
