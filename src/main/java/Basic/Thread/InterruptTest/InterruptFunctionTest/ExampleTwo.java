package Basic.Thread.InterruptTest.InterruptFunctionTest;


public class ExampleTwo {
    /**
     * 为了更通用，我们往往会加一个开关，保证线程中断
     */
    public static class MythreadA extends Thread{
        private volatile static boolean on = true;
        public void run(){
            while(on){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("我是线程"+Thread.currentThread().getName()+"我被中断了！");
                    return;
                }else{
                    System.out.println("我是线程"+Thread.currentThread().getName()+"我还在运行！");
                }
            }
        }
    }

    public static class MythreadB extends Thread{
        private volatile static boolean on = true;
        public void run(){
            while(on){
                try {
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MythreadA mythreadA = new MythreadA();
        mythreadA.setName("A");
        mythreadA.start();
        Thread.sleep(10);
        MythreadA.on  =false;
        MythreadB mythreadB = new MythreadB();
        mythreadB.setName("B");
        mythreadB.start();
        Thread.sleep(1000);
        MythreadB.on = false;
        //线程阻塞时，没法被中断。调用interrupt()方法，可以迅速中断被阻塞的线程，抛出一个InterruptedException
        //mythreadB.interrupt();
    }
}
