package Basic.Thread.InterruptTest.InterruptFunctionTest;

public class Main {
    public static class Mythread extends Thread {
        public void run() {
            super.run();
            for (int i = 1; i <= 5000000; i++) {
                System.out.println("i=" + i);
            }
        }
    }

    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        try {
            Thread.sleep(2000);
            mythread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
