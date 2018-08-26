package Basic.Thread.WaitAndNotifyTest.ProducterAndConsumer;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        Producter producter = new Producter(lock);
        Thread producterThread = new Thread(producter);
        producterThread.start();
        Consumer consumer = new Consumer(lock);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
