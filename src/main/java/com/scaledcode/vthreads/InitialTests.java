package com.scaledcode.vthreads;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class InitialTests {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static final Runnable runnable = () -> {
        try {
            System.out.println(Thread.currentThread());
            System.out.println(Thread.currentThread().getThreadGroup().getName());
            Thread.sleep(Duration.ofSeconds(1));
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Work Done - " + atomicInteger.incrementAndGet());
    };

    public static void main(String[] args) {


        Instant start = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 1; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed);
    }
}
