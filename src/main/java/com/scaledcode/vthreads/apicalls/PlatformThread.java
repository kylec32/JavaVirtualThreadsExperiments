package com.scaledcode.vthreads.apicalls;

import java.util.concurrent.Executors;

public class PlatformThread {
    public static void main(String[] args) {
        new ApiCalls(Executors.newFixedThreadPool(ApiCalls.NUMBER_OF_PROCESSORS)).execute();
    }
}
