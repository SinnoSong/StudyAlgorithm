package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        invertQueue(queue);

        StdOut.print("Inverted queue: ");
        for (String string : queue) {
            StdOut.print(string + " ");
        }
        StdOut.println("\nExpected: 3 2 1");
    }

    private static void invertQueue(Queue<String> queue) {
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }
}
