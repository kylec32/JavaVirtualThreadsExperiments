package com.scaledcode.vthreads.pinnedthreads;

public class ClassThatPins {
    private static volatile int value = 0;
    public synchronized static int incrementer() throws InterruptedException {
        Thread.sleep(5000);
        return value++;
    }
}
