package com.michael.sweet.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author michael.wang
 * @date 2019-12-19 17:02
 */
public class CacheThreadPool {
    static Random random = new Random();
    static int taskId = 0;
    static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        long i = 0;
        while (true) {
            long sleep = i > 5 ? 2000 : 50;
            service.execute(new MyThread());
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("thread " + Thread.currentThread().getName() + "is running for task:" + taskId++);
            try {
                Thread.sleep(new Long(1 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
