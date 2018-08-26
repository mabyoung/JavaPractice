package Basic.Thread.JoinTest.JoinFunctionTest;

public class NotUseJoin {
    public static class Mythread extends Thread{
        public void run(){
            System.out.println("我想先执行");
        }
    }

    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
}
