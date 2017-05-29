package com.sabahtalateh.editing_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private String first;
    private String second;
    private int[][] d;
    private boolean[][] calculated;


    private int editingDistance(int n, int m) {
        if (n == 0 && m == 0) return 0;
        if (n == 0) return m;
        if (m == 0) return n;

        if (calculated[n][m]) return d[n][m];

        int insert = editingDistance(n, m - 1) + 1;
        int delete = editingDistance(n - 1, m) + 1;
        int change = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);

        int res = Math.min(Math.min(insert, delete), change);
        calculated[n][m] = true;
        d[n][m] = res;

        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("editing_distance.txt"));
//        Scanner scanner = new Scanner(System.in);
        first = scanner.next();
        second = scanner.next();
        d = new int[first.length() + 1][second.length() + 1];
        calculated = new boolean[first.length() + 1][second.length() + 1];
        for (boolean[] bs : calculated) {
            Arrays.fill(bs, false);
        }

        int n = first.length();
        int m = second.length();

        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {
                if (n == 0 && m == 0) d[n][m] = 0;
                else if (n == 0) d[n][m] = m;
                else if (m == 0) d[n][m] = n;
                else {
                    int insert = editingDistance(n, m - 1) + 1;
                    int delete = editingDistance(n - 1, m) + 1;
                    int change = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);

                    int res = Math.min(Math.min(insert, delete), change);
                    calculated[n][m] = true;
                    d[n][m] = res;
                }
            }
        }

//        System.out.println(first);
//        System.out.println(second);
        System.out.println(d[first.length()][second.length()]);
    }
}
