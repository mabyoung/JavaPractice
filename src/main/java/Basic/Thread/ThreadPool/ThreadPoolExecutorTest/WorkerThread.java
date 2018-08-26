package Basic.Thread.ThreadPool.ThreadPoolExecutorTest;

import java.util.Date;

public class WorkerThread implements Runnable{
    private String command;
    public WorkerThread(String command){
        this.command = command;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }
    public String toString(){
        return this.command;
    }
}
