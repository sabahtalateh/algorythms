package com.sabahtalateh.knapsack_no_repeat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("knapsak_no_repeat.txt"));
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();

        int[] gold = new int[n];

        for (int i = 0; i < n; i++) {
            gold[i] = scanner.nextInt();
        }

        System.out.println(knapsack(gold, gold, w));
    }

    private int knapsack(int weights[], int costs[], int needed) {
        int n = weights.length;
        int dp[][] = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weights[j - 1] <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - weights[j - 1]][j - 1] + costs[j - 1]);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }

        return dp[needed][n];
    }
}
