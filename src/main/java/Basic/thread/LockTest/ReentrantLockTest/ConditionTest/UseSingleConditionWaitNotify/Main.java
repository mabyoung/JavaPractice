package Basic.thread.LockTest.ReentrantLockTest.ConditionTest.UseSingleConditionWaitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static class MyService{
        public Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private void await(){
            lock.lock();
            try {
                System.out.println("await(相当于Object类的wait方法)开始时间为" + System.currentTimeMillis());
                condition.await();
                System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        private void signal() throws InterruptedException {
            lock.lock();
            try {
                System.out.println("signal(相当于Object类的notify方法)开始时间为" + System.currentTimeMillis());
                condition.signal();
                Thread.sleep(3000);
                System.out.println("这是condition.signal()方法之后的语句");
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
            myService.await();
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread thread = new MyThread(service);
        thread.start();
        try {
            Thread.sleep(3000);
            service.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
