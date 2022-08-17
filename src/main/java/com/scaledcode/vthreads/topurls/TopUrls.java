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
                        new URL("https://" + url).getContent();
                    } catch (IOException e) {
                    }
                });
            }
        }

        System.out.println("Processing time: " + (System.currentTimeMillis() - startTime)/1000.0f + " seconds");
    }

    private static List<String> getUrls() {
        List<String> urls = new LinkedList<>();

        var scanner = new Scanner(PlatformThread.class.getClassLoader().getResourceAsStream("top250Urls.csv"));

        while (scanner.hasNext()) {
            urls.add(scanner.next());
        }

        return urls;
    }
}
