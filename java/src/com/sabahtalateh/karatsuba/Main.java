package com.sabahtalateh.karatsuba;

public class Main {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.printf("%d ms", finish - start);    
    }

    private void run() {
        int x = 11;
        int y = 10;

        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(7 >> 1));

    }
}
