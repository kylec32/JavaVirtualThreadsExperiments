package com.scaledcode.vthreads.primegeneration;

import java.util.concurrent.Executors;

public class PlatformThread {
    public static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        new PrimeGeneration().process(Executors.newFixedThreadPool(NUMBER_OF_PROCESSORS));
    }
}
