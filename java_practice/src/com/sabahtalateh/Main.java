package com.sabahtalateh;

public class Main {

    private void run() {
        int j = 0;
        for (long i = 0; i < 2500000000L; i++) {
            j += i;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().run();
        long end = System.currentTimeMillis();
        System.out.printf("%d ms\n", end - start);
    }
}
