package com.sabahtalateh.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        ArrayList<Segment> segs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            segs.add(new Segment(scanner.nextLong(), scanner.nextLong()));
        }

//        segs.add(new Segment(4, 7));
//        segs.add(new Segment(1, 3));
//        segs.add(new Segment(2, 5));
//        segs.add(new Segment(5, 6));
//        segs.add(new Segment(1, 2));
//        segs.add(new Segment(3, 4));
//        segs.add(new Segment(0, 5));
        segs.sort((Comparator.comparingLong(o -> o.start)));

        ArrayList<Long> points = new ArrayList<>();

        int curIdx = 0;
        while (curIdx < segs.size()) {
            int nxtIdx = curIdx + 1;
            Segment cur = segs.get(curIdx);
            ArrayList<Segment> intersects = new ArrayList<>();
            intersects.add(cur);

            Segment interRange = new Segment(cur.start, cur.end);

            while (nxtIdx < segs.size()) {
                Segment nxt = segs.get(nxtIdx);
                if (nxt.start > interRange.end) {
                    break;
                }
                if (nxt.end <= interRange.end || nxt.start <= interRange.end) {
                    interRange.end = Math.min(nxt.end, interRange.end);
                    interRange.start = Math.max(nxt.start, interRange.start);
                    intersects.add(nxt);
                    nxtIdx++;
                }
            }

            Optional<Segment> minEnd = intersects.stream().min((Comparator.comparingLong(o -> o.end)));
            minEnd.ifPresent(segment -> points.add(segment.end));
            curIdx += intersects.size();
        }

        System.out.println(points.size());
        for (long p : points) {
            System.out.printf("%d ", p);
        }
    }

    class Segment {
        long start;
        long end;

        Segment(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + " : " + end + "]";
        }
    }
}
