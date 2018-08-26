package Basic.Thread.LockTest.ReentrantLockTest.ReentrantLockFunctionTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
     static class MyService{
        private Lock lock = new ReentrantLock();
        private void testMethod(){
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }
        }
    }
    public static class MyThread extends Thread{
        private MyService myService;
        MyThread(MyService myService){
            super();
            this.myService = myService;
        }
        public void run(){
            myService.testMethod();
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}
