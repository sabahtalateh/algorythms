package com.sabahtalateh.brackets;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("brackets.txt")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new File("brackets.txt"));
        String s = reader.readLine();
        Stack<Elem> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);
            if (isOpen(sym)) {
                stack.push(new Elem(sym, i));
            }

            if (isClose(sym)) {
                if (stack.isEmpty()) {
                    System.out.println((i + 1));
                    return;
                }
                Elem prev = stack.pop();
                if (!sameKind(prev.el, sym)) {
                    System.out.println((i + 1));
                    return;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println((stack.get(0).pos + 1));
            return;
        }

        if (stack.isEmpty()) {
            System.out.println("Success");
        }
    }

    private boolean isOpen(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private boolean isClose(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    private boolean isBracket(char c) {
        return isOpen(c) || isClose(c);
    }

    private boolean sameKind(char open, char close) {
        return (open == '[' && close == ']') || (open == '(' && close == ')') || (open == '{' && close == '}');
    }

    class Elem {
        char el;
        long pos;

        Elem(char el, long pos) {
            this.el = el;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "el=" + el +
                    ", pos=" + pos +
                    '}';
        }
    }

}
