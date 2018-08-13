package thread.VolatileTest.VolatileAtomicityTest;

public class Mythread extends Thread{
    /**
     * volatile关键字只能保证变量的可见性，无法保证变量的原子性
     */
    private volatile static int count;
    private synchronized void addCount(){
        for (int i =0;i<100;i++){
            count = i;
        }
        System.out.println("count="+count);
    }
    public void run(){
        addCount();
    }
}


