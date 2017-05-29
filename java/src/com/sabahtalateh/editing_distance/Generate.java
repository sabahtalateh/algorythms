package com.sabahtalateh.editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("editing_distance_gen.txt"));
        Random random = new Random();
        int n = 10000;
        for (int i = 0; i < n; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.println();
        for (int i = 0; i < n; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.println();
        printWriter.close();
    }
}
