package thread.LockTest.ReentrantLockTest.ConditionTest.UseMoreConditionWaitNotify;

public class Main {
    public static class ThreadA extends Thread{
        private MyserviceMoreCondition service;
        ThreadA(MyserviceMoreCondition service){
            this.service = service;
        }
        public void run(){
            service.awaitA();
        }
    }
    public static class ThreadB extends Thread{
        private MyserviceMoreCondition service;
        ThreadB(MyserviceMoreCondition service){
            this.service = service;
        }
        public void run(){
            service.awaitB();
        }
    }

    public static void main(String[] args) {
        MyserviceMoreCondition service = new MyserviceMoreCondition();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signalAll_A();
    }
}
