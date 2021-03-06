package com.example.demo.Demo;

public class DemoTest {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        new Thread(() -> {
            synchronized (a) {
                while (!"A".equals(Thread.currentThread().getName())) {
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10; i++) {
                    synchronized (a) {
                        System.out.println(Thread.currentThread().getName());
                    }
                    b.notify();
                }
            }
        },"A").start();
        new Thread(() -> {
            synchronized (b) {
                while (!"B".equals(Thread.currentThread().getName())) {
                    try {
                        b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                c.notify();
            }
        },"B").start();
        new Thread(() -> {
            synchronized (c) {
                while (!"C".equals(Thread.currentThread().getName())) {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                a.notify();
            }
        },"C").start();

    }
}
