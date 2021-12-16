package LeetCode.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.set(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(firstJobDone.get() == 0){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.set(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(secondJobDone.get() == 0){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
