package Basic.Thread.WaitAndNotifyTest.WaitMeetInterrupt;

public class Main {
    public static class ThreadA extends Thread {
        public Object lock;

        ThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        public void run() {
            Service service = new Service();
            service.testMethod(lock);
        }
    }

    public static class Service {
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
