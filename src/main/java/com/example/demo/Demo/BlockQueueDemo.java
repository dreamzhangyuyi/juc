package com.example.demo.Demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(3);

//        System.out.println(blockingDeque.add("a"));
//        System.out.println(blockingDeque.add("a"));
//        System.out.println(blockingDeque.add("a"));
////        System.out.println(blockingDeque.add("a"));
//
//        blockingDeque.remove();
//        blockingDeque.remove();
//        blockingDeque.remove();
////        blockingDeque.remove();

//        System.out.println(blockingDeque.offer("a"));
//        System.out.println(blockingDeque.offer("a"));
//        System.out.println(blockingDeque.offer("a"));
//        System.out.println(blockingDeque.offer("a"));
//
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());

//        blockingDeque.put("a");
//        blockingDeque.put("a");
//        blockingDeque.put("a");
////        blockingDeque.put("a");
//
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());

        blockingDeque.offer("a");
        blockingDeque.offer("a");
        blockingDeque.offer("a");
//        blockingDeque.offer("a", 2, TimeUnit.SECONDS);

        System.out.println(blockingDeque.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingDeque.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingDeque.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingDeque.poll(2, TimeUnit.SECONDS));

    }
}
