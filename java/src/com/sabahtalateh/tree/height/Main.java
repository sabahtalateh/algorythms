package com.sabahtalateh.tree.height;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("tree_height.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] parents = new int[n];
        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            parents[i] = val;
            nodeList.add(new Node(i));
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            if (parents[i] != -1) {
                Node child = nodeList.get(i);
                Node parent = nodeList.get(parents[i]);
                parent.addChild(child);
            } else {
                root = nodeList.get(i);
            }
        }

        System.out.println(root.calcHeight());
    }

    class Node {
        int value;
        ArrayList<Node> children = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }

        void addChild(Node n) {
            children.add(n);
        }

        public Optional<Node> find(int value) {
            return this.find(this, value);
        }

        int calcHeight() {
            return calcHeight(this);
        }

        private int calcHeight(Node node) {
            int height = 1;
            int[] childrenHeight = new int[children.size()];
            if (!node.children.isEmpty()) {
                for (int i = 0; i < children.size(); i++) {
                    childrenHeight[i] = 1 + children.get(i).calcHeight(children.get(i));
                }
            }

            if (childrenHeight.length != 0) {
                height = childrenHeight[0];
                for (int aChildrenHeight : childrenHeight) {
                    if (aChildrenHeight > height) height = aChildrenHeight;
                }
            }

            return height;
        }

        private Optional<Node> find(Node n, int value) {
            if (n.value == value) {
                return Optional.of(n);
            } else {
                for (Node node : n.children) {
                    Optional<Node> r = node.find(node, value);
                    if (!r.equals(Optional.empty())) return r;
                }
            }

            return Optional.empty();
        }

        @Override
        public String toString() {
            if (!children.isEmpty()) {
                return "N{" + value + " " + children + '}';
            } else {
                return "N{" + value + "}";
            }
        }
    }
}
