package com.sabahtalateh.inversions_count;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    long invCount;

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
//        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int a[] = {1, 2, 5, 6};
        int b[] = {3, 4, 17};

        // 1 2 5 6 | 3 4 17
        // . . .     .
//        System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSort(arr);
        System.out.println(invCount);
    }

    private int[] mergeSort(int[] a) {
        if (a.length == 1) return a;
        int length = a.length;
        int middle = a.length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];
        System.arraycopy(a, 0, left, 0, middle);
        System.arraycopy(a, middle, right, 0, length - middle);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private int[] merge(int[] a, int[] b) {
        int totalLen = a.length + b.length;
        int[] result = new int[totalLen];

        int ac = 0;
        int bc = 0;

        for (int i = 0; i < totalLen; i++) {
            if (bc == b.length || (ac < a.length && a[ac] <= b[bc])) {
                result[i] = a[ac];
                ac++;
            } else {
                invCount += a.length - ac;
                result[i] = b[bc];
                bc++;
            }
        }

        return result;
    }
}
