package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciMod {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int mod = in.nextInt();
        System.out.println(fibMod(new BigInteger(n), mod));
    }

    public static BigInteger fibMod(BigInteger n, int mod) {
        BigInteger f0 = new BigInteger("0");
        BigInteger f1 = new BigInteger("1");

        if (n.compareTo(new BigInteger("0")) == 0) return f0.mod(BigInteger.valueOf(mod));
        if (n.compareTo(new BigInteger("1")) == 0) return f1.mod(BigInteger.valueOf(mod));

        BigInteger fn = new BigInteger("0");

        for (BigInteger i = new BigInteger("1"); i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
            fn = (f0.add(f1)).mod(BigInteger.valueOf(mod));
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
