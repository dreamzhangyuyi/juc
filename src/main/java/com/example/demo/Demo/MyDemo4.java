package com.example.demo.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDemo4 {
    public static void main(String[] args) {
        Demo4Test demo4Test = new Demo4Test();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo4Test.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo4Test.decrement();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo4Test.increment();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo4Test.decrement();
            }
        }, "D").start();
    }
}

class Demo4Test {
    int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //    public synchronized void increment() throws InterruptedException {
//        if (num != 0) {
//            this.wait();
//        }
//        num++;
//        System.out.println(Thread.currentThread().getName() + " : " +num);
//        this.notifyAll();
//    }
//    public synchronized void decrement() throws InterruptedException {
//        if (num == 0) {
//            this.wait();
//        }
//        num--;
//        System.out.println(Thread.currentThread().getName() + " : " +num);
//        this.notifyAll();
//    }
    public void increment() {
        lock.lock();
        try {
          while (num != 0) {
              condition.await();
          }
          num++;
          System.out.println(Thread.currentThread().getName() + " : " +num);
          condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " : " +num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
