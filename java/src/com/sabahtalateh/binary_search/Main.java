package com.sabahtalateh.binary_search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("binary_search.txt"));
//        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        for (int i : arr2) {
            int res = binarySearch(arr1, i);
            System.out.printf("%d ", res != -1 ? res + 1 : -1);
        }
        System.out.println();
    }

    private int binarySearch(int[] arr, int what) {
        int left = 0;
        int right = arr.length - 1;

        if (arr.length == 1) {
            if (arr[0] == what) {
                return 0;
            }
            return -1;
        }

        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (arr[middle] == what) {
                return middle;
            }

            if (arr[middle] < what) {
                left = middle + 1;
            }

            if (arr[middle] > what) {
                right = middle - 1;
            }
        }

        return -1;
    }
}
