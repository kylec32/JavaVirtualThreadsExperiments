package com.scaledcode.vthreads.pinnedthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i=0; i<10; i++) {
                executorService.submit(() -> {
                    try {
                        System.out.println(ClassThatPins.incrementer());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}
