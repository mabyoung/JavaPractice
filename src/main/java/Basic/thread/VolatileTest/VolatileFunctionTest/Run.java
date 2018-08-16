package Basic.thread.VolatileTest.VolatileFunctionTest;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        runThread.sleep(1000);
        runThread.setRunning(false);
        System.out.println("已经赋值为false");
    }
}
