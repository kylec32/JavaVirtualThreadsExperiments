package com.scaledcode.vthreads.primegeneration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeGeneration {
    private static final int NUMBER_OF_ITERATIONS = 64;
    private static final int NUMBER_OF_PRIMES_TO_FIND = 1_0000;
    public static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public void process(ExecutorService executorService) {
        long startTime = System.currentTimeMillis();

        try (executorService) {
            for (int i=0; i<NUMBER_OF_ITERATIONS; i++) {
                executorService.submit(() -> {
                    int foundPrimes = 0;
                    int numberToTest = 3;
                    while(foundPrimes < NUMBER_OF_PRIMES_TO_FIND) {
                        if (isPrime(numberToTest)) {
                            foundPrimes++;
                        }
                        numberToTest++;
                    }
                });
            }
        }

        System.out.println("Processing took: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static boolean isPrime(int number) {
        for (int i=3; i<number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
