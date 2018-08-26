package Basic.Thread.JoinTest.JoinFunctionTest;

public class UseJoin {
    public static class Mythread extends Thread{
        public void run(){
            System.out.println("我想先执行");
        }
    }

    public static void main(String[] args) {
        NotUseJoin.Mythread mythread = new NotUseJoin.Mythread();
        mythread.start();
        /**
         * 一个线程需要等待另一个线程时使用join()方法。
         * join(long millis)、join(long millis, int nanos)两个超时方法表示，如果线程thread在指定的超时时间没有终止，那么将会从该超时方法中返回。
         */
        try {
            mythread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
}
