package LeetCode.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private AtomicInteger flag = new AtomicInteger(0);
    private int count = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (count < n) {
            while (flag.intValue() != 0 && flag.intValue() != 2 && count < n) {
                Thread.yield();
            }
            if (count < n){
                printNumber.accept(0);
                flag.set(flag.intValue()+1);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (count < n) {
            while (flag.intValue() != 3 && count < n) {
                Thread.yield();
            }
            if (count < n){
                printNumber.accept(++count);
                flag.set(0);
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (count < n) {
            while (flag.intValue() != 1 && count < n) {
                Thread.yield();
            }
            if (count < n){
                printNumber.accept(++count);
                flag.set(2);
            }
        }
    }
}
