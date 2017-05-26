package com.sabahtalateh.quick_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.printf("%d ms", finish - start);
    }

    private void run() {

        int[] tt = {10, 100, 200, 300, 4, 3, 2};
        partition(tt, 0, tt.length - 1);
        System.out.println(Arrays.toString(tt));


        int[] arr = {9, 3, 18, 12, 7, 2, 7, 11};
        qSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    private void qSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(arr, l, r);
        qSort(arr, l, pivot - 1);
        qSort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int wall = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= pivot) {
                wall++;
                int temp = arr[i];
                arr[i] = arr[wall];
                arr[wall] = temp;
            }
        }

        int temp = arr[wall];
        arr[wall] = arr[l];
        arr[l] = temp;

        return wall;
    }
}
