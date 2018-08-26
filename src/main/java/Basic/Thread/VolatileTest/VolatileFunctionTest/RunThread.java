package Basic.Thread.VolatileTest.VolatileFunctionTest;

public class RunThread extends Thread {
    private int m;
    /**
     *     volatile 修饰的成员变量在每次被线程访问时，都强迫从主存（共享内存）中重读该成员变量的值。
     *     当成员变量发生变化时，强迫线程将变化值回写到主存（共享内存）。
     */
    private boolean isRunning = true;
//    private volatile boolean isRunning = true;
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning) {
            int a = 2;
            int b = 3;
            m = a + b;
            /**
             * 加上任意一个输出语句或者sleep方法,及时isRunning不是volatile的，死循环也会停止。
             * 这是因为JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字volatile。
             * 加上输出或者sleep语句之前，CPU因为死循环处于一直占用的状态，没有时间去保证内存的可见性。
             * 加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，于是while循环可以被终止。
             */
//            System.out.println(m);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(m);
        System.out.println("线程被停止了！");
    }
}
