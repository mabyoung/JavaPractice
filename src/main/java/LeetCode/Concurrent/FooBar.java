package LeetCode.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class FooBar {
    private int n;
    private AtomicInteger value = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(value.intValue() == 1){
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            value.set(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(value.intValue() == 0){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            value.set(0);
        }
    }
}
