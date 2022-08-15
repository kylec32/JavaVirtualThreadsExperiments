package com.scaledcode.vthreads;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Process {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("C:\\Users\\monkb\\Downloads\\top100k.csv"));
        OutputStream stream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\monkb\\Downloads\\top100kUrls.csv"));
        sc.useDelimiter("\r\n");
        while (sc.hasNext())  //returns a boolean value
        {
            String url = sc.next().split(",")[1];
            stream.write(url.getBytes(StandardCharsets.UTF_8));
            stream.write("\r\n".getBytes(StandardCharsets.UTF_8));
            System.out.println(url);
        }
        sc.close();  //closes the scanner

    }

}
