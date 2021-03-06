package com.example.demo.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo5 {
}

class Demo5Test {
    String param  = "";
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void print() {
        lock.lock();
        try {
            while("A".equals(Thread.currentThread().getName())) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
