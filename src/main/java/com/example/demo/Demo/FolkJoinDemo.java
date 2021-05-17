package com.example.demo.Demo;

import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Data
class MyTask extends RecursiveTask<Integer> {
    private static final int RANGE_NUM = 10;

    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - begin <= RANGE_NUM) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            int middle = (begin+end)/2;
            MyTask task = new MyTask(begin, middle);
            MyTask task1 = new MyTask(middle+1, end);
            task.fork();
            task1.fork();
            result = task.join() + task1.join();
        }
        return result;
    }
}

public class FolkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
    }
}
