package Basic.Thread.WaitAndNotifyTest.ProducterAndConsumer;

public class Producter extends Base implements Runnable{
    Object lock;
    Producter(Object lock){
        this.lock = lock;
    }
    public void run(){
        synchronized (lock){
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (product >= MAX_PRODUCT){
                    try {
                        System.out.println("产品已满，请停止生产");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product++;
                System.out.println("生产者生产第"+product+"个产品");
                lock.notify();
            }
        }
    }
}
