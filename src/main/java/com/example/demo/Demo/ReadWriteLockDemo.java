package com.example.demo.Demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLockDemoRes readWriteLockDemoRes = new ReadWriteLockDemoRes();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                readWriteLockDemoRes.set();
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                readWriteLockDemoRes.get();
            }, String.valueOf(i)).start();
        }
    }
}

class ReadWriteLockDemoRes {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void set() {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----开始写入");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写入完成----");
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----开始读取");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取完成----");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
