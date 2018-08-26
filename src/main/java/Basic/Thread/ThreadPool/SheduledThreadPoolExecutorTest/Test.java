package Basic.Thread.ThreadPool.SheduledThreadPoolExecutorTest;


import Basic.Thread.ThreadPool.ThreadPoolExecutorTest.WorkerThread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        System.out.println("current time = "+new Date());
        for (int i =0;i<3;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WorkerThread workerThread = new WorkerThread("do heavy processing");
//            scheduledExecutorService.schedule(workerThread, 10, TimeUnit.SECONDS);
//            scheduledExecutorService.scheduleAtFixedRate(workerThread, 0, 10, TimeUnit.SECONDS);
            scheduledExecutorService.scheduleWithFixedDelay(workerThread, 0, 1, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current time = "+new Date());
        scheduledExecutorService.shutdown();
        while(!scheduledExecutorService.isTerminated()){}
        System.out.println("Finished all threads");
    }
}
