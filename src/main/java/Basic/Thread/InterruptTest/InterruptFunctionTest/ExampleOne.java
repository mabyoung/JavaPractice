package Basic.Thread.InterruptTest.InterruptFunctionTest;

/**
 * 通常我们会有这样的需求，即停止一个线程。
 * 在java的api中有stop、suspend等方法可以达到目的，但由于这些方法在使用上存在不安全性，会带来不好的副作用，不建议被使用。
 * 在一个线程中调用另一个线程的interrupt()方法，即会向那个线程发出信号——线程中断状态已被设置。
 * 但是线程中断状态为true并不表示线程停下来了。
 */
public class ExampleOne {
    public static class MythreadA extends Thread {
        public void run() {
            super.run();
            for (int i = 1; i <= 50; i++) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("我是线程"+Thread.currentThread().getName()+"我被中断了！");
                }
                System.out.println("我是线程"+Thread.currentThread().getName()+"但是我还没停下来！i=" + i);
            }
        }
    }

    public static class MythreadB extends Thread {
        public void run() {
            super.run();
            for (int i = 1; i <= 50; i++) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("我是线程"+Thread.currentThread().getName()+"我被中断了！");
                    return;
                }
                System.out.println("我是线程"+Thread.currentThread().getName()+"但是我还没停下来！i=" + i);
            }
        }
    }

    public static void main(String[] args) {
        MythreadA mythread1 = new MythreadA();
        mythread1.setName("A");
        mythread1.start();
        mythread1.interrupt();
        MythreadB mythread2 = new MythreadB();
        mythread2.setName("B");
        mythread2.start();
        mythread2.interrupt();
    }
}
