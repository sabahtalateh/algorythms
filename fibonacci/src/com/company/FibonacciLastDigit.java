package com.company;

import java.util.Scanner;

public class FibonacciLastDigit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibLastDigit(n));
    }

    public static int fibLastDigit(int n) {
        int f0 = 0;
        int f1 = 1;

        if (n == 0) return f0;
        if (n == 1) return f1;

        int fn = 0;

        for (int i = 1; i < n; i++) {
            fn = (f0 + f1) % 10;
            f0 = f1;
            f1 = fn;
        }

        return fn;
    }
}
