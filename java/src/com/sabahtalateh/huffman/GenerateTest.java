package com.sabahtalateh.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateTest {
    public static void main(String[] args) throws FileNotFoundException {
        new GenerateTest().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("huffman_gen.txt"));
        Random r = new Random();
        for (int i = 0; i < 10e4; i++) {
            char c = (char) ('a' + r.nextInt(26));
            printWriter.write(c);
        }
        printWriter.close();
    }
}
