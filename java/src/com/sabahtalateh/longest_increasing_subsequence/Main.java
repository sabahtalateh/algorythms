package com.sabahtalateh.longest_increasing_subsequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long end = System.currentTimeMillis();
//        System.out.printf("%d ms", end - start);
    }

    private void run() throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("longest_increasing_subsequence.txt"));
        int n = scanner.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = scanner.nextInt();
        }

        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] % seq[j]  == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = d[0];
        for (int aSolutionsLen : d) {
            max = Math.max(aSolutionsLen, max);
        }

        System.out.println(max);
    }
}
