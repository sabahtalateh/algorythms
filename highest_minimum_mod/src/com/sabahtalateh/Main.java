package com.sabahtalateh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();

        System.out.println(highestMinMod(a, b));
    }

    private static long highestMinMod(long a, long b) {
        long res = 0;

        while (true) {
            if (a > b) {
                long swp = a;
                a = b;
                b = swp;

            }

            if (a == 0 || b == 0) {
                res = a + b;
                break;
            }

            if (a == b && a != 0 && b != 0) {
                res = 1;
            }

            b = b % a;
        }

        return res;
    }
}