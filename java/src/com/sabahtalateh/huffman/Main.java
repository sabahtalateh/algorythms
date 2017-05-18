package com.sabahtalateh.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    class Node implements Comparable<Node> {
        final int freq;
        String code;

        Node(int freq) {
            this.freq = freq;
        }

        void buildCode(String code) {
            this.code = code;
        }

        void buildCode() {
            buildCode("");
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(freq, node.freq);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.freq + right.freq);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class Leaf extends Node {
        char symbol;

        public Leaf(char symbol, int freq) {
            super(freq);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            this.code = code;
            System.out.println(symbol + ": " + code);
        }
    }

    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("huffman2.txt"));
        String s = scan.next();
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> freq : frequencies.entrySet()) {
            Leaf leaf = new Leaf(freq.getKey(), freq.getValue());
            charNodes.put(leaf.symbol, leaf);
            queue.add(leaf);
        }

        int sum = 0;

        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second = queue.poll();
            queue.add(new InternalNode(first, second));
            sum += first.freq + second.freq;
        }
        System.out.printf("%d %d\n", frequencies.size(), frequencies.size() == 1 ? s.length() : sum);

        Node root = queue.poll();
        if (frequencies.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(charNodes.get(s.charAt(i)).code);
//            System.out.printf("%s", charNodes.get(s.charAt(i)).code);
        }
        System.out.println(stringBuilder.toString());
    }

    private void printNode(Node n) {
        printNode(n, 0);
    }

    private void printNode(Node n, int level) {
        String indent = "|";
        for (int i = 0; i < level; i++) {
            indent += "-";
        }
        if (n instanceof InternalNode) {
            level += 1;
            System.out.println(indent + "+," + n.freq);
            printNode(((InternalNode) n).left, level);
            printNode(((InternalNode) n).right, level);
        } else if (n instanceof Leaf) {

            String s = indent + String.format("%s, %d%n", ((Leaf) n).symbol, n.freq);
            System.out.print(s);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
//        System.out.printf("%d ms", finish - start);
    }
}
