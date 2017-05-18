package com.sabahtalateh.priority_queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
//        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));

        for (int i = 0; i < n; i++) {
            String cmd = scanner.next();
            if (cmd.equals("Insert")) {
                int number = scanner.nextInt();
                pq.add(number);
            } else {
                System.out.println(pq.poll());
            }
        }
    }
}
