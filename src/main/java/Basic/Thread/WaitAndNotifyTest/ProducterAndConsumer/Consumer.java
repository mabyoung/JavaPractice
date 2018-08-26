package Basic.Thread.WaitAndNotifyTest.ProducterAndConsumer;

public class Consumer extends Base implements Runnable{
    Object lock;
    Consumer(Object lock){
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
                if (product <= MIN_PRODUCT){
                    try {
                        System.out.println("缺货，请稍后再取");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者取走了第"+product+"个产品");
                product--;
                lock.notify();
            }
        }
    }
}
