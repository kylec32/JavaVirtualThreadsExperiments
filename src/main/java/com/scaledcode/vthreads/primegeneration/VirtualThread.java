package com.scaledcode.vthreads.primegeneration;

import java.util.concurrent.Executors;

public class VirtualThread {
    public static void main(String[] args) {
        new PrimeGeneration().process(Executors.newVirtualThreadPerTaskExecutor());
    }
}
