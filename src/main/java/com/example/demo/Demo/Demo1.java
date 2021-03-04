package com.example.demo.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    public static void main(String[] args) {
        Demo1Res demo1Res = new Demo1Res();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo1Res.print1();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo1Res.print2();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo1Res.print3();
            }
        },"C").start();
    }
}
class Demo1Res {
    int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void print1() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            num=2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print2() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            num=3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            num=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
