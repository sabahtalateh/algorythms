package com.sabahtalateh.haffman1;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String s = "abcddccc";

        ArrayList<Pair<Character, Integer>> freqs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < freqs.size(); i++) {
                if (freqs.get(i).getKey() == c) {
                    found = true;
                    Pair<Character, Integer> freq = freqs.get(i);
                    freq = new Pair<>(c, freq.getValue() + 1);
                    freqs.remove(i);
                    freqs.add(freq);
                    break;
                }
            }
            if (!found) {
                Pair<Character, Integer> freq = new Pair<>(c, 1);
                freqs.add(freq);
            }
        }

        freqs.sort(Comparator.comparingInt(Pair::getValue));

        PriorityQueue<Pair<Character, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        queue.addAll(freqs);

        Pair<Character, Integer> f1 = queue.poll();
        Pair<Character, Integer> f2 = queue.poll();

        System.out.println(f1);
        System.out.println(f2);

        

//        for (int i = 0; i < freqs.size() * 2 - 1; i++) {
//
//        }

//        System.out.println(queue.poll());
//        System.out.println(queue.peek());

        System.out.println(queue);


        System.out.println(freqs);
    }
}
