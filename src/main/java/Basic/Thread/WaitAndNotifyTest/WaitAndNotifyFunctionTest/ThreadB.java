package Basic.Thread.WaitAndNotifyTest.WaitAndNotifyFunctionTest;

public class ThreadB extends Thread{
    private Object lock;
    ThreadB(Object lock){
        super();
        this.lock = lock;
    }
    public void run(){
        try{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("已发出notify通知！但是notify()执行后并不会立即释放锁。");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
