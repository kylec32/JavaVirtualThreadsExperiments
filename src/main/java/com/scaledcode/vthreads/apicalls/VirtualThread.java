package com.scaledcode.vthreads.apicalls;

import java.util.concurrent.Executors;

public class VirtualThread {
    public static void main(String[] args) {
        new ApiCalls(Executors.newVirtualThreadPerTaskExecutor()).execute();
    }
}
