package com.sabahtalateh.points_and_ranges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
//        System.out.printf("%d ms", finish - start);
    }

    private void run() throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("points_and_ranges.txt"));
        Scanner scanner = new Scanner(System.in);
        int nRanges = scanner.nextInt();
        int nPoints = scanner.nextInt();

        ArrayList<Range> ranges = new ArrayList<>();

        for (int i = 0; i < nRanges; i++) {
            ranges.add(new Range(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < nPoints; i++) {
            int point = scanner.nextInt();
            int count = 0;
            for (Range r : ranges) {
                if (r.x <= point  && point <= r.y) {
                    count++;
                }
            }
            System.out.printf("%d ", count);
        }
        System.out.println();


    }

    class Range {
        int x;
        int y;

        Range(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Range{" + "x=" + x + ", y=" + y + '}';
        }
    }
}
