package com.example.demo.Demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplateFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("1024");
        });
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("**supplyAsync**");
            return 1024;
        });
        System.out.printf("", completableFuture1.whenComplete((t, u) -> {
            System.out.println("****t:" + t);
            System.out.println("****u:" + u);
        }).exceptionally(e -> {
            System.out.println("****exception:" + e);
            return 44;
        }).get());
    }
}
