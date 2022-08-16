package com.scaledcode.vthreads.topurls;

import java.util.concurrent.Executors;

public class VirtualThread {
    public static void main(String[] args) {
        new TopUrls().process(Executors.newVirtualThreadPerTaskExecutor());
    }
}
