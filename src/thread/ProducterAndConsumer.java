package thread;

public class ProducterAndConsumer{
    static int product = 0;
    static int MAX_PRODUCT = 5;
    static int MIN_PRODUCT =1;

    public static void main(String[] args) {
        new Thread(){
            public synchronized void run(){
                while (true){
                    if (ProducterAndConsumer.product >= ProducterAndConsumer.MAX_PRODUCT){
                        try {
                            System.out.println("产品已满，请停止生产");
                            notifyAll();
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    ProducterAndConsumer.product++;
                    System.out.println("生产者生产第"+ProducterAndConsumer.product+"个产品");
                    notifyAll();
                }
            };
        }.start();
        new Thread(){
            public synchronized void run(){
                while (true){
                    if (ProducterAndConsumer.product <= MIN_PRODUCT){
                        try {
                            System.out.println("缺货，请稍后再取");
                            notifyAll();
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    System.out.println("消费者取走了第"+ProducterAndConsumer.product+"个产品");
                    ProducterAndConsumer.product--;
                    notifyAll();
                }
            };
        }.start();
    }
}
