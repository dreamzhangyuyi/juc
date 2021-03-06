package com.example.demo.Demo;

public class MyDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName());
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName());
            }
        }, "B");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName());
            }
        }, "C");

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0 ; i < 10 ; i ++) {
//            executorService.submit(t1);
//            executorService.submit(t2);
//            executorService.submit(t3);
//        }
//        executorService.shutdown();

        for (int i = 0 ; i < 10 ; i++) {
                synchronized (t1) {
                    t1.start();
                    t1.sleep(100);
                    t1.stop();
                }
                synchronized (t2) {
                    t2.start();
                    t2.sleep(100);
                    t2.stop();
                }
                synchronized (t3) {
                    t3.start();
                    t3.sleep(100);
                    t3.stop();
                }

        }

    }
}

class printE {
    public void printA() {
        System.out.print("A");
    }
    public void printB() {
        System.out.print("B");
    }
    public void printC() {
        System.out.print("C");
    }
}
