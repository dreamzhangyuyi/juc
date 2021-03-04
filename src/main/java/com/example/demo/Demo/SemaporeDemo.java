package com.example.demo.Demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaporeDemo {
    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore(3);
//        for (int i = 0; i < 6; i++) {
//            new Thread(() -> {
//                try {
//                    semaphore.acquire();
//                    System.out.println(Thread.currentThread().getName() + "开始执行");
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println(Thread.currentThread().getName() + "执行完成");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    semaphore.release();
//                }
//            }, String.valueOf(i)).start();
//        }
        Semaphore semaphore = new Semaphore(1);
        SemaporeDemoRes semaporeDemoRes = new SemaporeDemoRes();
        new Thread(() -> {
            try {
                semaphore.acquire();
                semaporeDemoRes.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "A");
        new Thread(() -> {
            try {
                semaphore.acquire();
                semaporeDemoRes.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "B");
        new Thread(() -> {
            try {
                semaphore.acquire();
                semaporeDemoRes.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }, "C");
    }
}

class SemaporeDemoRes {
    public void print() {
        System.out.println(Thread.currentThread().getName());
    }
}
