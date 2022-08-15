package com.scaledcode.vthreads.memoryusage;

import java.time.Duration;

public class VirtualThread {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            if (i%10_000 == 0) {
                System.out.println(i);
            }
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Duration.ofMinutes(10).toMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }});
        }
    }
}
