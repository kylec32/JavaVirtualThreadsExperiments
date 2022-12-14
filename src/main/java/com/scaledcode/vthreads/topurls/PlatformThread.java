package com.scaledcode.vthreads.topurls;

import java.util.concurrent.Executors;

public class PlatformThread {
    public static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        new TopUrls().process(Executors.newFixedThreadPool(NUMBER_OF_PROCESSORS));
    }
}
