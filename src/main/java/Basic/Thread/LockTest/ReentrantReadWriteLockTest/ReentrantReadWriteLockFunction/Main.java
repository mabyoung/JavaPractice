package Basic.Thread.LockTest.ReentrantReadWriteLockTest.ReentrantReadWriteLockFunction;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
