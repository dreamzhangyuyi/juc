package com.example.demo.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OOMDemo {
    public static void main(String[] args) throws InterruptedException {
//        List a = new ArrayList();
//        while (true) {
//            TimeUnit.MILLISECONDS.sleep(200);
//            a.add("123");
//        }
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

        String str = "dfhajskdfhjkasdhfkjhsadfhsdjhfkashdfjhasjkfdhaskjdhfajsdhfjkasdhkfuieryuwqiecbzcv";
        while (true) {
            str += str + new Random().nextInt(55555555) + new Random().nextInt(88888888);
        }
    }
}
