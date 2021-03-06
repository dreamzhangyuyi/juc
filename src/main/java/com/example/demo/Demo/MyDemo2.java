package com.example.demo.Demo;

public class MyDemo2 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i< 4000; i++) {
                    ticket.saleTicket();
                }
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i< 4000; i++) {
                    ticket.saleTicket();
                }
            }
        }, "B");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i< 4000; i++) {
                    ticket.saleTicket();
                }
            }
        }, "C");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket {
    int num = 4000;
    public synchronized void saleTicket() {
        if (num > 0)
        System.out.println(Thread.currentThread().getName() + "卖出，剩余"+ --num + "张");
    }
}
