package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int num = 50;
        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }
        for (int n : stack) {
            StdOut.print(n);
        }
        StdOut.println();
    }
}
