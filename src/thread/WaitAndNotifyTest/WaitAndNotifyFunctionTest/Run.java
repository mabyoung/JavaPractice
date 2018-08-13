package thread.WaitAndNotifyTest.WaitAndNotifyFunctionTest;

public class Run {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.setName("A");
        threadA.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB threadB = new ThreadB(lock);
        threadB.setName("B");
        threadB.start();
    }
}
