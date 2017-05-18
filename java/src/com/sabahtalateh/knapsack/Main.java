package com.sabahtalateh.knapsack;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long end = System.currentTimeMillis();
//        System.out.printf("%d ms", end - start);
    }

    private void run() throws FileNotFoundException {
//        Scanner in = new Scanner(new File("knapsack2.txt"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(in.nextInt(), in.nextInt());
        }
        Arrays.sort(items);

        double result = 0;
        for (Item item : items) {
            if (item.weight <= w) {
                result += item.cost;
                w -= item.weight;
            } else {
                result += (double) item.cost * w / item.weight;
                break;
            }
        }

        System.out.println(result);

        for (Item i : items) {
            System.out.println(i);
        }

    }

    class Item implements Comparable<Item> {
        int cost;
        int weight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
            long r1 = o.cost * weight;
            long r2 = o.weight * cost;

            return Long.compare(r1, r2);
        }
    }
}
