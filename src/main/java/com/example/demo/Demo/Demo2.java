package com.example.demo.Demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static void main(String[] args) {
        Demo2Res demo2Res = new Demo2Res();
        Demo2Res demo2Res1 = new Demo2Res();
        List list = new CopyOnWriteArrayList();
        List list1 = new Vector();
        new Thread(() -> {
            try {
                Demo2Res.sendEmail();
//                Demo2Res.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
//            demo2Res.sendSMS();
            demo2Res.sendSMS();
        }).start();
//        new Thread(() -> {
//            demo2Res.hello();
//        }).start();
    }
}
class Demo2Res {
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("----SendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("----SendSMS");
    }

    public void hello() {
        System.out.println("----Hello");
    }
}
