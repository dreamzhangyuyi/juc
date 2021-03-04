package com.example.demo.Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo4 {
    public static void main(String[] args) {
        Demo4Res demo4Res = new Demo4Res();
        new Thread(new FutureTask(() -> {
            demo4Res.print();
            return 1024;
        }),"A").start();

    }
}

class Demo4Res {
    public void print () {
        System.out.println("1111");
    }
}

class myThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
