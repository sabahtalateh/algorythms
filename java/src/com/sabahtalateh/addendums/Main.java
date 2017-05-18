package com.sabahtalateh.addendums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    void run() {
        int n = new Scanner(System.in).nextInt();

        int add = 1;
        ArrayList<Integer> adds = new ArrayList<>();
        int addsCount = 0;
        while (true) {
            int residual = n - add;

            if (residual <= add) {
                adds.add(residual + add);
                break;
            }
            n = residual;
            adds.add(add++);
        }
        System.out.println(add);
        for (long l : adds) {
            if (l > 0) {
                System.out.printf("%d ", l);
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
