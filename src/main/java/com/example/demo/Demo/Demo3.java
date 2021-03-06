package com.example.demo.Demo;

public class Demo3 {
    public static void main(String[] args) {
        Test t = new Test();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    t.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    t.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    t.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Test {
    private String param = "C";

    public synchronized void printA() throws InterruptedException {
        if (param.equals("C")) {
            param = "A";
            System.out.print(param);
            this.notifyAll();
        }
        this.wait();
    }

    public synchronized void printB() throws InterruptedException {
        if (param.equals("A")) {
            param = "B";
            System.out.print(param);
            this.notifyAll();
        }
        this.wait();

    }

    public synchronized void printC() throws InterruptedException {
        if (param.equals("B")) {
            param = "C";
            System.out.print(param);
            this.notifyAll();
        }
        this.wait();
    }
}
