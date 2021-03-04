package com.example.demo.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        DemoRes demoRes = new DemoRes();
        new Thread(() -> {
            for (int i =0;i<10;i++) {
                try {
                    demoRes.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i =0;i<10;i++) {
                try {
                    demoRes.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i =0;i<10;i++) {
                try {
                    demoRes.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}
class DemoRes {
    int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            num = 2;
            for (int i=0;i<5;i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            num = 3;
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }
    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            num = 1;
            for (int i=0;i<15;i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
