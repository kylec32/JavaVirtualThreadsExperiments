package com.scaledcode.vthreads.apicalls;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class ApiCalls {
    public static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static final int WORK_ITEMS = NUMBER_OF_PROCESSORS * 2;
    private final ExecutorService executorService;

    public ApiCalls(ExecutorService executorService) {
        this.executorService = executorService;
    }

    private final static Consumer<String> worker = (identifier) -> {
        try {
            System.out.println("Worker " + identifier + " Current thread: " + Thread.currentThread());
            new URL("https://httpstat.us/200?sleep=5000").getContent();
            System.out.println("Worker " + identifier + " Finishing with: " + Thread.currentThread());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public void execute() {
        long startTime = System.currentTimeMillis();
        System.out.println("Processing " + WORK_ITEMS + " items with " + NUMBER_OF_PROCESSORS + " threads.");
        try(ExecutorService service = executorService) {
            for(int i=0; i < WORK_ITEMS; i++) {
                String taskIdentifier = Integer.toString(i);

                service.execute(() -> worker.accept(taskIdentifier));
            }
        }
        System.out.println("Processing took: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
