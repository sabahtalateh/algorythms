package com.sabahtalateh.counting_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
//        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("counting_sort.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            counts[number - 1]++;
        }

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                System.out.printf("%d ", i + 1);
            }
        }
        System.out.println();
    }
}
