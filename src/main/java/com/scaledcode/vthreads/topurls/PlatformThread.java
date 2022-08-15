package com.scaledcode.vthreads.topurls;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformThread {
    public static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        OutputStream stream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\monkb\\Downloads\\realurl.csv"));
        try (ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PROCESSORS)) {
            for (String url : getUrls()) {
                executor.execute(() -> {
                    try {
//                        System.out.println("Start processing: " + url);
                        new URL("https://" + url).getContent();
                        stream.write(url.getBytes(StandardCharsets.UTF_8));
                        System.out.println("Finished processing: " + url);
                    } catch (IOException e) {
//                        System.out.println("Issue trying to get: " + url);
                    }
                });
            }
        }

        System.out.println("Processing time: " + (System.currentTimeMillis() - startTime)/1000 + " ms");
    }

    private static List<String> getUrls() {
        var scanner = new Scanner(PlatformThread.class.getClassLoader().getResourceAsStream("top10kUrls.csv"));

        List<String> urls = new LinkedList<>();

        while (scanner.hasNext()) {
            urls.add(scanner.next());
        }

        return urls;
    }
}
