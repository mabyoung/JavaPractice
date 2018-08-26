package Basic.Thread.FunctionTest.CreateThread;

import DesignPattern.Factory.AbstractFactory.BaseVersion.M4A1_Factory;

/**
 * 多线程有什么好处：
 * 1.使用线程可以把占据长时间的程序中的任务放到后台去处理，比如用户要下载一个需要处理一段时间的报表文件。
 * 主线程可以先返回，避免用户长时间等待。子线程再去生成报表，生成成功后再通知用户。
 * 2.用户界面可以更加吸引人，这样比如用户点击了一个按钮去触发某些事件的处理，可以弹出一个进度条来显示处理的进度
 * 3.程序的运行速度可能加快，比如使用多线程的快速排序
 * 4.生产者消费者这种模型，必须需要多线程
 */
public class Main {
    public static class Mythread extends Thread{
        @Override
        public void run(){
            super.run();
            System.out.println("通过继承Thread类创建多线程！");
        }
    }

    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("通过实现Runnable接口创建多线程！");
        }
    }

    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
    }
}
