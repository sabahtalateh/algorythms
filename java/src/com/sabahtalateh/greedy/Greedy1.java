package com.sabahtalateh.greedy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;

public class Greedy1 {
    public static void main(String[] args) {
        ArrayList<Pair<Long, Long>> sectors = new ArrayList<>();

        ArrayList<Pair<Long, Long>> noIntersectingSectors = new ArrayList<>();

        sectors.add(new Pair<>(1L, 3L));
        sectors.add(new Pair<>(4L, 7L));
        sectors.add(new Pair<>(2L, 5L));
        sectors.add(new Pair<>(5L, 6L));

        ArrayList<Long> points = new ArrayList<>();


//        while (!sectors.isEmpty()) {
        long sectorStart = sectors.get(0).getKey();
        long sectorEnd = sectors.get(0).getValue();
        System.out.println(sectorStart);
        System.out.println(sectorEnd);

        ArrayList<Integer> intersectNumbers = new ArrayList<>();

        for (int i = 1; i < sectors.size(); i++) {
            long start = sectors.get(i).getKey();
            long end = sectors.get(i).getValue();
            if (sectorStart >= start || start <= sectorEnd) {
                if (sectorEnd <= end) {
                    sectorEnd = end;
                }
            }

            if (sectorStart >= end || end <= sectorEnd) {
                if (start <= sectorStart) {
                    sectorStart = start;
                }
            }
        }

//        }

        System.out.println(sectorStart);
        System.out.println(sectorEnd);


        System.out.println(points);
        System.out.println(sectors);

    }


}
