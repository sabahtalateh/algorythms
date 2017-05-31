package com.sabahtalateh.stairs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {

//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("stairs.txt"));
        int n = scanner.nextInt();

        int[] stair = new int[n + 1];
        stair[0] = 0;

        for (int i = 0; i < n; i++) {
            stair[i + 1] = scanner.nextInt();
        }

        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = stair[1];

        for (int i = 2; i < n + 1; i++) {
            d[i] = Math.max(stair[i] + d[i - 1], stair[i] + d[i - 2]);
        }

        System.out.println(d[n]);
    }
}
