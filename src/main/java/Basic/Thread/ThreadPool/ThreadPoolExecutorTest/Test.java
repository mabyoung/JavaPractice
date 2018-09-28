package Basic.Thread.ThreadPool.ThreadPoolExecutorTest;

import java.util.concurrent.*;

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task" + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task" + taskNum + "执行完毕");
    }
}

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor;
//        executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());//等同于newFixedThreadPool(5);
//        executor = new ThreadPoolExecutor(1,1,0,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());//等同于newSingleThreadExecutor();
//        executor = new ThreadPoolExecutor(1,Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>());//等同于newCachedThreadPool();
        executor = new ThreadPoolExecutor(5,10,0,TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数量：" + executor.getPoolSize() + "，队列中等待执行的任务数量：" +
                    executor.getQueue().size() + "，已执行完的任务数量：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
