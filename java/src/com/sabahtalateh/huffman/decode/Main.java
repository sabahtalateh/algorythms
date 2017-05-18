package com.sabahtalateh.huffman.decode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<String, Character> codes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String c = scanner.next();
            String code = scanner.next();
            codes.put(code, c.charAt(0));
        }

        String encoded = scanner.next();

        int pos = 0;
        StringBuilder symbol = new StringBuilder();
        StringBuilder decoded = new StringBuilder();

        while (pos < encoded.length()) {
            symbol.append(encoded.charAt(pos));
            if (codes.containsKey(symbol.toString())) {
                decoded.append(codes.get(symbol.toString()));
                symbol.setLength(0);
            }
            pos++;
        }

        System.out.println(decoded.toString());

    }
}
