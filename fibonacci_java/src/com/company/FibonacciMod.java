package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciMod {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.next());
        int mod = in.nextInt();
        System.out.println(fibMod(n, mod));
    }

    public static int fibMod(BigInteger n, int mod) {

        int f0 = 0;
        int f1 = 1;

        List<Integer> rests = new ArrayList<>();
        rests.add(f0);
        rests.add(f1);

        if (n.equals(BigInteger.ZERO)) {
            return 0;
        }

        if (n.equals(BigInteger.ONE)) {
            if (mod == 1) {return 0;}

            return 1;
        }

        int fn;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            fn = (f0 + f1) % mod;
            f0 = f1;
            f1 = fn;
            if (f0 == 0 && f1 == 1) {
                rests.remove(rests.size() - 1);
                break;
            } else {
                rests.add(fn);
            }
        }

        int offset = n.mod(BigInteger.valueOf(rests.size())).intValue();
        return rests.get(offset);
    }
}
