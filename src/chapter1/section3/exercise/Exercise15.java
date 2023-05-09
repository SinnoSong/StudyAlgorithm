package chapter1.section3.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise15 {
    // Parameters example: 3 "A B C D E F"
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String input = args[1];
        String[] strings = input.split(" ");

        Queue<String> queue = new Queue<>();
        for (String str : strings) {
            queue.enqueue(str);
        }
        printItems(queue, k);
    }

    private static void printItems(Queue<String> queue, int k) {
        int count = 0;
        for (String item : queue) {
            count++;
            if (count == queue.size() - (k - 1)) {
                StdOut.println(item);
                break;
            }
        }
    }
}
