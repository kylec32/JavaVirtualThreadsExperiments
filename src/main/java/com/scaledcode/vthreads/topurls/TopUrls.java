package com.scaledcode.vthreads.topurls;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TopUrls {
    public void process(ExecutorService executorService) {
        long startTime = System.currentTimeMillis();
        try (ExecutorService executor = executorService) {
            for (String url : getUrls()) {
                executor.execute(() -> {
                    try {
//                        System.out.println("Start processing: " + url);
                        new URL("https://" + url).getContent();
                        System.out.println("Finished processing: " + url);
                    } catch (IOException e) {
//                        System.out.println("Issue trying to get: " + url);
                    }
                });
            }
        }

        System.out.println("Processing time: " + (System.currentTimeMillis() - startTime)/1000.0f + " seconds");

    }

    private static List<String> getUrls() {
        var scanner = new Scanner(PlatformThread.class.getClassLoader().getResourceAsStream("top250Urls.csv"));

        List<String> urls = new LinkedList<>();

        while (scanner.hasNext()) {
            urls.add(scanner.next());
        }

        return urls;
    }
}
